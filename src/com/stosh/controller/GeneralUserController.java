package com.stosh.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.stosh.dao.UserDao;
import com.stosh.model.GeneralUser;
import com.stosh.model.Product;

@Controller
@SessionAttributes({"verifiedGeneralUser", "cartProductList"})
public class GeneralUserController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="signup", method=RequestMethod.GET)
	public String signuoForm() {
		return "signup";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="add-general-user", method=RequestMethod.POST)
	public ModelAndView addGeneralUser(@ModelAttribute GeneralUser generalUser) {
		
		userDao.insertGeneralUser(generalUser);
		
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	
	@RequestMapping(value="verify-general-user", method=RequestMethod.POST)
	public ModelAndView verifyGeneralUser(@RequestParam("generalUserName") String generalUserName, @RequestParam("generalUserPassword") String generalUserPassword) {
		
		GeneralUser verifiedGeneralUser = userDao.verifyUser(generalUserName, generalUserPassword);
		
		ModelAndView mv = new ModelAndView("login");
		
		if(verifiedGeneralUser==null) {
			mv = new ModelAndView("redirect:login");
		}else {
			mv = new ModelAndView("redirect:home");
			mv.addObject("verifiedGeneralUser", verifiedGeneralUser);
			mv.addObject("cartProductList", new ArrayList<Product>());
		}
		
		return mv;
	}
	
	
	
	
}
