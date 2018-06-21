package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.YaoJian;

public class YaoJianOrderResp  extends Order{
    private String fileUrl;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
