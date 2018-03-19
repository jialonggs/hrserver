package org.sang.bean.requestEntity;

public class RequestBean {
    private String Data;
    private String UserId;
    private String UserToken;
    private String  MD5;
    private Integer Source;
    private String PageInfo;



    public RequestBean () {

    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }


    public String getPageInfo() {
        return PageInfo;
    }

    public void setPageInfo(String pageInfo) {
        PageInfo = pageInfo;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserToken() {
        return UserToken;
    }

    public void setUserToken(String userToken) {
        UserToken = userToken;
    }

    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public int getSource() {
        return Source;
    }

    public void setSource(int source) {
        Source = source;
    }
}
