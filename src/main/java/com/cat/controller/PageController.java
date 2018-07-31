package com.cat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 刘文博
 * 2018/7/11 21:09
 */
@Controller
public class PageController {
    @RequestMapping(value = "/page/{type}/{view}",method = RequestMethod.GET)
    public String page(@PathVariable String type,@PathVariable String view){
        return type+"/"+view;
    }
}
