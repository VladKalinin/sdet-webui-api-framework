package com.vvkalinin.stepdefinition.api;

import com.vvkalinin.api.cart.controller.CartController;
import com.vvkalinin.api.product.model.Product;
import com.vvkalinin.api.user.model.User;
import com.vvkalinin.stepdefinition.BaseStepDefinition;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CartStepDefinition extends BaseStepDefinition {

    @Autowired
    private CartController cartController;

    @Then("^verify user (.*) has product (.*) in the cart$")
    public void getProducts(String userEmail, String productTitle) {
        int userId = getUserIdByEmail(userEmail);
        int productId = getProductIdByTitle(productTitle);
        assertThat(cartController.getUsersCart(userId).getFirst().products()
                .stream().anyMatch(p -> p.productId() == productId))
                .withFailMessage("%s do not contains product with id %s in the cart", userEmail, productId)
                .isTrue();
    }

    private int getUserIdByEmail(String email) {
        List<User> users = storage.getStoredObject("users", List.class);
        return users.stream().filter(user -> user.email().equals(email)).findFirst().orElseThrow().id();
    }

    private int getProductIdByTitle(String title) {
        List<Product> products = storage.getStoredObject("products", List.class);
        return products.stream().filter(product -> product.title().trim().equals(title)).findFirst().orElseThrow().id();
    }

}
