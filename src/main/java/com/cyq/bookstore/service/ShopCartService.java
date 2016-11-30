package com.cyq.bookstore.service;

import com.cyq.bookstore.pojo.ShopBook;

import java.util.List;

/**
 * Created by computer on 2016/11/30.
 */
public interface ShopCartService {



    /**
     * 把商品加入购物车
     */
    public int insetShopBook(ShopBook shopBook);
    /**
     * 展示购物车
     */
    public List<ShopBook> showShopBook(int userId);

    /**
     *根据条件得到购物车中的数据
     */
    public ShopBook getShopCartByCondition(ShopBook shopBook);


    /**
     * 根据id更新购物车
     * @param shopBook
     * @return
     */
    public int updateByShopId(ShopBook shopBook);
}
