package com.bitc.bmn_project.controller;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.DTO.CustomerDTO;
import com.bitc.bmn_project.service.SimService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/bmn")
public class SimController {

    @Autowired
    private SimService simService;


    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doLoginView() throws Exception {

        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLoginProcess(@RequestParam String userId,
                                 @RequestParam String userPw,
                                 HttpServletRequest req) throws Exception {
        String returnUrl = req.getRequestURI();
        System.out.println("userId : " + userId + ", userPw :" + userPw + ", returnUrl :" + returnUrl);

        int result = 0;
        int grade = 0;
        // 1. DB에 존재하는지 확인(ID 만)
        int isUser = simService.isUser(userId);

        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(60);
        CustomerDTO customer;
        CeoDTO ceo;

        // 없는 ID일 경우 메시지 리턴
        if (isUser == 0) {
            session.setAttribute("failMsg", "존재하지 않는 아이디입니다.");
            session.setMaxInactiveInterval(1);
            return "redirect:" + returnUrl;
        }

        //
        // 2-1-1. 손님 DB에 데이터 존재하는지 확인
        // 2-1-2. 관리자인지 확인()
        int who = simService.isCustomer(userId, userPw);
        if (who != 0) {
            grade = simService.getGrade(userId);
        }

        switch (grade) {
            // 손님이 아님(사장이거나, 로그인 실패)
            // 2-2. 사장님 DB에 데이터 존재하는지 확인
            case 0 -> result = simService.isCeo(userId, userPw);

            // 3-1 로그인 성공 일반회원
            // 3-2 로그인 성공 우수회원
            case 1, 2 -> {
                customer = simService.getCustomerInfo(userId);
                session.setAttribute("user", customer);
                session.removeAttribute("failMsg");

                return "redirect:" + returnUrl;
            }

            // 3-3 로그인 성공 관리자
            case 10 -> {
                session.setAttribute("user", "admin");
                session.removeAttribute("failMsg");
                return "redirect:" + returnUrl;
            }

        }

        // 로직 조정 필요
        if (result == 1) { // 3-4 로그인 성공 사장님
            ceo = simService.getCeoInfo(userId);
            session.setAttribute("user", ceo);
            session.removeAttribute("failMsg");
        } else {
            // 실패시 메시지 전송
            session.setAttribute("failMsg", "비밀번호가 틀렸습니다.");
            session.setMaxInactiveInterval(1);
        }
        return "redirect:" + returnUrl;

    }


    @RequestMapping("/logOut")
    public String doLogOut(HttpServletRequest req) throws Exception {


        HttpSession session = req.getSession();
        session.invalidate();

        // 로그아웃 후 메인으로
        return "redirect:/bmn/login";
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
    public String doCeoStore() throws Exception {

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
    public String doAddStore(CeoDTO store,
                             @RequestParam("ceoMainImgFile") MultipartFile mainImage,
                             @RequestParam("ceoThumbnailImgFile") MultipartFile thumbnail,
                             @RequestParam(value = "files", required = false) List<MultipartFile> files
    ) throws Exception {
        System.out.println(store);
        System.out.println(mainImage);
        System.out.println(thumbnail);
        System.out.println(files);

        simService.addStore(store, mainImage, thumbnail, files);

        return "redirect:/bmn/";
    }
}
