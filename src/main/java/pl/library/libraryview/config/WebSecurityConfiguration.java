package pl.library.libraryview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**").hasAnyRole("LIBRARIAN", "READER")
                .antMatchers(HttpMethod.POST,"/**").hasRole("LIBRARIAN")
                .antMatchers(HttpMethod.DELETE).hasRole("LIBRARIAN")
                .antMatchers(HttpMethod.PUT).hasRole("LIBRARIAN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and().httpBasic()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedPage("/accessDenied")
                .and()
                .logout()
                .permitAll();

    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails reader =
                User.builder()
                        .username("reader")
                        .password(encoder.encode("reader"))
                        .roles("READER")
                        .build();
        UserDetails librarian =
                User.builder()
                        .username("librarian")
                        .password(encoder.encode("librarian"))
                        .roles("LIBRARIAN")
                        .build();
        return new InMemoryUserDetailsManager(librarian, reader);
    }

}