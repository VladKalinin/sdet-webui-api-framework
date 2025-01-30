package com.vvkalinin.stepdefinition.api;

import com.vvkalinin.api.product.controller.ProductController;
import com.vvkalinin.stepdefinition.BaseStepDefinition;
import com.vvkalinin.utils.storage.Storage;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductStepDefinitions extends BaseStepDefinition {

    @Autowired
    private ProductController productController;

    @When("^get all products")
    public void getProducts() {
        storage.storeObject("products", productController.getProducts());
    }

}
