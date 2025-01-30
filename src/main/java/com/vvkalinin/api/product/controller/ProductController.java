package com.vvkalinin.api.product.controller;

import com.vvkalinin.api.BaseApi;
import com.vvkalinin.api.product.model.Product;
import com.vvkalinin.utils.annotations.url.Url;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@Url("/products")
public class ProductController extends BaseApi {

    public List<Product> getProducts() {
        return given()
                .spec(getRequestSpecification())
                .get()
                .then().log().ifValidationFails()
                .assertThat().statusCode(SC_OK)
                .extract().body().jsonPath()
                .getList("", Product.class);
    }

}
