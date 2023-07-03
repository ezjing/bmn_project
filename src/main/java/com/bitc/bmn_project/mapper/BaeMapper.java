package com.bitc.bmn_project.mapper;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.DTO.CustomerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BaeMapper {

  CeoDTO selectCeoDetail(int ceoIdx) throws Exception;

  int getFollows(@Param("ceoStore") String ceoStore) throws Exception;

  void updateFollow(int customerIdx, String ceoStore) throws Exception;

  CustomerDTO selectCustomerInfo(int customerIdx) throws Exception;
}
