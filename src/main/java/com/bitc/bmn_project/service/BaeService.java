package com.bitc.bmn_project.service;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.DTO.CustomerDTO;

public interface BaeService {

  CeoDTO selectCeoDetail(int ceoIdx) throws Exception;

  int getFollows(String ceoStore) throws Exception;

  void updateFollow(int customerIdx, String ceoStore) throws Exception;

  CustomerDTO selectCustomerInfo(int customerIdx) throws Exception;
}
