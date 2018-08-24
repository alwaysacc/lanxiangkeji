package com.lanxiang.service.impl;

import com.lanxiang.dao.AdminDao;
import com.lanxiang.dao.NewsDao;
import com.lanxiang.model.Admin;
import com.lanxiang.model.News;
import com.lanxiang.service.AdminService;
import com.lanxiang.service.NewsService;
import com.lanxiang.utils.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsDao nd;

    @Override
    public List getNewsList(PageInfo PageInfo) {

        return nd.getNewsList(PageInfo);
    }

    @Override
    public int addNews(News news) {
        return nd.addNews(news);
    }

}
