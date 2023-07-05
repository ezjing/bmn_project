package com.bitc.bmn_project.controller;

import com.bitc.bmn_project.DTO.CeoDTO;
import com.bitc.bmn_project.service.MainService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/bmn")
public class ParkController {
    @Autowired
    private MainService mainService;
    @RequestMapping(value = "/bmnMain", method = RequestMethod.GET)
    public ModelAndView bmnMain() throws Exception{
        ModelAndView mv = new ModelAndView("main/bmnMain");
        List<CeoDTO> coeDtoList = mainService.selectKFood();

        mv.addObject("ceoDtoList",coeDtoList);
        return mv;
    }

    @RequestMapping(value="/bmnSearchList", method = RequestMethod.GET)
    public ModelAndView searchList(@Param("searchIdx") String searchIdx) throws Exception{
        ModelAndView mv = new ModelAndView("main/bmnSearchList");

//        List<CeoDTO> searchList = mainService.searchList(searchIdx);
//        mv.addObject("searchList",searchList);

        // 평점 순위 리스트
        List<CeoDTO> storeList = mainService.storeLists();
        List<CeoDTO> followList = mainService.followLists();

        mv.addObject("storeList",storeList);
        mv.addObject("followList",followList);
        return mv;
    }
}
