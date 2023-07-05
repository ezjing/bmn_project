package com.bitc.bmn_project.mapper;

import com.bitc.bmn_project.DTO.CeoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    // 한식
    List<CeoDTO> selectKFood() throws Exception;

    List<CeoDTO> searchList(String searchIdx) throws Exception;

    List<CeoDTO> storeLists() throws Exception;

    List<CeoDTO> followLists() throws Exception;
}
