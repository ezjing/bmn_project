package com.bitc.bmn_project.service;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.DTO.CustomerDTO;
import com.bitc.bmn_project.mapper.SimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimServiceImpl implements SimService {

    @Autowired
    private SimMapper simMapper;

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
}
