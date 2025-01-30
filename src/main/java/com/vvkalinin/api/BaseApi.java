package com.vvkalinin.api;

import com.vvkalinin.utils.annotations.url.ApiUrlAnnotationProcessor;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;

public abstract class BaseApi {

    @Value("${webdriver.base.api.url}")
    private String baseUrl;

    protected ApiUrlAnnotationProcessor getApiUrlAnnotationProcessor() {
        return new ApiUrlAnnotationProcessor(this);
    }

    protected RequestSpecification getRequestSpecification() {
        String path = getApiUrlAnnotationProcessor().getClassUrlWithParams();
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setBasePath(path)
                .setContentType(ContentType.JSON)
                //.addFilter(new AllureRestAssured())
                .build();
    }

}
