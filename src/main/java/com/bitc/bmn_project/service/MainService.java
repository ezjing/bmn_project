package com.bitc.bmn_project.service;

import com.bitc.bmn_project.DTO.CeoDTO;

import java.util.List;

public interface MainService {
    List<CeoDTO> selectKFood() throws Exception;

    List<CeoDTO> storeLists(String keyWorld) throws Exception;

    List<CeoDTO> followLists(String keyWorld) throws Exception;

    List<CeoDTO> selectJFoods() throws Exception;

    List<CeoDTO> selectCFoods() throws Exception;

    List<CeoDTO> selectWFoods() throws Exception;
}
