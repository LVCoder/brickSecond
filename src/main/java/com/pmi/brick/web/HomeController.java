package com.pmi.brick.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pmi.brick.dao.UserDao;
import com.pmi.brick.dao.UserDaoImpl;
import com.pmi.brick.domain.Task;
import com.pmi.brick.domain.User;
import com.pmi.brick.exception.EmailAlreadyExistsException;
import com.pmi.brick.service.UserService;
import com.pmi.brick.service.UserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends MainController {

	


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		if(CurrentLogedUser!=null)
			return "redirect:/home";
		return "index";
		
	}

	@RequestMapping("/home")
	public ModelAndView home(ModelMap model) {

		
		User user = getCurrentLogedUser();
     
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("current_user", user);
		modelAndView.setViewName("home");
    
		return modelAndView;

	}

	@RequestMapping("/info")
	public String info() {

		return "info";

	}
	@RequestMapping("/logout")
	public String logout() {
		
		logoutCurrentUser();
 
		return "redirect:/j_spring_security_logout";

	}

	@RequestMapping("/admin")
	public String admin() {

		return "admin";

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser() {
		User user = getCurrentLogedUser();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("current_user", user);
		modelAndView.setViewName("editProfil");

		return modelAndView;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUserData(@ModelAttribute("user") User user,
			BindingResult result, HttpServletResponse response) throws EmailAlreadyExistsException {
		
		//дописати перевірку на вже існуючий email. 
		
		CurrentLogedUser.setName(user.getName());
		CurrentLogedUser.setSurname(user.getSurname());
		CurrentLogedUser.setPhone(user.getPhone());
		CurrentLogedUser.setEmail(user.getEmail());
		  
				
		userService.updateUser(CurrentLogedUser);

		System.out.println("Update User Data");
		

		return "redirect:/home";
	}
	 @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	 public String getUploadPage(){
		 
		 
		 return "upload";
	 }
	   
	 @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	    public @ResponseBody
	    String uploadFileHandler(@RequestParam("name") String name,
	            @RequestParam("file") MultipartFile file) {
	 
	        if (!file.isEmpty()) {
	            try {
	                byte[] bytes = file.getBytes();
	 
	                // Creating the directory to store file
	                String rootPath = System.getProperty("catalina.home");
	                File dir = new File(rootPath + File.separator + "tmpFiles");
	                if (!dir.exists())
	                    dir.mkdirs();
	 
	                // Create the file on server
	                File serverFile = new File(dir.getAbsolutePath()
	                        + File.separator + name);
	                BufferedOutputStream stream = new BufferedOutputStream(
	                        new FileOutputStream(serverFile));
	                stream.write(bytes);
	                stream.close();
	 
	              
	 
	                return "You successfully uploaded file=" + name;
	            } catch (Exception e) {
	                return "You failed to upload " + name + " => " + e.getMessage();
	            }
	        } else {
	            return "You failed to upload " + name
	                    + " because the file was empty.";
	        }
	    }
	@RequestMapping(value = "getRandom",method = RequestMethod.GET)
	public @ResponseBody String getRandom(){
		Random r = new Random();
		String val = "Random:"+r.nextFloat()+"On:"+new Date().toString();
		return val;
		
	}
	
}
