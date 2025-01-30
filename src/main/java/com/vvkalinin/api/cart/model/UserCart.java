package com.vvkalinin.api.cart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserCart(
        int id,
        int userId,
        List<CartProduct> products
) {
}
