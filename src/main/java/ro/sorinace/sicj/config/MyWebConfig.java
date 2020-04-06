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

/**
 * In this class we configure server (WEB page) for the MVC model
 */
@EnableWebMvc
@Configuration
@ComponentScan
public class MyWebConfig implements WebMvcConfigurer{
    /**
     * Configure the View Render
     * @param registry the render method for the viewer, in this case FreeMarker
     */
    @Override
    public void configureViewResolvers (ViewResolverRegistry registry) {
        registry.freeMarker();
    }

    /**Setup for working with FreeMarker
     * https://freemarker.apache.org/docs/pgui_quickstart.html
     * @return the path for *.ftl file
     */
     @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/views/");
        return configurer;
    }

    /**
     * Add extension *.flt of the file mapped, in the mapping is necessary only the mane of the file
     * @return model (extension) for the rendered file
     */
    @Bean
    public ViewResolver freeMarkerViewResolver () {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setSuffix(".ftl");
        return resolver;
    }

    /**
     * setup the fix / static resource location for WEB (CSS, JS, Images etc.)
     * @param registry the path for the resource files
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }
}
