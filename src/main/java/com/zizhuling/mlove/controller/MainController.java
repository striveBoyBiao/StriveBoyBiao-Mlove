package com.zizhuling.mlove.controller;

import com.zizhuling.mlove.utils.Constants;
import com.zizhuling.mlove.utils.PageInfo;
import com.zizhuling.mlove.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by 11697 on 2018/12/23.
 */
@Controller
public class MainController {

    /**增加日志*/
    private final Logger log= LoggerFactory.getLogger("MainController.class");
    @Autowired
    private MainService mainService;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 初始化跳到首页
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "mlove/author";
    }
    /**
     * 跳到首页
     * @return
     */
    @RequestMapping("/author")
    public String author() {
        return "mlove/author";
    }
    /**
     * 跳到其他类型页面
     * @return
     */
    @RequestMapping("/index")
    public String main() {
        return "mlove/index";
    }

    /**
     * 跳到文章
     * @return
     */
    @RequestMapping("/article")
    public String article() {
        return "mlove/article";
    }

    /**
     * 跳到留言板
     * @return
     */
    @RequestMapping("/saying")
    public String saying() {
        return "blog/saying";
    }


    /**
     * 查询首页数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/main/findAuthor")
    public PageInfo findAuthor(HttpServletRequest request){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("pageNo",request.getParameter("pageNo"));
            map.put("search",request.getParameter("search"));
            PageInfo pageInfo=mainService.findAuthor(map);
            return pageInfo;
    }

    /**
     * 查询首页详细界面数据
     * @return
     */
    @RequestMapping("/main/findAuthorDetails")
    public String findAuthorDetails(HttpServletRequest request,Model model){
        PageInfo pageInfo=null;
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("cid",request.getParameter("cid"));
        pageInfo=mainService.findAuthorDetails(map);
        model.addAttribute("list",pageInfo.getPageData().get(0));
        model.addAttribute("ondata",pageInfo.getOnData());
        model.addAttribute("underData",pageInfo.getUnderData());
        return "mlove/article";
    }




}
