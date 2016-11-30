package com.cyq.bookstore.controller;

import com.cyq.bookstore.pojo.ShopBook;
import com.cyq.bookstore.service.ShopCartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by computer on 2016/11/30.
 * 购物车的相关操作
 */
@Controller
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
