package com.zizhuling.mlove.service.impl;

import com.zizhuling.mlove.service.MainService;
import com.zizhuling.mlove.dao.ContentDao;
import com.zizhuling.mlove.utils.Constants;
import com.zizhuling.mlove.utils.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hebiao
 * Date:2018/12/28
 * Time: 14:21
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MainServiceImpl implements MainService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainService.class);

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ContentDao contentDao;

    /**
     *查询首页数据
     */
    @Override
    public PageInfo findAuthor(Map<String, Object> map) {
        PageInfo pageInfo=new PageInfo(map.get("pageNo").toString());
        List<Map<String,Object>> list=contentDao.findAuthor(map);
        pageInfo.setPageData(list);
        return pageInfo;
    }
    /**
     *查询详细数据
     */
    @Override
    public PageInfo findAuthorDetails(Map<String, Object> map) {
        PageInfo pageInfo=new PageInfo("1");
        /*修改阅读量*/
        contentDao.updateClickRate(map);
        List<Map<String,Object>> list=contentDao.findAuthorDetails(map);
        Map<String,Object> onData=contentDao.findLifeOnData(map);
        Map<String,Object> underData=contentDao.findLifeUnderData(map);
        /*处理thymeleaf空数据报错*/
        if (onData==null){
            onData=new HashMap<String,Object>();
            onData.put("cid","");
            onData.put("title","");
        }
        if (underData==null){
            underData=new HashMap<String,Object>();
            underData.put("cid","");
            underData.put("title","");
        }
        pageInfo.setOnData(onData);
        pageInfo.setUnderData(underData);
        pageInfo.setPageData(list);
        return pageInfo;
    }


}
