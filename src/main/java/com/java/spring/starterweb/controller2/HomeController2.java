package com.java.spring.starterweb.controller2;

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

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

@Controller
public class HomeController2 {

    @Autowired
    LoginService loginService;

    private static final Logger LOGGER = LogManager.getLogger(HomeController2.class);

    @ResponseBody
    @RequestMapping(value="/status2", method = RequestMethod.GET)
    public Status status(){
        LOGGER.info("status2 called");
        return new Status("UP","status2 - web-application is up!");
    }
    

}
