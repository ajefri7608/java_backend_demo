package com.example.java_backend_demo.config;
import com.example.java_backend_demo.Interceptor.UserTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Autowired
    private UserTokenInterceptor userTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        try {
            registry.addInterceptor(userTokenInterceptor)
                    //.addPathPatterns("/users/login*");
        }catch (Exception e){
            System.out.println(e.toString());
        }

        //WebMvcConfigurer.super.addInterceptors(registry);
    }
}
