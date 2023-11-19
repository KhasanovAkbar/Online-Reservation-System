package flazetech.onlinereservationsys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    //


   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/auth/**").permitAll() // Allow public access
                .anyRequest().authenticated().and().formLogin().loginPage("/login") // Customize login page URL
                .defaultSuccessUrl("/dashboard") // Redirect after successful login
                .permitAll().and().logout().logoutUrl("/logout") // Customize logout URL
                .logoutSuccessUrl("/login?logout") // Redirect after logout
                .permitAll();
    }*/
  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/auth/register").permitAll() // Allow access without authentication
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }*/

    /* @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
     }

     @Bean
     public AuthenticationManager authenticationManagerBean() throws Exception {
         return super.authenticationManagerBean();
     }
 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
