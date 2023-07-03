package com.bitc.bmn_project.controller;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.DTO.CustomerDTO;
import com.bitc.bmn_project.service.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bmn")
public class SimController {

    @Autowired
    private SimService simService;


    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping("/signUp/customer")
    public String doSignUpCustomerView() throws Exception {


        return "signUpCustomer";
    }

    @RequestMapping(value="/signUp/customer/signUp", method = RequestMethod.POST)
    public String doSignUpCustomerProcess(CustomerDTO customer) throws Exception {

        System.out.println(customer);
        simService.signUpCustomer(customer);

// 나중에 메인페이지
        return "redirect:/bmn/";
    }

    @RequestMapping("/signUp/ceo")
    public String doSignUpCeoView() throws Exception {

        return "signUpCeo";
    }

    @RequestMapping(value="/signUp/ceo/signUp", method = RequestMethod.POST)
    public String doSignUpCeoProcess(CeoDTO ceo) throws Exception {

        simService.signUpCeo(ceo);

// 나중에 메인페이지
        return "redirect:/bmn/";
    }

    @ResponseBody
    @RequestMapping(value = "/signUp/idCheck", method = RequestMethod.POST)
    public String doIdCheck(@RequestParam("userId") String userId) throws Exception {

        int result1 = simService.idCheckCustomer(userId);
        int result2 = simService.idCheckCeo(userId);

        int result = result1 + result2;

        if (result >= 1) {
            return "true";
        } else {
            return "false";
        }
    }


}
