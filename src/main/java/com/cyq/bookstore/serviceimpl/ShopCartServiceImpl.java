package com.cyq.bookstore.serviceimpl;

import com.cyq.bookstore.dao.ShopBookDao;
import com.cyq.bookstore.pojo.ShopBook;
import com.cyq.bookstore.service.ShopCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by computer on 2016/11/30.
 * 购物车接口实现类
 */
@Service("shopCartService")
public class ShopCartServiceImpl implements ShopCartService {

    @Resource
    private ShopBookDao shopBookDao;

    @Override
    public int insetShopBook(ShopBook shopBook) {

        return shopBookDao.insertShopCart(shopBook);
    }

    @Override
    public List<ShopBook> showShopBook(int userId) {

        return shopBookDao.showShopCart(userId);
    }

    @Override
    public ShopBook getShopCartByCondition(ShopBook shopBook){
        return shopBookDao.getShopCartByCondition(shopBook);
    }

    @Override
    public int updateByShopId(ShopBook shopBook) {

        return shopBookDao.updateByShopId(shopBook);
    }

}
