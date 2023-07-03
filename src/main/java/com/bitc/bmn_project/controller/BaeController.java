package com.bitc.bmn_project.controller;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.service.BaeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bmn")
public class BaeController {
  @Autowired
  private BaeService baeService;

  @RequestMapping("")
  public String index() throws Exception {
    return "index";
  }

  @RequestMapping(value = "/viewDetail/{ceoIdx}", method = RequestMethod.GET)
  public ModelAndView viewDetail(@PathVariable("ceoIdx") int ceoIdx) throws Exception {
    ModelAndView mv = new ModelAndView("bmn/viewDetail");

    // 가게정보 조회
    CeoDTO ceoDto = baeService.selectCeoDetail(ceoIdx);

    // 팔로워수 조회
    String ceoStore = ceoDto.getCeoStore();
    int followCnt = baeService.getFollows(ceoStore);

    mv.addObject("ceoDto", ceoDto);
    mv.addObject("followCnt", followCnt);

    return mv;
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login() throws Exception {
    return "bmn/login";
  }



}

