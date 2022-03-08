package com.java.spring.starterweb.controller;

import com.java.spring.starterweb.annotations.TrackExecutionTime;
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
import java.util.Random;

@Controller
public class TestController {

    @Autowired
    LoginService loginService;

    private static final Logger LOGGER = LogManager.getLogger(TestController.class);

    @TrackExecutionTime(url="/test1", type="ENDPOINT", name="TestController")
    @ResponseBody
    @RequestMapping(value="/test1", method = RequestMethod.GET)
    public Status test1() throws InterruptedException {
        Thread.sleep(new Random().ints(2,2000).findFirst().getAsInt());
        LOGGER.info("test1 called");
        return new Status("UP","test1-web-application is up!");
    }

    @ResponseBody
    @RequestMapping(value="/test2", method = RequestMethod.GET)
    public Status test2(){
        LOGGER.info("test2 called");
        return new Status("UP","test1-web-application is up!");
    }


    @ResponseBody
    @RequestMapping(value="/test3", method = RequestMethod.GET)
    public Status test3(){
        LOGGER.info("test3 called");
        return new Status("UP","test3-web-application is up!");
    }

}
