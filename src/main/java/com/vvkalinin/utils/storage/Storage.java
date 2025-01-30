package com.vvkalinin.utils.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static java.lang.String.format;
import static java.util.Objects.isNull;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class Storage {

    private static final Logger LOGGER = LoggerFactory.getLogger(Storage.class);

    private final Map<String, Object> storage = new HashMap<>();

    public void storeObject(final String key, final Object obj) {
        if (isNull(obj)) {
            LOGGER.warn("Saving null object to session key [{}]", key);
        }
        storage.put(key, obj);
        LOGGER.debug("Key [{}] has been added to session storage: {}", key, obj);
    }

    public <T> T getStoredObject(final String key, final Class<T> returnType) {
        if (isKeyPresent(key)) {
            try {
                return returnType.cast(storage.get(key));
            } catch (final ClassCastException e) {
                throw new IllegalStateException(format("Unable to cast object with key [%s] to {%s} type.",
                        key, returnType.getCanonicalName()), e);
            }
        } else {
            throw new IllegalStateException(format("No object with key {%s} found in session storage.", key));
        }
    }

    public boolean isKeyPresent(final String key) {
        return storage.containsKey(key);
    }

}
