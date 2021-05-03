package org.fkpk.controller;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.fkpk.domain.Cart;
import org.fkpk.domain.CartProduct;
import org.fkpk.domain.Member;
import org.fkpk.domain.Order;
import org.fkpk.domain.OrderDetail;
import org.fkpk.domain.OrderDetailProduct;
import org.fkpk.domain.Product;
import org.fkpk.domain.Recipe;
import org.fkpk.domain.Refrige;
import org.fkpk.domain.RefrigeProduct;
import org.fkpk.service.MemberService;
import org.fkpk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MemberService memberService;
	
	//상품 등록 폼으로
	@GetMapping("/productRegister")
	public void productRegisterForm() throws Exception {
		
	}
	
	//상품 등록
	@PostMapping("/productRegister")
	public String productRegister(Product product, HttpServletRequest request) throws Exception {
		String saveDir = request.getSession().getServletContext().getRealPath("/");
		saveDir += "resources\\product_img\\";
		MultipartFile f = product.getUploadFile();
		String fileName="";
		if(!f.isEmpty()) {
			String orifileName = f.getOriginalFilename();
			System.out.println("getOriginalFilename:"+orifileName);
			//파일명 지정
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"_"+orifileName;
			FileCopyUtils.copy(f.getBytes(), new File(saveDir+fileName));
			product.setProductImg(fileName);
		}
		productService.productRegister(product);
		return "redirect:/product/productList";
	}
	
	//상품 리스트
	@GetMapping("/productList")
	public void productList(Model model) throws Exception {
		List<Product> list = productService.productList();
		model.addAttribute("list",list);
		//System.out.println(list);
	}
	
	//안드로이드- 상품 리스트(전체) 
	@ResponseBody
	@GetMapping("/productListBody")
	public String productListBody() throws Exception {
		Gson gson = new GsonBuilder().create();
		List<Product> list = productService.productList();
		String jsonString = gson.toJson(list);
		return jsonString;
	}
	
	//안드로이드- 상품 리스트(신상품) 
	@ResponseBody
	@GetMapping("/newProductListBody")
	public String newProductListBody() throws Exception {
		Gson gson = new GsonBuilder().create();
		List<Product> list = productService.newProductList();
		String jsonString = gson.toJson(list);
		return jsonString;
	}
	
	
	//안드로이드- 상품 리스트(과일)
	@ResponseBody
	@GetMapping("/FruitListBody")
	public String FruitListBody() throws Exception {
		Gson gson = new GsonBuilder().create();
		List<Product> list = productService.FruitList();
		String jsonString = gson.toJson(list);
		return jsonString;
	}
	
	//안드로이드- 상품 리스트(야채)
	@ResponseBody
	@GetMapping("/VegetableListBody")
	public String VegetableListBody() throws Exception {
		Gson gson = new GsonBuilder().create();
		List<Product> list = productService.VegetableList();
		String jsonString = gson.toJson(list);
		return jsonString;
	}
	
	//상품 상세보기
	@GetMapping("/productDetail")
	public void productDetail(String productId, Model model) throws Exception {
		Product product = productService.productDetail(productId);
		model.addAttribute("product",product);
	}
	
	//안드로이드- 상품 상세보기
	@ResponseBody
	@GetMapping("/productDetailBody")
	public String productDetailBody(String productId) throws Exception {
		Gson gson = new GsonBuilder().create();
		Product product = productService.productDetail(productId);
		String jsonString = gson.toJson(product);
		return jsonString;
	}
	
	//안드로이드- 카트 담기
	@ResponseBody
	@PostMapping("/addCart")
	public void addCart(String productId, String cartAmount, String memberId) throws Exception {
		Cart cart = new Cart();
		cart.setProductId(Integer.parseInt(productId));
		cart.setCartAmount(Integer.parseInt(cartAmount));
		cart.setMemberId(Integer.parseInt(memberId));
		int cartCheck = productService.cartCheck(cart);
		if(cartCheck==0) productService.addCart(cart);	
	}
	
	//안드로이드- 카트 리스트 
	@ResponseBody
	@GetMapping("/cartList")
	public String cartList(String memberId) {
		Gson gson = new GsonBuilder().create();
		List<CartProduct> cartList = productService.cartList(memberId); //오류나면 int로 수정
		String jsonString = gson.toJson(cartList);
		return jsonString;
	}
	
	//안드로이드- 카트 수량 변경
	@ResponseBody
	@PostMapping("/cartChange")
	public void cartChange(String cartId, String cartAmount) {
		Cart cart = new Cart();
		cart.setCartId(Integer.parseInt(cartId));
		cart.setCartAmount(Integer.parseInt(cartAmount));
		productService.cartChange(cart);
	}
	
	//안드로이드- 카트 삭제
	@ResponseBody
	@PostMapping("/cartDelete")
	public void cartDelete(String cartId) {
		productService.cartDelete(Integer.parseInt(cartId));
	}
	
	//안드로이드- 주문하기화면(멤버정보)
	@ResponseBody
	@GetMapping("/orderForm")
	public String orderForm(String memberId) {
		Gson gson = new GsonBuilder().create();
		Member member = memberService.findById(memberId);
		String jsonString = gson.toJson(member);
		return jsonString;
	}
	
	//안드로이드- 주문하기 //작성중
	@ResponseBody
	@Transactional
	@PostMapping("/order")
	public void addOrder(String memberId,String status,String orderAddr,String orderPhone,String orderName,int totalOrderAmount) {
		Order order = new Order();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		 
		for(int i = 1; i <= 6; i ++) {
			subNum += (int)(Math.random() * 10);
		}
		 
	    String orderId = ymd + "_" + subNum;
		
	    order.setOrderId(orderId);
	    order.setMemberId(Integer.parseInt(memberId));
	    order.setStatus(status);
	    order.setOrderAddr(orderAddr);
	    order.setOrderPhone(orderPhone);
	    order.setTotalOrderAmount(totalOrderAmount);
	    
	    productService.addOrder(order); 
	    
	    Integer[] arr = productService.cartIdList(memberId);
	    
		OrderDetail details = new OrderDetail();
		
		for(int i=0;i<arr.length; i++) {
			//카트리스트 -> details
			int cartId = arr[i];
			Cart cart = productService.getCart(cartId); 
			int productId = cart.getProductId();
			int qty = cart.getCartAmount();
			//int productPrice = cart.getProductPrice();
			//int point = (int)(productPrice * qty * 0.01); //적립금
			details.setProductId(productId);
			details.setQty(qty);
			details.setOrderId(orderId);
			productService.addOrderDetails(details); 
			//재고-
			productService.stockChange(productId,qty); 
			//판매량+
			productService.salesAmountChange(productId,qty); 
			//적립금+ //주문완료로 옮기기
			//memberService.addPoint(Integer.parseInt(memberId),point); 
			//카트삭제
			productService.cartDelete(cartId); 
		}
	}
	
	//주문리스트(관리자)
	@GetMapping("/orderList")
	public void orderList(Model model) throws Exception {
		List<Order> list = productService.orderList();
		model.addAttribute("list",list);
	}
	
	//안드로이드- 주문리스트(관리자)
	@ResponseBody
	@GetMapping("/orderListBody")
	public String orderListBody() throws Exception {
		Gson gson = new GsonBuilder().create();
		List<Order> list = productService.orderList(); 
		String jsonString = gson.toJson(list);
		return jsonString;
	}
	
	//주문완료 
