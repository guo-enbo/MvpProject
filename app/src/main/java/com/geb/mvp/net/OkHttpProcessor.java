package com.geb.mvp.net;

import android.os.Handler;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static java.lang.String.valueOf;

/**
 * Created by guoenbo on 2018/4/23.
 */

public class OkHttpProcessor implements HttpProcessor {

    private OkHttpClient client;
    private Handler handler = new Handler();

    public OkHttpProcessor() {
        client = new OkHttpClient.Builder()
                .connectTimeout(4000, TimeUnit.MILLISECONDS)
                .readTimeout(4000, TimeUnit.MILLISECONDS)
                .writeTimeout(4000, TimeUnit.MILLISECONDS)
                .build();
    }

    @Override
    public void get(String url, Map<String, Object> params, final NetCallback callback) {

        Request request = new Request.Builder()
                .url(appendParams(url,params))
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e,"数据解析异常");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.isSuccessful()) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                callback.onSuccess(response.code(), response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            callback.onFailure(response.code(), response.message());

                        }
                    });
                }


            }
        });
    }

    @Override
    public void post(String url, Map<String, Object> params, final NetCallback callback) {
        final Map<String, Object> map = new HashMap<>();
        final Map<String, File> files = new HashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() instanceof File) {
                files.put(entry.getKey(), (File) entry.getValue());
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }

        // form 表单形式上传
        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (!files.isEmpty()) {

            Set<Map.Entry<String, File>> entries = files.entrySet();
            for (Map.Entry entry : entries) {
                // MediaType.parse() 里面是上传的文件类型。
                RequestBody body = RequestBody.create(MediaType.parse("image/*"), (File) entry.getValue());
                String filename = ((File) entry.getValue()).getName();
                // 参数分别为， 请求key ，文件名称 ， RequestBody
                requestBody.addFormDataPart(entry.getKey().toString(), filename, body);
            }

        }
        if (!map.isEmpty()) {
            // map 里面是请求中所需要的 key 和 value
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            for (Map.Entry entry : entries) {
                String key = valueOf(entry.getKey());
                String value = valueOf(entry.getValue());
                requestBody.addFormDataPart(key, value);
            }
        }
        Request request = new Request.Builder().url(url).post(requestBody.build()).build();
        // readTimeout("请求超时时间" , 时间单位);
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e,"数据解析异常");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.isSuccessful()) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                callback.onSuccess(response.code(), response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(response.code(), response.message());
                        }
                    });
                }


            }
        });
    }

    /**
     * 自动组装请求参数
     * */
    public String appendParams(String url, Map<String, Object> params) {
        if(params.isEmpty() || params == null){
            return url;
        }
        StringBuffer stringBuffer = new StringBuffer(url); // 存储封装好的请求体信息
        if(stringBuffer.indexOf("?") <= 0){
            stringBuffer.append("?");
        } else {
            if(!stringBuffer.toString().endsWith("?")){
                stringBuffer.append("&");
            }
        }
        try {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                stringBuffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(),"utf-8")).append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1); // 删除最后的一个"&"
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

}
