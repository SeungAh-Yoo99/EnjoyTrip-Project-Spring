package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.service.AttractionService;
import com.mvc.vo.Attraction;

import io.swagger.annotations.ApiOperation;

@RestController
public class AttractionController {
	
	@Autowired
    AttractionService service;
	
	@GetMapping(value = "/attration/{sido_code}")
    @ApiOperation(notes="지역별 관광지 정보 수집", value="sido_code 별 관광지 정보 수집")
    public List<Attraction> selectBySidoCode(@PathVariable String sido_code) throws Exception {
        return service.selectBySidoCode(sido_code);
    }
	
	@GetMapping(value = "/attration/{sido_code}/{content_type_id}")
    @ApiOperation(notes="지역별 원하는 컨텐츠 별 관광지 정보 수집", value="sido_code & content_type_id 별 관광지 정보 수집")
    public List<Attraction> selectBySidoCodeAndContentTypeId(@PathVariable String sido_code, @PathVariable String content_type_id) throws Exception {
        return service.selectBySidoCodeAndContentTypeId(sido_code, content_type_id);
    }

}
