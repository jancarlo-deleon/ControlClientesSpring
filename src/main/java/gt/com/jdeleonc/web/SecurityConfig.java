package gt.com.jdeleonc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Jan Carlo
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

   
    @Autowired
    private UserDetailsService userDetailsService;
    
    
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/editar/**", "/agregar/**", "/eliminar")
                .hasRole("ADMIN")
                .requestMatchers("/").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .exceptionHandling(ex -> ex.accessDeniedPage("/errores/403"));

        return http.build();

//            
    }
}
