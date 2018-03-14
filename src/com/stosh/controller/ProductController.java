package com.stosh.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.stosh.dao.CategoryDao;
import com.stosh.dao.ProductDao;
import com.stosh.model.Category;
import com.stosh.model.GeneralUser;
import com.stosh.model.Product;

@Controller
@SessionAttributes("")
public class ProductController {

	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public ModelAndView home() {
		
		List<Category> categoryList = categoryDao.getCategoryList();
		List<Product> productList = productDao.getProductList();
		
		System.out.println("Size-->>"+categoryList.size());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("categoryList", categoryList);
		mv.addObject("productList", productList);
		return mv;
	}
	
	@RequestMapping(value="home/{categoryId}")
	public ModelAndView home(@PathVariable("categoryId") int categoryId) {
		
		List<Category> categoryList = categoryDao.getCategoryList();
		List<Product> productList = productDao.getProductListByCategoryId(categoryId);
		
		System.out.println("Size-->>"+categoryList.size());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("categoryList", categoryList);
		mv.addObject("productList", productList);
		return mv;
	}
	
	@RequestMapping(value="add-cart/{productId}", method=RequestMethod.GET)
	public ModelAndView addCart(@PathVariable("productId") int productId, HttpSession session) {
		
		GeneralUser generalUser = (GeneralUser)session.getAttribute("verifiedGeneralUser");
		
		if(generalUser==null) {
			ModelAndView mv = new ModelAndView("login");
			return mv;
		}
		
		List<Product> cartProductList = (ArrayList<Product>)session.getAttribute("cartProductList");
		Product cartProduct = productDao.getProduct(productId);
		if(cartProductList !=null) {
			cartProductList.add(cartProduct);
			session.setAttribute("cartProductList", cartProductList);
		}
		
		ModelAndView mv = new ModelAndView("add-cart");
	
		return mv;
	}
	
	
	
	
	@RequestMapping(value="product-form")
	public ModelAndView productForm() {
		
		List<Category> categoryList = categoryDao.getCategoryList();
		System.out.println("Size-->>"+categoryList.size());
		ModelAndView mv = new ModelAndView("product-form");
		mv.addObject("categoryList", categoryList);
		return mv;
	}
	
	
	@RequestMapping(value={"add-product"}, method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute Product product, BindingResult bindingResult,@RequestParam(value = "image", required = false) MultipartFile image, HttpServletRequest request){
		
		product.setProductImage(product.getProductCode()+".jpg");
		
		String rootDireectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println("rootDirectory-->>"+ rootDireectory);
		System.out.println("image--->>"+image);
		System.out.println("categoryId--->>"+product.getCategory().getCategoryId());
		File file = new File(request.getSession().getServletContext().getRealPath("/photo/"+product.getProductCode()+".jpg"));
		
		try {
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		productDao.insertProduct(product);
		List<Product> productList = productDao.getProductList();
		ModelAndView mv = new ModelAndView("product-list");
		mv.addObject("productL", productList);
		
		return mv;
	}
	
	
}
