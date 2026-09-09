package gm.technova.commons.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Priorizamos la carpeta externa uploads si existe, sino usamos el classpath
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:uploads/images/", "classpath:/static/images/", "classpath:/images/");
    }
}
