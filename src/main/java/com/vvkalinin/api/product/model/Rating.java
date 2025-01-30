package com.vvkalinin.api.product.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Rating(
        Double rate,
        Integer count) {
}
