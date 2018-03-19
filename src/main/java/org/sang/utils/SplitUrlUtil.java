package org.sang.utils;

public class SplitUrlUtil {

    /**
     * 获取存储图片绝对地址
     * @param urls
     * @param slipT
     */
    public static String getFirstUrl(String urls,String slipT) {
        String url = "";
        if(null == urls || urls == "") {
            return url;
        }
        try {
            String[] urlArray = urls.split(slipT);
            url = urlArray[0];
            return url;
        } catch (Exception e) {
            return url;
        }
    }

    /**
     * 获取存储图片绝对地址
     * @param urls
     * @param slipT
     */
    public static String[] getAllUrl(String urls,String slipT) {
        String[] urlArray;
        if(null == urls || urls == "") {
            return new String[]{};
        }
        try {
            urlArray = urls.split(slipT);
            return urlArray;
        } catch (Exception e) {
            return new String[]{};
        }
    }
}
