package com.vvkalinin.api.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record User(
        int id,
        String email,
        String password,
        String username) {
}
