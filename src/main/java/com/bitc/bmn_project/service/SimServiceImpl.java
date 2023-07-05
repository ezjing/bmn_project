package com.bitc.bmn_project.service;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.DTO.CustomerDTO;
import com.bitc.bmn_project.DTO.StoreImageDTO;
import com.bitc.bmn_project.common.FileUtils;
import com.bitc.bmn_project.mapper.SimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class SimServiceImpl implements SimService {

    @Autowired
    private SimMapper simMapper;

    @Autowired
    private FileUtils fileUtils;

    @Override
    public int idCheckCustomer(String userId) throws Exception {

        return simMapper.idCheckCustomer(userId);
    }

    @Override
    public int idCheckCeo(String userId) throws Exception {

        return simMapper.idCheckCeo(userId);
    }

    @Override
    public void signUpCustomer(CustomerDTO customer) throws Exception {
        simMapper.signUpCustomer(customer);
    }

    @Override
    public void signUpCeo(CeoDTO ceo) throws Exception {
        simMapper.signUpCeo(ceo);
    }

    @Override
    public void addStore(CeoDTO store, MultipartHttpServletRequest uploadImages) throws Exception {



        simMapper.addStore(store);


//        List<StoreImageDTO> fileList = fileUtils.parseFileInfo(store.getCeoIdx(), uploadImages);

//        // CollectionUtils : 스프링프레임워크에서 제공하는 클래스
//        if (CollectionUtils.isEmpty(fileList) == false) {
//            simMapper.insertBoardFileList(fileList);
//        }
    }
}
