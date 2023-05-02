package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// SWAGGER: API 문서를 자동으로 생성해 줌

//Swagger-UI 2.x 확인
//http://localhost:8080/{your-app-root}/swagger-ui.html

//Swagger-UI 3.x 확인
//http://localhost:8080/{your-app-root}/swagger-ui/index.html

@Configuration
@EnableSwagger2 // swagger 기능 활성화
public class SwaggerConfiguration {

	@Bean
	public Docket makeDoket() {
		// 문서 생성을 위한 가장 기본이 되는 객체
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		ApiSelectorBuilder builder = docket.select();
		
		// apis(): controller가 있는 패키지 지정
		builder = builder.apis(RequestHandlerSelectors.basePackage("com.mvc.controller"));
		
		// paths(): api()로 선택된 api 중 특정 path 조건에 맞는 api들을 다시 필터링하여 문서화 함
		builder = builder.paths(PathSelectors.ant("/**/*/**"));
		
		docket = builder.build(); // 문서 생성
		docket = docket.apiInfo(info()); // 추가적 정보 포함
		
		return docket;
	}
	
	private ApiInfo info() {
		ApiInfoBuilder b = new ApiInfoBuilder();
		b = b.title("EnjoyTrip API");
		b = b.description("<h3>EnjoyTrip</h3>EnjoyTrip API<br><img src=image/f2.jpg width=150>");
		b = b.version("1.0");
		ApiInfo ai = b.build();
		
		return ai;
	}
}
