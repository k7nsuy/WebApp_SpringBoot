package org.fkpk.service;

import java.util.List;

import org.fkpk.domain.Cart;
import org.fkpk.domain.CartProduct;
import org.fkpk.domain.Order;
import org.fkpk.domain.OrderDetail;
import org.fkpk.domain.OrderDetailProduct;
import org.fkpk.domain.Product;
import org.fkpk.domain.Recipe;
import org.fkpk.domain.Refrige;
import org.fkpk.domain.RefrigeProduct;

public interface ProductService {

	public void productRegister(Product product) throws Exception;

	public void recipeRegister(Recipe recipe) throws Exception;

	public List<Recipe> recipeList();

	public List<Product> productList();

	public List<Product> FruitList();

	public Product productDetail(String productId);

	public void addCart(Cart cart);

	public int cartCheck(Cart cart);

	public List<CartProduct> cartList(String memberId);

	public void cartChange(Cart cart);

	public void cartDelete(int cartId);

	public void addOrder(Order order);

	public Integer[] cartIdList(String memberId);

	public Cart getCart(int cartId);

	public void addOrderDetails(OrderDetail details);

	public void stockChange(int productId, int qty);

	public void salesAmountChange(int productId, int qty);

	public List<Order> orderList();

	public void pickupCompleted(String orderId);

	public void delieveryCompleted(String orderId);

	public int[] getOrderDetailList(String orderId);

	public OrderDetailProduct getOrderDetail(int orderdetailsId);

	public void addRefrige(Refrige refrige);

	public String getOrderStatus(String orderId);

	public List<RefrigeProduct> refrigeList(int memberId);

	public int refrigeDupCheck(Product product);

	public void updateRefrige(Refrige refrige);

	public void refrigeChange(Refrige refrige);

	public void refrigeDelete(int refrigeId);

	public List<Product> VegetableList();

	public Recipe recipeDetail(int recipeId);

	public List<Recipe> recipeListByIg(String productName);

	public List<Product> newProductList();


}
