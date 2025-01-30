package com.vvkalinin.api.cart.controller;

import com.vvkalinin.api.BaseApi;
import com.vvkalinin.api.cart.model.UserCart;
import com.vvkalinin.api.user.model.User;
import com.vvkalinin.utils.annotations.url.Url;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@Url("/carts")
public class CartController extends BaseApi {

    public List<UserCart> getUsersCart(int userId) {
        return given()
                .spec(getRequestSpecification())
                .pathParam("userId", userId)
                .get("/user/{userId}")
                .then().log().ifValidationFails()
                .assertThat().statusCode(SC_OK)
                .extract().body().jsonPath()
                .getList("", UserCart.class);
    }

}
