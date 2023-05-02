package com.mvc.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.vo.Attraction;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AttractionMapper {

	List<Attraction> selectBySidoCode(String sido_code) throws SQLException;

	List<Attraction> selectBySidoCodeAndContentTypeId(String sido_code, String content_type_id) throws SQLException;

}
