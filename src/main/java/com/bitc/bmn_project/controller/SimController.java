package com.bitc.bmn_project.controller;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.DTO.CustomerDTO;
import com.bitc.bmn_project.service.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/signUp/customer/signUp", method = RequestMethod.POST)
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

    @RequestMapping(value = "/signUp/ceo/signUp", method = RequestMethod.POST)
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

    @RequestMapping("/ceoStore")
    public String doTest() throws Exception {

        return "ceoStore";
    }


    @RequestMapping(value = "/ceoStore/popup", method = RequestMethod.GET)
    public String doPopup() throws Exception {
        return "addrPopup";
    }

    @RequestMapping(value = "/ceoStore", method = RequestMethod.POST)
    public ModelAndView doPopupCallback(
            @RequestParam("inputYn") String inputYn,
            @RequestParam("roadFullAddr") String roadFullAddr,
            @RequestParam("roadAddrPart1") String roadAddrPart1,
            @RequestParam("roadAddrPart2") String roadAddrPart2,
            @RequestParam("engAddr") String engAddr,
            @RequestParam("jibunAddr") String jibunAddr,
            @RequestParam("zipNo") String zipNo,
            @RequestParam("addrDetail") String addrDetail,
            @RequestParam("admCd") String admCd,
            @RequestParam("rnMgtSn") String rnMgtSn,
            @RequestParam("bdMgtSn") String bdMgtSn,
            @RequestParam("detBdNmList") String detBdNmList,
            @RequestParam("bdNm") String bdNm,
            @RequestParam("bdKdcd") String bdKdcd,
            @RequestParam("siNm") String siNm,
            @RequestParam("sggNm") String sggNm,
            @RequestParam("emdNm") String emdNm,
            @RequestParam("liNm") String liNm,
            @RequestParam("rn") String rn,
            @RequestParam("udrtYn") String udrtYn,
            @RequestParam("buldMnnm") String buldMnnm,
            @RequestParam("buldSlno") String buldSlno,
            @RequestParam("mtYn") String mtYn,
            @RequestParam("lnbrMnnm") String lnbrMnnm,
            @RequestParam("lnbrSlno") String lnbrSlno,
            @RequestParam("emdNo") String emdNo,
            @RequestParam("entX") String entX,
            @RequestParam("entY") String entY
    ) throws Exception {
        ModelAndView mv = new ModelAndView("addrPopup");

        mv.addObject("inputYn", inputYn);
        mv.addObject("roadFullAddr", roadFullAddr);
        mv.addObject("roadAddrPart1", roadAddrPart1);
        mv.addObject("roadAddrPart2", roadAddrPart2);
        mv.addObject("engAddr", engAddr);
        mv.addObject("jibunAddr", jibunAddr);
        mv.addObject("zipNo", zipNo);
        mv.addObject("addrDetail", addrDetail);
        mv.addObject("admCd", admCd);
        mv.addObject("rnMgtSn", rnMgtSn);
        mv.addObject("bdMgtSn", bdMgtSn);
        mv.addObject("detBdNmList", detBdNmList);
        mv.addObject("bdNm", bdNm);
        mv.addObject("bdKdcd", bdKdcd);
        mv.addObject("siNm", siNm);
        mv.addObject("sggNm", sggNm);
        mv.addObject("emdNm", emdNm);
        mv.addObject("liNm", liNm);
        mv.addObject("rn", rn);
        mv.addObject("udrtYn", udrtYn);
        mv.addObject("buldMnnm", buldMnnm);
        mv.addObject("buldSlno", buldSlno);
        mv.addObject("mtYn", mtYn);
        mv.addObject("lnbrMnnm", lnbrMnnm);
        mv.addObject("lnbrSlno", lnbrSlno);
        mv.addObject("emdNo", emdNo);
        mv.addObject("entX", entX);
        mv.addObject("entY", entY);

        return mv;
    }


    @RequestMapping(value = "/ceoStore/addStore", method = RequestMethod.POST)
    public String doAddStore(CeoDTO store, MultipartHttpServletRequest multipart) throws Exception {
        // 1. 사용자가 입력한 내용을 전달받음
        // 2. 서비스를 이용하여 DB에 insert
        // 3. 목록 페이지로 리다이렉트

        // 클라이언트에서 전달받은 데이터를 매개변수로 하여 서비스의 insertBoard() 메소드 실행
        // 전달받은 파일 정보를 처리하기 위해서 서비스의 insertBoard 메소드에
        // MultiPartHttpServletRequest 타입의 매개변수가 추가됨
        System.out.println(store);
        System.out.println(multipart);

//        simService.addStore(store, multipart);

        return "redirect:/bmn/";
    }
}
