package com.bitc.bmn_project.controller;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.DTO.CustomerDTO;
import com.bitc.bmn_project.service.BaeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bmn")
public class BaeController {
  @Autowired
  private BaeService baeService;

  @RequestMapping(value = "/viewDetail/{ceoIdx}", method = RequestMethod.GET)
  public ModelAndView viewDetail(@PathVariable("ceoIdx") int ceoIdx, HttpServletRequest req) throws Exception {
    ModelAndView mv = new ModelAndView("bmn/viewDetail");

    HttpSession session = req.getSession();

    // 가게정보 조회
    CeoDTO ceoDto = baeService.selectCeoDetail(ceoIdx);

    // 팔로워수 조회
    String ceoStore = ceoDto.getCeoStore();
    int followCnt = baeService.getFollows(ceoStore);

    session.setAttribute("customerIdx", 1);

    mv.addObject("ceoDto", ceoDto);
    mv.addObject("followCnt", followCnt);

    return mv;
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login() throws Exception {
    return "bmn/login";
  }

  @ResponseBody
  @RequestMapping(value = "/updateFollow", method = RequestMethod.PUT)
  public Object updateFollow(@RequestParam("ceoStore") String ceoStore, @RequestParam("customerIdx") int customerIdx) throws Exception {
    int result = 0;
    CustomerDTO customerDTO = baeService.selectCustomerInfo(customerIdx);
    if (customerDTO.getCustomerFollow().contains(ceoStore)) {
      baeService.deleteFollow(customerIdx, ceoStore);
    }
    else {
      baeService.updateFollow(customerIdx, ceoStore);
    }
    result = baeService.getFollows(ceoStore);



    return result;
  }



}

