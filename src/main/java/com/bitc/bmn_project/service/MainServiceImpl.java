package com.bitc.bmn_project.service;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService{
    @Autowired
    private MainMapper mainMapper;
    @Override
    public List<CeoDTO> selectKFood() throws Exception {
        return mainMapper.selectKFood();
    }

    @Override
    public List<CeoDTO> searchList(String searchIdx) throws Exception {
        return mainMapper.searchList(searchIdx);
    }

    @Override
    public List<CeoDTO> storeLists() throws Exception {
        return mainMapper.storeLists();
    }

    @Override
    public List<CeoDTO> followLists() throws Exception {
        return mainMapper.followLists();
    }
}
