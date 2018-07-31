package com.cat.controller;

import com.cat.entity.Man;
import com.cat.service.ManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;

/**
 * 刘文博
 * 2018/7/20 16:39
 */
@Controller
@RequestMapping(value = "user")
public class manController {

@Autowired
private ManService manService;






      @RequestMapping(value = "/fixPersonInfo",method = RequestMethod.POST)
      public String fixPersonInfo(@RequestParam("logname")String logname,
                               @RequestParam("sex")String sex,
                               @RequestParam("borntime")String borntime,
                               @RequestParam("phone")String phone,
                               @RequestParam("address")String address,
                               HttpSession session){
          Man man=new Man();
          man.setLogname(logname);
          man.setSex(sex);
          man.setBorntime(borntime);
          man.setPhone(phone);
          man.setAddress(address);
          boolean b = manService.addManInfo(man);
          if (b){
              return "user/personal-data";
          }

          return null;
      }

}
