package com.bitc.bmn_project.service;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.DTO.CustomerDTO;

public interface SimService {

    int idCheckCustomer(String userId) throws Exception;
    int idCheckCeo(String userId) throws Exception;

    void signUpCustomer(CustomerDTO customer) throws Exception;

    void signUpCeo(CeoDTO ceo) throws Exception;
}
