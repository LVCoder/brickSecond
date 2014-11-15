package com.pmi.brick.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pmi.brick.dao.UserDao;
import com.pmi.brick.dao.UserDaoImpl;
import com.pmi.brick.domain.User;
import com.pmi.brick.service.UserService;
import com.pmi.brick.service.UserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("user")
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "index";
	}

	@RequestMapping("/home")
	public ModelAndView home(ModelMap model) {

		org.springframework.security.core.userdetails.User cur_user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String name = cur_user.getUsername(); // get logged in username

		User user = userService.getUserByEmail(name);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("current_user", user);
		modelAndView.setViewName("home");

		return modelAndView;

	}

	@RequestMapping("/info")
	public String info() {

		return "info";

	}

	@RequestMapping("/admin")
	public String admin() {

		return "admin";

	}

}
