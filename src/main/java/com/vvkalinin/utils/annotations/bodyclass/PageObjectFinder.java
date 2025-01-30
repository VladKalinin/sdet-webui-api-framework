package com.vvkalinin.utils.annotations.bodyclass;

import com.vvkalinin.pageobject.Page;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import static org.springframework.util.StringUtils.startsWithIgnoreCase;
import static org.springframework.util.StringUtils.trimAllWhitespace;

import java.util.Map;

@Component
public class PageObjectFinder {

    private final ApplicationContext applicationContext;

    @Autowired
    public PageObjectFinder(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Page getPageObjectBean(final String page) {
        Map<String, Page> beansOfType = applicationContext.getBeansOfType(Page.class);
        return beansOfType.values().stream()
                .filter(beanValue ->
                        startsWithIgnoreCase(beanValue.getClass().getSimpleName(), trimAllWhitespace(page)))
                .findFirst()
                .orElseThrow(() -> new NoSuchBeanDefinitionException(page));
    }

    public <T> T getBeanOfTypeByClassName(String name, Class<T> clazz) {
        return applicationContext.getBeansOfType(clazz).values().stream()
                .filter(bean -> startsWithIgnoreCase(bean.getClass().getSimpleName(), trimAllWhitespace(name)))
                .findFirst()
                .orElseThrow(() -> new NoSuchBeanDefinitionException(name));
    }

}
