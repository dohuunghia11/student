package com.self.project.student.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class StudentServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    StudentServiceInterceptor studentServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(studentServiceInterceptor);
    }
}
