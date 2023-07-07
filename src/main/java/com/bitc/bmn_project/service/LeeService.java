package com.bitc.bmn_project.service;

import com.bitc.bmn_project.DTO.ReservationDTO;

import java.util.List;

public interface LeeService {
    void insertReservation(ReservationDTO reservation) throws Exception;

    List<ReservationDTO> selectReservation(int ceoIdx) throws Exception;

<<<<<<< HEAD
<<<<<<< HEAD
    ReservationDTO getReservationInfo(int customerIdx, int ceoIdx, String reservationDate, int reservationTime) throws Exception;

    List<ReservationDTO> selectDateReservation(int ceoIdx, String reservationDate) throws Exception;

    ReservationDTO selectTimeReservation(String reservationDate, int ceoIdx, int reservationTime) throws Exception;

    int reservationConfirm(String reservationDate, int ceoIdx, int reservationTime) throws  Exception;

    int reservationRefuse(String reservationDate, int ceoIdx, int reservationTime) throws  Exception;

    List<ReservationDTO> myPageReservation(int customerIdx) throws Exception;

    List<ReservationDTO> myPageReview(int customerIdx) throws Exception;
=======
    ReservationDTO getReservationInfo(int customerIdx, int ceoIdx) throws Exception;
>>>>>>> fa999be (bmn_0703(가게/날짜에 따른 ajax구현 완료, 예약 정보가져오기 진행중))
=======
    ReservationDTO getReservationInfo(int customerIdx, int ceoIdx, String reservationDate, int reservationTime) throws Exception;
>>>>>>> 9a4b2cf (bmn_0704(손님 예약페이지 모달창으로 데이터 입력, 호출 작성 완료))
}
