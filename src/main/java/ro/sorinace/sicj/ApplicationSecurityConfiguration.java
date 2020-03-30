package ro.sorinace.sicj;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Sorin  created on 3/30/2020
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/speakers/*", "/speakers", "/feedback", "/css/*", "/js/*", "/images/misc/*",
                        "/images/artwork/*","/images/speakers/*").permitAll()
                .anyRequest().authenticated()
        .and()
        .httpBasic();
    }
}
