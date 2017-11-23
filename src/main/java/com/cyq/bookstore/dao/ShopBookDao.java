package com.cyq.bookstore.dao;

import java.util.List;

import com.cyq.bookstore.pojo.ShopBook;
import org.springframework.stereotype.Repository;

public interface ShopBookDao {
	/** 将商品加入购物车 */
	int insertShopCart(ShopBook shopBook);

	/** 列出购物车 */
	List<ShopBook> showShopCart(int userId);

	/** 通过bookid,userid查找购物车 */
	ShopBook getShopCartByCondition(ShopBook shopBook);
	
	/**更新购物车*/
	int updateByShopId(ShopBook shopBook);

}
