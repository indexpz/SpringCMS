package pl.codeslab.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.codeslab.app.web.converters.AuthorsConverter;
import pl.codeslab.app.web.converters.CategoryConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(authorConverter());
        registry.addConverter(categoryConverter());
    }

    @Bean
    public AuthorsConverter authorConverter() {
        return new AuthorsConverter();
    }

    @Bean
    public CategoryConverter categoryConverter(){
        return new CategoryConverter();
    }

}
