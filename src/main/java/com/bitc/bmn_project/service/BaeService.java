package com.bitc.bmn_project.service;

import com.bitc.bmn_project.DTO.CeoDTO;

public interface BaeService {

  CeoDTO selectCeoDetail(int ceoIdx) throws Exception;

  int getFollows(String ceoStore) throws Exception;
}
