package com.java.spring.starterweb.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.java.spring.starterweb.model.Status;
import com.java.spring.starterweb.model.UserDetail;
import com.java.spring.starterweb.service.LoginService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.JstlView;

@Controller
public class HomeController {

    @Autowired
    LoginService loginService;

    private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

    @ResponseBody
    @RequestMapping(value="/status", method = RequestMethod.GET)
    public Status status(){
        LOGGER.info("status called");
        return new Status("UP","web-application is up!");
    }
    

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model, HttpServletRequest request){
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        return "redirect:home";
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home(ModelMap model, HttpServletRequest request){
        model.put("msg", "Hello There! This is a home page");
        
        if(isLoggedIn(request)){
            model.put("logstatus","true"); 
        }

        // log details 
        // displaySessionDetails(request);
        
        return "home";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLogin(ModelMap model){
        model.put("msg", "Hello There! This is a login page");
        return "login"; 
    }
  
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String checkLogin(ModelMap model, 
                            @RequestParam String user, 
                            @RequestParam String password,
                            HttpServletRequest request){
        
        UserDetail loggedUser = loginService.getUser(user, password);
        if (loggedUser == null) {
            model.put("errorMessage", "Invalid Credentials, Please try again");
            return "login";    
        }
        // user logged in at this point, setting in session
        request.getSession().setAttribute("user", loggedUser);
        request.getSession().setAttribute("username", loggedUser.getUsername());
        request.getSession().setAttribute("role", loggedUser.getRole().toString());
        request.getSession().setAttribute("loggedin",true); 
        // log details 
        // displaySessionDetails(request);
        return "redirect:dashboard";
    }

    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String userdashboard(ModelMap model, HttpServletRequest request){
        
        if(!isLoggedIn(request)){
            return "redirect:login";  
        }

        model.put("name",((UserDetail)request.getSession().getAttribute("user")).getUsername());
        return "dashboard";
    }


    private boolean isLoggedIn(HttpServletRequest request){
        if(request.getSession().getAttribute("user") != null)
            return true;
        else 
            return false;
    }

    private void displaySessionDetails(HttpServletRequest request){
        Iterator<String> iter = request.getSession().getAttributeNames().asIterator();
        System.out.println("name:"+request.getSession().getAttribute("name"));
        
        while(iter.hasNext()){
            System.out.println("Session:"+iter.next());
        }  
    }
}
