package com.vvkalinin.api.product.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Product(
        int id,
        String title,
        Double price,
        String description,
        String category,
        String image,
        Rating rating) {
}
