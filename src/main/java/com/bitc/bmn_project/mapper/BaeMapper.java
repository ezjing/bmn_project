package com.bitc.bmn_project.mapper;

import com.bitc.bmn_project.DTO.CeoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BaeMapper {

  CeoDTO selectCeoDetail(int ceoIdx) throws Exception;

  int getFollows(@Param("ceoStore") String ceoStore) throws Exception;
}
