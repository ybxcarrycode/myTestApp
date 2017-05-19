package com.ybxcc.testinysx.mytestapp.bean;

import java.util.List;

/**
 * Created by Ybx on 2017/5/19.
 */

public class RetrofitTestBean {

    /**
     * error : false
     * results : [{"_id":"58f429a5421aa9544825f88a","createdAt":"2017-04-17T10:34:13.180Z","desc":"Android Tag Chip 效果，做的非常细腻，完全的 Material Design。","images":["http://img.gank.io/6e1eaf48-4277-46dc-b97b-f05a5261223b"],"publishedAt":"2017-04-17T11:32:14.674Z","source":"chrome","type":"Android","url":"https://github.com/pchmn/MaterialChipsInput","used":true,"who":"代码家"},{"_id":"58ef1a55421aa9544ed88936","createdAt":"2017-04-13T14:27:33.889Z","desc":"java8 以下，使用Stream Api。","publishedAt":"2017-04-14T11:46:48.47Z","source":"web","type":"Android","url":"https://github.com/aNNiMON/Lightweight-Stream-API","used":true,"who":"瘦纸好过夏"},{"_id":"58ef1b1a421aa9544b773fd3","createdAt":"2017-04-13T14:30:50.522Z","desc":"Android Toast 原理分析","publishedAt":"2017-04-14T11:46:48.47Z","source":"web","type":"Android","url":"http://qlm.pw/2017/04/13/android-toast-%E5%8E%9F%E7%90%86%E5%88%86%E6%9E%90/","used":true,"who":"Linmin Qiu"},{"_id":"58efa248421aa954511ebe7e","createdAt":"2017-04-14T00:07:36.366Z","desc":"展示 Android 程序方法调用链的 gralde 插件，支持输出html文件和方法折叠","images":["http://img.gank.io/9be64918-c259-4f81-9ab5-341293a74fe4"],"publishedAt":"2017-04-14T11:46:48.47Z","source":"web","type":"Android","url":"https://github.com/CoXier/AppMethodTracking","used":true,"who":"CoXier"},{"_id":"58f01f07421aa954511ebe7f","createdAt":"2017-04-14T08:59:51.702Z","desc":"一个简单的 SQLite 和 Excel 互相转换的库子","publishedAt":"2017-04-14T11:46:48.47Z","source":"web","type":"Android","url":"https://github.com/li-yu/SQLiteToExcel","used":true,"who":"liyu"},{"_id":"58f04302421aa9544b773fdc","createdAt":"2017-04-14T11:33:22.130Z","desc":"遮罩对比图效果组件","images":["http://img.gank.io/6becd3af-df53-4935-bbd9-1099aae74ec6"],"publishedAt":"2017-04-14T11:46:48.47Z","source":"chrome","type":"Android","url":"https://github.com/pavel163/BifacialView","used":true,"who":"代码家"},{"_id":"58de5542421aa969fd8a3df9","createdAt":"2017-03-31T21:10:26.504Z","desc":"第三方SDK集成库(授权/分享/支付)","publishedAt":"2017-04-13T11:36:04.435Z","source":"web","type":"Android","url":"https://github.com/czy1121/sdk3rd","used":true,"who":"ezy"},{"_id":"58ee4ec5421aa9544ed8892d","createdAt":"2017-04-12T23:59:01.200Z","desc":"震惊！一程序员竟然用这么简单的代码实现了条形码和二维码扫描！","images":["http://img.gank.io/33d64122-d254-47e0-9dda-82760af638e5"],"publishedAt":"2017-04-13T11:36:04.435Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/2bea07e0c1b9","used":true,"who":"黎赵太郎"},{"_id":"58eeed8a421aa9544b773fcd","createdAt":"2017-04-13T11:16:26.242Z","desc":"拥有更好效果的 LineHeight TextView","images":["http://img.gank.io/0b47c973-7107-4a51-9f14-2a4de019dcf2"],"publishedAt":"2017-04-13T11:36:04.435Z","source":"chrome","type":"Android","url":"https://github.com/hanks-zyh/LineHeightEditText","used":true,"who":"代码家"},{"_id":"58ed9624421aa9544825f85b","createdAt":"2017-04-12T10:51:16.759Z","desc":"React-native 实现的 Android BottomSheetBehavior 效果","images":["http://img.gank.io/475bb89a-a9c1-4464-adea-8ce583f7a14a"],"publishedAt":"2017-04-12T12:12:18.213Z","source":"chrome","type":"Android","url":"https://github.com/cesardeazevedo/react-native-bottom-sheet-behavior","used":true,"who":"代码家"}]
     */

    private boolean error;
    private String errorTest;

    public String getErrorTest() {
        return errorTest;
    }

    public void setErrorTest(String errorTest) {
        this.errorTest = errorTest;
    }

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 58f429a5421aa9544825f88a
         * createdAt : 2017-04-17T10:34:13.180Z
         * desc : Android Tag Chip 效果，做的非常细腻，完全的 Material Design。
         * images : ["http://img.gank.io/6e1eaf48-4277-46dc-b97b-f05a5261223b"]
         * publishedAt : 2017-04-17T11:32:14.674Z
         * source : chrome
         * type : Android
         * url : https://github.com/pchmn/MaterialChipsInput
         * used : true
         * who : 代码家
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
