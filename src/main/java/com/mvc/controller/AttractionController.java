package com.mvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.service.AttractionService;
import com.mvc.vo.Attraction;

import io.swagger.annotations.ApiOperation;

@RestController
public class AttractionController {
	
	@Autowired
    AttractionService service;
	
	@GetMapping(value = "/attraction/{sido_code}")
    @ApiOperation(notes="지역별 관광지 정보 수집", value="sido_code 별 관광지 정보 수집")
    public List<Attraction> selectBySidoCode(@PathVariable String sido_code) throws Exception {
        return service.selectBySidoCode(sido_code);
    }
	
	@GetMapping(value = "/attraction/search")
    @ApiOperation(notes="지역별 원하는 컨텐츠 별 관광지 정보 수집", value="sido_code & content_type_id 별 관광지 정보 수집")
    public List<Attraction> selectBySidoCodeAndContentTypeId(@RequestBody Map<String, String> rb) throws Exception {
		String sido_code = rb.get("sido_code");
		String content_type_id = rb.get("content_type_id");
        return service.selectBySidoCodeAndContentTypeId(sido_code, content_type_id);
    }

}
