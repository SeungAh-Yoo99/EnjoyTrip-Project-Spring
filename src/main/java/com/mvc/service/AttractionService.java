package com.mvc.service;

import java.util.List;

import com.mvc.vo.Attraction;

public interface AttractionService {

	List<Attraction> selectBySidoCode(String sido_code) throws Exception;

	List<Attraction> selectBySidoCodeAndContentTypeId(String sido_code, String content_type_id) throws Exception;

}
