package com.bitc.bmn_project.service;

import com.bitc.bmn_project.DTO.CeoDTO;

import java.util.List;

public interface MainService {
    List<CeoDTO> selectKFood() throws Exception;

    List<CeoDTO> searchList(String searchIdx) throws Exception;

    List<CeoDTO> storeLists() throws Exception;

    List<CeoDTO> followLists() throws Exception;
}
