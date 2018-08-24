package com.lanxiang.service;


import com.lanxiang.model.Admin;
import com.lanxiang.model.News;
import com.lanxiang.utils.PageInfo;

import java.util.List;

public interface NewsService {

    public List getNewsList(PageInfo PageInfo);
    public int addNews(News news);
}
