package com.vvkalinin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ProfileMatcher {

    @Autowired
    private Environment environment;

    public boolean isProfilesMatches(String key) {
        return Arrays.stream(environment.getActiveProfiles()).anyMatch(profile -> profile.contains(key));
    }

}
