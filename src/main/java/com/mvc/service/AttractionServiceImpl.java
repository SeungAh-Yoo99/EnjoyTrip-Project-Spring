package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mapper.AttractionMapper;
import com.mvc.vo.Attraction;

@Service
public class AttractionServiceImpl implements AttractionService {
	
	@Autowired
	AttractionMapper mapper;

	@Override
	public List<Attraction> selectBySidoCode(String sido_code) throws Exception {
		return mapper.selectBySidoCode(sido_code);
	}

	@Override
	public List<Attraction> selectBySidoCodeAndContentTypeId(String sido_code, String content_type_id)
			throws Exception {
		return mapper.selectBySidoCodeAndContentTypeId(sido_code, content_type_id);
	}

}
