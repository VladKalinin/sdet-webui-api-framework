package com.vvkalinin.stepdefinition.api;

import com.vvkalinin.api.user.controller.UserController;
import com.vvkalinin.stepdefinition.BaseStepDefinition;
import com.vvkalinin.utils.storage.Storage;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class UserStepDefinition extends BaseStepDefinition {

    @Autowired
    private UserController userController;

    @When("^get all users")
    public void getProducts() {
        storage.storeObject("users", userController.getUsers());
    }

}
