package com.bitc.bmn_project.controller;

import com.bitc.bmn_project.DTO.ReservationDTO;
import com.bitc.bmn_project.service.LeeService;
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

    @RequestMapping(value = "/reservationCus/ceoIdx={ceoIdx}", method = RequestMethod.GET)
    public ModelAndView reservationCusView(@PathVariable int ceoIdx) throws Exception {
        ModelAndView mv = new ModelAndView("reservation/reservationCus");

        List<ReservationDTO> reservationInfo = leeService.selectReservation(ceoIdx);  // 예약 정보 들고오기

        mv.addObject("reservationInfo", reservationInfo);

        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/reservationCus/ceoIdx={ceoIdx}", method = RequestMethod.POST)
    public Object reservationCus(@RequestParam("reservationDate") String reservationDate, int ceoIdx) throws Exception {    // 날짜정보 제대로 넘어옴!
        List<ReservationDTO> reservationList = new ArrayList<>();   // 전체 정보
        reservationList = leeService.selectReservation(ceoIdx);
        List<Integer> reservationTime = new ArrayList<>();  // time만

        for (ReservationDTO reservation : reservationList) {
            if (reservationDate.equals(reservation.getReservationDate())) {
                int time = reservation.getReservationTime();   // 날짜 하나 들고오기
//                reservation.getReservationTime();

                reservationTime.add(time);
            }
        }


//        return reservationList;
        return reservationTime; // 제대로 넘어감
    }

//    public ModelAndView reservationCus(ReservationDTO reservation) throws Exception {
//        ModelAndView mv = new ModelAndView("reservation/reservationCus");
//
//        leeService.insertReservation(reservation);  // 예약 정보 입력
//
////        int idx = reservation.getReservationIdx();
//
////        ReservationDTO reservationInfo = leeService.selectReservation(idx);  // 예약 정보 들고오기.. 모든 정보를 가져와야하는데.... 사장이 입력 + 다른 고객 입력 + 본인이 한 다른 예약 까지도
////
////        mv.addObject("reservationInfo", reservationInfo);
//
//        return mv;
//    }
}
