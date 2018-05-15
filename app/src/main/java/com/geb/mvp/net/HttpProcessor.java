package com.geb.mvp.net;

import java.util.Map;

public interface HttpProcessor {

    void get(String url, Map<String, Object> params, NetCallback callback);

    void post(String url, Map<String, Object> params, NetCallback callback);


}
