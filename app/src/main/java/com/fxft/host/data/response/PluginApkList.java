package com.fxft.host.data.response;

import java.util.List;

/**
 * Created by hzl520 on 2017/8/13.
 * 插件
 */
public class PluginApkList extends BaseResponse{

    /**
     * data : [{"id":1,"pluginName":"demo1","pluginClass":"demo1","pluginTitle":"demo1","pluginDetail":"demo1","pluginDownloadUrl":"apks/1502526004225.jar","pluginApkSize":"5","pluginTime":"2017/08/12 16:20"}]
     * errorcode : 0
     * errormsg : 请求成功！
     * total : 1
     */
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * pluginName : demo1
         * pluginClass : demo1
         * pluginTitle : demo1
         * pluginDetail : demo1
         * pluginDownloadUrl : apks/1502526004225.jar
         * pluginApkSize : 5
         * pluginTime : 2017/08/12 16:20
         */

        private int id;
        private String pluginName;
        private String pluginClass;
        private String pluginTitle;
        private String pluginDetail;
        private String pluginDownloadUrl;
        private String pluginApkSize;
        private String pluginTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPluginName() {
            return pluginName;
        }

        public void setPluginName(String pluginName) {
            this.pluginName = pluginName;
        }

        public String getPluginClass() {
            return pluginClass;
        }

        public void setPluginClass(String pluginClass) {
            this.pluginClass = pluginClass;
        }

        public String getPluginTitle() {
            return pluginTitle;
        }

        public void setPluginTitle(String pluginTitle) {
            this.pluginTitle = pluginTitle;
        }

        public String getPluginDetail() {
            return pluginDetail;
        }

        public void setPluginDetail(String pluginDetail) {
            this.pluginDetail = pluginDetail;
        }

        public String getPluginDownloadUrl() {
            return pluginDownloadUrl;
        }

        public void setPluginDownloadUrl(String pluginDownloadUrl) {
            this.pluginDownloadUrl = pluginDownloadUrl;
        }

        public String getPluginApkSize() {
            return pluginApkSize;
        }

        public void setPluginApkSize(String pluginApkSize) {
            this.pluginApkSize = pluginApkSize;
        }

        public String getPluginTime() {
            return pluginTime;
        }

        public void setPluginTime(String pluginTime) {
            this.pluginTime = pluginTime;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", pluginName='" + pluginName + '\'' +
                    ", pluginClass='" + pluginClass + '\'' +
                    ", pluginTitle='" + pluginTitle + '\'' +
                    ", pluginDetail='" + pluginDetail + '\'' +
                    ", pluginDownloadUrl='" + pluginDownloadUrl + '\'' +
                    ", pluginApkSize='" + pluginApkSize + '\'' +
                    ", pluginTime='" + pluginTime + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PluginApkList{" +
                "data=" + data +
                '}';
    }
}
