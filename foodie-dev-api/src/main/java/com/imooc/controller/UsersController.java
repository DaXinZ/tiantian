package com.imooc.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.enums.YesOrNo1;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;
import com.imooc.pojo.vo.UsersVO;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import com.imooc.service.UserService;
import com.imooc.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;



@Api(value = "用户接口", tags = {"用户相关信息的查询修改接口"})
@RestController
@RequestMapping("User")
public class UsersController  {
    @Autowired
    private UserService userService;

    final  static Logger logger = LoggerFactory.getLogger(HelloController.class);


    /**
     *
     * @param uid
     * @return  根据用户uid查询用户相关信息
     */

    @ApiOperation(value = "查询用户相关信息", notes = "查询用户相关信息", httpMethod = "GET")
    @GetMapping("/queryUser.json/{uid}")
    public IMOOCJSONResult queryUser(
            @ApiParam(name = "uid", value = "用户uid", required = false
                     )

            @RequestParam String uid ) {

        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        imoocjsonResult.setTrceid(test.getStringRandom());
        String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());
        logger.info("接受用户请求参数"+ JSON.toJSONString(uid));
        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(uid)) {
            logger.info("查询失败用户名为空"+ JSON.toJSONString(uid));
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }

        // 2. 查找注册的用户名是否存在
        List<UsersVO> list = userService.queryUsers(uid);


         logger.info("查询成功返回参数如下" + JSON.toJSONString(list));
        return IMOOCJSONResult.ok(list);
    }

    /**
     *
     * @param nikename
     * @return  根据用户昵称查询相关信息
     */

   @ApiOperation(value = "使用用户昵称查询相关信息",notes = "用户昵称",httpMethod = "GET")
    @GetMapping("/queryUsernikename.json/{nikename}")
    public IMOOCJSONResult  queryname(
            @ApiParam(name = "nikename",value = "用户昵称",required = false
              )@RequestParam String nikename) {
       logger.info("接受入参"+JSON.toJSONString(nikename));
       StringRandom test = new StringRandom();
       IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
       imoocjsonResult.setTrceid(test.getStringRandom());
       String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());
   if (StringUtils.isBlank(nikename))
   {
       logger.info("用户名为空"+JSON.toJSONString(nikename));
       return IMOOCJSONResult.errorMsg("用户名不能为空");
   }

   List<UsersVO> list = userService.queryUsername(nikename);
       logger.info("请求成功返回参数如下"+JSON.toJSONString(list));

   return IMOOCJSONResult.ok(list);
   }




}
