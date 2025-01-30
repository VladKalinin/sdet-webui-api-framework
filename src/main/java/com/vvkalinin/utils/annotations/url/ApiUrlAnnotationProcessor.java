package com.vvkalinin.utils.annotations.url;

import com.vvkalinin.api.BaseApi;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiUrlAnnotationProcessor {

    private BaseApi baseApi;

    public ApiUrlAnnotationProcessor(BaseApi baseApi) {
        this.baseApi = baseApi;
    }

    public Url getUrl() {
        return baseApi.getClass().getAnnotation(Url.class);
    }

    public String getClassUrlAnnotationValue() {
        Url urlAnnotation = getUrl();
        return Optional.ofNullable(urlAnnotation)
                .map(Url::value)
                .orElseThrow(() -> new IllegalStateException("Class may not have @Url annotation"));
    }

    public String getClassUrlWithParams(String... params) {
        return insertParametersIntoUrl(getClassUrlAnnotationValue(), params);
    }

    public String insertParametersIntoUrl(String defaultUrlPath, String... params) {
        StringBuilder sb = new StringBuilder();
        Pattern replacementPattern = Pattern.compile("\\{\\w*}");
        Matcher matcher = replacementPattern.matcher(defaultUrlPath);
        for (int i = 0; matcher.find(); i++) {
            matcher.appendReplacement(sb, params[i]);
        }
        return String.valueOf(matcher.appendTail(sb));
    }

}
