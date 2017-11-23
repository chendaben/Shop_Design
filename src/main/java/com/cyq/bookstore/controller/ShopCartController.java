package com.cyq.bookstore.controller;

import com.cyq.bookstore.pojo.ShopBook;
import com.cyq.bookstore.service.ShopCartService;
import com.wordnik.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by chenyanqiu on 2016/11/30.
 * 购物车的相关操作
 */
@Api(value = "购物车api列表")
@RestController
@RequestMapping(value="/shopcart")
public class ShopCartController {

    @Resource
    private ShopCartService shopCartService;


    /**
     * 根据用户id列出用户的购物车
     * @param session
     * @return
     */
    public List<ShopBook> list(HttpSession session){
        int userId=(Integer) session.getAttribute("useId");
        List<ShopBook> shopBookList=shopCartService.showShopBook(userId);
        return shopBookList;
    }


}
