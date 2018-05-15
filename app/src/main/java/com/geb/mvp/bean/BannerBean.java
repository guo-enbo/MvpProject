package com.geb.mvp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guoenbo on 2018/4/23.
 */

public class BannerBean implements Serializable {

    /**
     * errcode : 0
     * errmsg : ok
     * count : 3
     * list : [{"id":"7","name":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524133258205&di=f785e71c2f1b985299ed05c73b2552a8&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F11%2F37%2F54%2F35458PICTxi.jpg","url":"#","state":"0","type":"0"},{"id":"8","name":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524133258205&di=97f5994ad9dd9d049b9f04d5e3f0ed4c&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ff9dcd100baa1cd112723220bb212c8fcc3ce2d07.jpg","url":"#","state":"0","type":"0"},{"id":"9","name":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524133258204&di=81e1ec19046821f4e15b621b5b2b4cda&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3D76ba6edfa66eddc432eabcbb50a3d391%2F024f78f0f736afc3017f7f5fb819ebc4b745129c.jpg","url":"#","state":"0","type":"0"}]
     */

    private String errcode;
    private String errmsg;
    private String count;
    private List<ListBean> list;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", count='" + count + '\'' +
                ", list=" + list +
                '}';
    }

    public static class ListBean {
        /**
         * id : 7
         * name : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524133258205&di=f785e71c2f1b985299ed05c73b2552a8&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F11%2F37%2F54%2F35458PICTxi.jpg
         * url : #
         * state : 0
         * type : 0
         */

        private String id;
        private String name;
        private String url;
        private String state;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    ", state='" + state + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}
