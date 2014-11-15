package com.pmi.brick.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
public class ErrorController {

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "THIS PAGE IS NOT FOUND")
	// 404
	@ExceptionHandler(Exception.class)
	public String pageNotFound() {

		return "errors/error404";

	}

}
