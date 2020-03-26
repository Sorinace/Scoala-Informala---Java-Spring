package ro.sorinace.sicj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan
public class MyWebConfig implements WebMvcConfigurer{
    /**
     * Configure the View Render
     * @param registry
     */
    @Override
    public void configureViewResolvers (ViewResolverRegistry registry) {
        registry.freeMarker();
    }

    // for working with FreeMarker
    // https://freemarker.apache.org/docs/pgui_quickstart.html
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/views/");
        return configurer;
    }

    /**
     * for view extension *.flt
     * @return model (extensia) for the rendered file
     */
    @Bean
    public ViewResolver freeMarkerViewResolver () {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setSuffix(".ftl");
        return resolver;
    }

    //setup the fix resource for WEB (CSS, JS, Images etc.)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }
}
