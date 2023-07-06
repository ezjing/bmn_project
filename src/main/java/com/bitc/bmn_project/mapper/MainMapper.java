package com.bitc.bmn_project.mapper;

import com.bitc.bmn_project.DTO.CeoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    List<CeoDTO> storeLists(String keyWorld) throws Exception;

    List<CeoDTO> followLists(String keyWorld) throws Exception;

    // 한식
    List<CeoDTO> selectKFood() throws Exception;
    // 일식
    List<CeoDTO> selectJFoods() throws Exception;
    // 중식
    List<CeoDTO> selectCFoods() throws Exception;
    // 양식
    List<CeoDTO> selectWFoods() throws Exception;
}
