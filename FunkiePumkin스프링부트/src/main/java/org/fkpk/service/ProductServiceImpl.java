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
import org.fkpk.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductMapper productMapper;

	@Override
	public void productRegister(Product product) throws Exception {
		productMapper.productRegister(product);
		
	}

	@Override
	public void recipeRegister(Recipe recipe) throws Exception {
		productMapper.recipeRegister(recipe);		
	}

	@Override
	public List<Recipe> recipeList() {
		return productMapper.recipeList();
	}
	
	@Override
	public List<Product> productList() {
		return productMapper.productList();
	}

	@Override
	public List<Product> FruitList() {
		return productMapper.fruitList();
	}

	@Override
	public Product productDetail(String productId) {
		return productMapper.productDetail(productId);
	}

	@Override
	public void addCart(Cart cart) {
		productMapper.addCart(cart);
		
	}

	@Override
	public int cartCheck(Cart cart) {
		return productMapper.cartCheck(cart);
		
	}

	@Override
	public List<CartProduct> cartList(String memberId) {
		return productMapper.cartList(memberId);
	}

	@Override
	public void cartChange(Cart cart) {
		productMapper.cartChange(cart);
		
	}

	@Override
	public void cartDelete(int cartId) {
		productMapper.cartDelete(cartId);
		
	}

	@Override
	public void addOrder(Order order) {
		productMapper.addOrder(order);
		
	}

	@Override
	public Integer[] cartIdList(String memberId) {
		return productMapper.cartIdList(memberId);
	}

	@Override
	public Cart getCart(int cartId) {
		return productMapper.getCart(cartId);
	}

	@Override
	public void addOrderDetails(OrderDetail details) {
		productMapper.addOrderDetails(details);
		
	}

	@Override
	public void stockChange(int productId, int qty) {
		productMapper.stockChange(productId,qty);
	}

	@Override
	public void salesAmountChange(int productId, int qty) {
		productMapper.salesAmountChange(productId,qty);
	}

	@Override
	public List<Order> orderList() {
		return productMapper.orderList();
	}

	@Override
	public void pickupCompleted(String orderId) {
		productMapper.pickupCompleted(orderId);		
	}

	@Override
	public void delieveryCompleted(String orderId) {
		productMapper.delieveryCompleted(orderId);		
	}

	@Override
	public int[] getOrderDetailList(String orderId) {
		return productMapper.getOrderDetailList(orderId);
	}

	@Override
	public OrderDetailProduct getOrderDetail(int orderdetailsId) {
		return productMapper.getOrderDetail(orderdetailsId);
	}

	@Override
	public void addRefrige(Refrige refrige) {
		productMapper.addRefrige(refrige);
		
	}

	@Override
	public String getOrderStatus(String orderId) {
		return productMapper.getOrderStatus(orderId);		
	}

	@Override
	public List<RefrigeProduct> refrigeList(int memberId) {
		return productMapper.refrigeList(memberId);
	}

	@Override
	public int refrigeDupCheck(Product product) {
		return productMapper.refrigeDupCheck(product);
	}

	@Override
	public void updateRefrige(Refrige refrige) {
		productMapper.updateRefrige(refrige);		
	}

	@Override
	public void refrigeChange(Refrige refrige) {
		productMapper.refrigeChange(refrige);		
	}

	@Override
	public void refrigeDelete(int refrigeId) {
		productMapper.refrigeDelete(refrigeId);		
	}

	@Override
	public List<Product> VegetableList() {
		return productMapper.VegetableList();
	}

	@Override
	public Recipe recipeDetail(int recipeId) {
		return productMapper.recipeDetail(recipeId);
	}

	@Override
	public List<Recipe> recipeListByIg(String productName) {
		return productMapper.recipeListByIg(productName);
	}

	@Override
	public List<Product> newProductList() {
		return productMapper.newProductList();
	}




	
	

}
