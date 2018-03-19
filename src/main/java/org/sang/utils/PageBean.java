package org.sang.utils;


/**
 * 分页bean
 */
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageBean<T> {

    private PageInfo pageInfo;

    private List<T> items;

    public PageBean() {
        super();
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
