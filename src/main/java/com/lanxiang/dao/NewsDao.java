package com.lanxiang.dao;


import com.lanxiang.model.Admin;
import com.lanxiang.model.News;
import com.lanxiang.utils.PageInfo;

import java.util.List;

public interface NewsDao {

    List getNewsList(PageInfo pageInfo);
    int addNews(News news);
}
