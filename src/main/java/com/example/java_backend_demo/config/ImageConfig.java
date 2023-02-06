package com.example.java_backend_demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@Configuration
public class ImageConfig implements WebMvcConfigurer{

    @Value("${SavePath.Image}")
    private String ImagePath;

    @Value("${SavePath.ImageMapper")
    private String ImageMapperPath;
    

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(ImageMapperPath + "**").addResourceLocations("file: " + ImagePath);
    }
}