//	@Transactional
//	@PostMapping("/orderCompleted")
//	public int orderCompleted(String orderId,int status,int memberId) throws Exception {
//		int result=0;
//		String statusConfirm = productService.getOrderStatus(orderId);
//		if(statusConfirm.equals("배송대기") || statusConfirm.equals("픽업대기")) {		
//			if(status == 0) {
//				//상태변경
//				productService.pickupCompleted(orderId);
//			}else {
//				productService.delieveryCompleted(orderId);
//			}
//			//적립금+
//			int[] arr = productService.getOrderDetailList(orderId); //orderdetail_id 불러오기
//			for(int i=0; i<arr.length; i++) {
//				OrderDetailProduct order = productService.getOrderDetail(arr[i]);
//				int qty = order.getQty();
//				int productId = order.getProductId();
//				int productPrice = order.getProductPrice();
//				int point = (int)(productPrice * qty * 0.01); //적립금
//				memberService.addPoint(memberId,point); 
//				
//				//냉장고 추가
//				Refrige refrige = new Refrige();
//				
//				int dup = productService.refrigeDupCheck(productId);
//				if(dup==0) { //중복아님
//					refrige.setMemberId(memberId);
//					refrige.setProductId(productId); 
//					refrige.setProductAmount(qty);
//					productService.addRefrige(refrige);	
//				}else { //중복이면 개수증가  ! ! ! 
//					refrige.setMemberId(memberId);
//					refrige.setProductId(productId); 
//					refrige.setProductAmount(qty);
//					productService.updateRefrige(refrige);	
//				}
//					
//			}
//		}else {
//			result=1;
//		}
//		return result;
//
//	}
	
	//안드로이드- 주문완료
	@ResponseBody
	@Transactional
	@PostMapping("/orderCompletedBody")
	public void orderCompletedBody(String orderId,String status, int memberId) throws Exception {

		String statusConfirm = productService.getOrderStatus(orderId);
		if(statusConfirm.equals("배송대기") || statusConfirm.equals("픽업대기")) {		
			if(status.equals("픽업대기")) {
				//상태변경
				productService.pickupCompleted(orderId);
			}else {
				productService.delieveryCompleted(orderId);
			}
			//적립금+
			int[] arr = productService.getOrderDetailList(orderId); //orderdetail_id 불러오기
			for(int i=0; i<arr.length; i++) {
				OrderDetailProduct order = productService.getOrderDetail(arr[i]);
				Product product = new Product();
				int qty = order.getQty();
				int productId = order.getProductId();
				int productPrice = order.getProductPrice();
				int point = (int)(productPrice * qty * 0.01); //적립금
				memberService.addPoint(memberId,point); 
				
				//냉장고 추가
				Refrige refrige = new Refrige();
				
				product.setMemberId(memberId);
				product.setProductId(productId);
				
				int dup = productService.refrigeDupCheck(product);
				if(dup==0) { //중복아님
					refrige.setMemberId(memberId);
					refrige.setProductId(productId); 
					refrige.setProductAmount(qty);
					productService.addRefrige(refrige);	
				}else { //중복이면 개수증가  ! ! ! 
					refrige.setMemberId(memberId);
					refrige.setProductId(productId); 
					refrige.setProductAmount(qty);
					productService.updateRefrige(refrige);	
				}
					
			}
		}


	}
	
	
	
	//안드로이드- 냉장고 리스트
	@ResponseBody
	@GetMapping("/refrigeList")
	public String refrigeList(int memberId) {
		Gson gson = new GsonBuilder().create();
		List<RefrigeProduct> refrigeList = productService.refrigeList(memberId); 
		String jsonString = gson.toJson(refrigeList);
		return jsonString;
	}
	
	//안드로이드- 냉장고 수량변경
	@ResponseBody
	@PostMapping("/refrigeChange")
	public void refrigeChange(int refrigeId, int productAmount) {
		Refrige refrige = new Refrige();
		refrige.setRefrigeId(refrigeId);
		refrige.setProductAmount(productAmount);
		productService.refrigeChange(refrige);
	}
	
	//안드로이드- 냉장고 삭제
	@ResponseBody
	@PostMapping("/refrigeDelete")
	public void refrigeDelete(int refrigeId) {
		productService.refrigeDelete(refrigeId);
	}
	
	
	//레시피 등록 폼으로
	@GetMapping("/recipeRegister")
	public void recipeRegisterForm() throws Exception {
		
	}
	
	//레시피 등록
	@PostMapping("/recipeRegister")
	public String recipeRegister(Recipe recipe, HttpServletRequest request) throws Exception {
		String saveDir = request.getSession().getServletContext().getRealPath("/");
		saveDir += "resources\\recipe_img\\";
		MultipartFile f = recipe.getUploadFile();
		String fileName="";
		if(!f.isEmpty()) {
			String orifileName = f.getOriginalFilename();
			System.out.println("getOriginalFilename:"+orifileName);
			//파일명 지정
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"_"+orifileName;
			FileCopyUtils.copy(f.getBytes(), new File(saveDir+fileName));
			recipe.setRecipeImg(fileName);
		}
		productService.recipeRegister(recipe);
		return "redirect:/product/recipeList";
	}
	
	//레시피 리스트
	@GetMapping("/recipeList")
	public void recipeList(Model model) throws Exception {
		List<Recipe> list = productService.recipeList();
		model.addAttribute("list",list);
		//System.out.println(list);
	}
	
	//안드로이드- 레시피 리스트
	@ResponseBody
	@GetMapping("/recipeListBody")
	public String recipeListBody(String productName) {
		Gson gson = new GsonBuilder().create();
		List<Recipe> list = productService.recipeListByIg(productName); 
		String jsonString = gson.toJson(list);
		return jsonString;
	}
	
	//안드로이드- 레시피 디테일
	@ResponseBody
	@GetMapping("/recipeDetailBody")
	public String recipeDetailBody(int recipeId) {
		Gson gson = new GsonBuilder().create();
		Recipe recipe = productService.recipeDetail(recipeId); 
		String jsonString = gson.toJson(recipe);
		return jsonString;
	}
	
	//안드로이드- 스탬프+
	@ResponseBody
	@PostMapping("/addStamp")
	public void addStamp(int memberId) {
		memberService.addStamp(memberId);
	}
	
	//안드로이드- 스탬프 초기화
	@ResponseBody
	@PostMapping("/resetStamp")
	public void resetStamp(int memberId) {
		memberService.resetStamp(memberId);
	}
	
	//안드로이드- 스탬프 불러오기
	@ResponseBody
	@GetMapping("/stampCount")
	public String stampCount(int memberId) {
		Gson gson = new GsonBuilder().create();
		int count = memberService.stampCount(memberId); 
		String jsonString = gson.toJson(count);
		return jsonString;
	}
	


}
