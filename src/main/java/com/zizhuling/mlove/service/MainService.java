package com.zizhuling.mlove.service;


import com.zizhuling.mlove.utils.PageInfo;

import java.util.Map;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface MainService {


    /**
     * 查询首页数据
     * @return
     */
    public PageInfo findAuthor(Map<String,Object> map);
    /**
     * 查询详细数据
     * @return
     */
    public PageInfo findAuthorDetails(Map<String,Object> map);




}
