package com.bitc.bmn_project.controller;

import com.bitc.bmn_project.DTO.CustomerDTO;
import com.bitc.bmn_project.DTO.ReservationDTO;
import com.bitc.bmn_project.service.LeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bmn")
public class LeeController {

    @Autowired
    private LeeService leeService;

    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

    // 고객 정보가 입력된 view 제공
    @RequestMapping(value = "/reservationCus/ceoIdx={ceoIdx}", method = RequestMethod.GET)
    public ModelAndView reservationCusView(@PathVariable int ceoIdx, HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        CustomerDTO customer = new CustomerDTO(); // 로그인 정보 쓸때 주석 해제
//        HttpSession session = req.getSession();   // 로그인 정보 쓸때 주석 해제

//        customer.setCustomerIdx((Integer) session.getAttribute("customerIdx"));
//        customer.setCustomerId((String) session.getAttribute("customerId"));
//        customer.setCustomerPw((String) session.getAttribute("customerPw"));
//        customer.setCustomerName((String) session.getAttribute("customerName"));
//        customer.setCustomerNick((String) session.getAttribute("customerNick"));    //사용할 정보만 주석 해제 닉
//        customer.setCustomerGender((String) session.getAttribute("customerGender"));
//        customer.setCustomerAge((Integer) session.getAttribute("customerAge"));
//        customer.setCustomerFollow((String) session.getAttribute("customerFollow"));
//        customer.setCustomerGrade((Integer) session.getAttribute("customerGrade")); //사용할 정보만 주석 해제 등급
//        customer.setCustomerBan((String) session.getAttribute("customerBan"));


        ModelAndView mv = new ModelAndView("reservation/reservationCus");

        List<ReservationDTO> reservationList = leeService.selectReservation(ceoIdx);  // 가게 전체 예약 정보 들고오기(reservationStat만 들고와도 괜찮)

        mv.addObject("reservationList", reservationList);
//        mv.addObject("customer", customer);    // 실제 예약한 고객의 정보 가져오기, 세션에서 정보(닉, 등급) 가져오기

        return mv;
    }

    // 가게, 날짜 정보에 따른 예약 여부 제공
    @ResponseBody
    @RequestMapping(value = "/reservationCus/ceoIdx={ceoIdx}", method = RequestMethod.POST)
    public Object reservationCusAjax(@RequestParam("reservationDate") String reservationDate, int ceoIdx) throws Exception {    // 날짜정보 제대로 넘어옴!
        List<ReservationDTO> reservationList = new ArrayList<>();   // 전체 정보
        reservationList = leeService.selectReservation(ceoIdx);
        List<Integer> dateList = new ArrayList<>();  // time만

        for (ReservationDTO reservation : reservationList) {
            if (reservationDate.equals(reservation.getReservationDate())) {
                int time = reservation.getReservationTime();   // 날짜 하나 들고오기
//                reservation.getReservationTime();

                dateList.add(time);
            }
        }
//        return reservationList;
        return dateList; // 제대로 넘어감
    }

//    public ModelAndView reservationCus(ReservationDTO reservation) throws Exception {
//        ModelAndView mv = new ModelAndView("reservation/reservationCus");
//
//        leeService.insertReservation(reservation);  // 예약 정보 입력(동일 고객 같은날 중복 예약 불가하도록 해야함)
//
////        int idx = reservation.getReservationIdx();
//
////        ReservationDTO reservationInfo = leeService.selectReservation(idx);  // 예약 정보 들고오기.. 모든 정보를 가져와야하는데.... 사장이 입력 + 다른 고객 입력 + 본인이 한 다른 예약 까지도
////
////        mv.addObject("reservationInfo", reservationInfo);
//
//        return mv;
//    }

    // 고객의 예약 정보 입력 process 및 view 제공(get 방식으로 view만 먼저 구현하는 방법도 생각해보기)
    @RequestMapping(value = "/reservationCus/ceoIdx={ceoIdx}&customerIdx={customerIdx}", method = RequestMethod.POST)   // POST 방식이라 url로 넘어오는 ceoIdx가 인식안되므로 null 인거같음
    public ModelAndView reservationCusProcess(@PathVariable int customerIdx, @PathVariable String ceoIdx, ReservationDTO reservation) throws Exception {
        ModelAndView mv = new ModelAndView("reservation/reservationCus");

        leeService.insertReservation(reservation);  // 예약 정보 입력(동일 고객 같은날 중복 예약 불가하도록 해야함)
        ReservationDTO reservationInfo = leeService.getReservationInfo(customerIdx, ceoIdx);   // 가게번호와 고객번호를 동시에 조회하여 예약 정보 가져오기

        mv.addObject("reservationInfo", reservationInfo);

        return mv;
    }
}
