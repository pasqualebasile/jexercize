package pl.piomin.services.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebConfig implements WebFluxConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

/*
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        LOGGER.info("-->>> addResourceHandlers");
        registry.addResourceHandler("/**")
        // Handle all requests
                .addResourceLocations("classpath:/static"); // Serve from the 'static' folder
    }
*/
}
