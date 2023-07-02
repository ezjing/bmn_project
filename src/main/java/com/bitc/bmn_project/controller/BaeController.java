package com.bitc.bmn_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bmn")
public class BaeController {
  @RequestMapping("")
  public String index() throws Exception {
    return "index";
  }

  @RequestMapping(value = "/viewDetail", method = RequestMethod.GET)
  public ModelAndView viewDetail() throws Exception {
    ModelAndView mv = new ModelAndView("bmn/viewDetail");
    return mv;
  }
}
