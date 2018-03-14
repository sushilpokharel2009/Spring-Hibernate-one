package com.stosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stosh.dao.CategoryDao;
import com.stosh.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao categoryDao;
	
//	@RequestMapping(value="category-form")
//	public String categoryForm() {
//		return "category-form";
//	}
	
	@RequestMapping(value="category-form")
	public ModelAndView categoryForm() {
		Category category = new Category();
		category.setCategoryId(0);
		category.setCategoryName("");
		ModelAndView mv = new ModelAndView("category-form");
		mv.addObject("category", category);
		
		 return mv;
	}
	
	@RequestMapping(value={"add-category"} , method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute Category category) {
				
		if(category.getCategoryId()==0) {
		categoryDao.insertCategory(category);
		}else {
			categoryDao.updateCategory(category);
		}
		List<Category> categoryList = categoryDao.getCategoryList();
		ModelAndView mv = new ModelAndView("category-list");
		mv.addObject("categoryList", categoryList);
		
		 return mv;
	}
	
	
	@RequestMapping(value={"delete-category/{categoryId}"} , method=RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable("categoryId") int categoryId) {
					
		categoryDao.deleteCategory(categoryId);
		List<Category> categoryList = categoryDao.getCategoryList();
		ModelAndView mv = new ModelAndView("category-list");
		mv.addObject("categoryList", categoryList);
		
		 return mv;
		
	}
	
	
	@RequestMapping(value={"edit-category"} , method=RequestMethod.GET)
	public ModelAndView editCategory(@RequestParam("categoryId") int categoryId) {
					
		Category category = categoryDao.getCategory(categoryId);

		ModelAndView mv = new ModelAndView("category-form");
		mv.addObject("category", category);
		
		 return mv;
		
	}
}
