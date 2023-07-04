package com.bitc.bmn_project.service;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.DTO.CustomerDTO;
import com.bitc.bmn_project.DTO.QuestionDTO;
import com.bitc.bmn_project.mapper.BaeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaeServiceImpl implements BaeService {
  @Autowired
  private BaeMapper baeMapper;

  // 가게정보 조회
  @Override
  public CeoDTO selectCeoDetail(int ceoIdx) throws Exception {
    CeoDTO ceoDTO = baeMapper.selectCeoDetail(ceoIdx);

    return ceoDTO;
  }

  // 팔로워 수 조회
  @Override
  public int getFollows(String ceoStore) throws Exception {
    int result = baeMapper.getFollows(ceoStore);
    return result;
  }

  @Override
  public void updateFollow(int customerIdx, String ceoStore) throws Exception {
    baeMapper.updateFollow(customerIdx, ceoStore);
  }

  @Override
  public CustomerDTO selectCustomerInfo(int customerIdx) throws Exception {
    CustomerDTO customerDTO = baeMapper.selectCustomerInfo(customerIdx);
    return customerDTO;
  }

  @Override
  public void deleteFollow(int customerIdx, String ceoStore) throws Exception {
    baeMapper.deleteFollow(customerIdx, ceoStore);
  }

  @Override
  public List<QuestionDTO> selectQuestionList(int ceoIdx) throws Exception {
    List<QuestionDTO> questionList = baeMapper.selectQuestionList(ceoIdx);
    return questionList;
  }

  @Override
  public void insertQuestion(QuestionDTO questionDTO) throws Exception {
    baeMapper.insertQuestion(questionDTO);
  }
}
