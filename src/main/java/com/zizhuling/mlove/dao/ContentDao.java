package com.zizhuling.mlove.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface ContentDao {
    /**查询忙里偷闲*/
    List<Map<String,Object>> findAuthor(Map<String,Object> map);
    /**查询详细数据*/
    List<Map<String,Object>> findAuthorDetails(Map<String,Object> map);



    /**查询上一篇文章*/
    Map<String,Object> findLifeOnData(Map<String,Object> map);
    /**查询下一篇文章*/
    Map<String,Object> findLifeUnderData(Map<String,Object> map);
    /**修改阅读量*/
    void updateClickRate(Map<String,Object> map);
}
