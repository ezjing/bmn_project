package com.bitc.bmn_project.mapper;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.DTO.CustomerDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SimMapper {

    int idCheckCustomer(String userId) throws Exception;
    int idCheckCeo(String userId) throws Exception;

    void signUpCustomer(CustomerDTO customer) throws Exception;

    void signUpCeo(CeoDTO ceo) throws Exception;
}
