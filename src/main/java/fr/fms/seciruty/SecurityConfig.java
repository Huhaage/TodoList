//package fr.fms.seciruty;
//
//import javax.sql.DataSource;
//
//import org.hibernate.sql.Select;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.fasterxml.jackson.core.sym.Name;
//
//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    DataSource dataSource;
//    
//    @Beanxl
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	PasswordEncoder pe = passwordEncoder();
//    	auth.jdbcAuthentication()
//    		.dataSource(dataSource)
//    		.usersByUsernameQuery("select username as principal, password as credentials, active form T_Users where username=?")
//    		.authoritiesByUsernameQuery("select username as pricipal, role as role from T_Users8Roles where username=?")
//    		.rolePrefix("ROLE_")
//    		.passwordEncoder(passwordEncoder());
////    	auth.inMemoryAuthentication().withUser("Nathan").password(pe.encode("12345")).roles("USER");
////    	auth.inMemoryAuthentication().withUser("Louis").password(pe.encode("12345")).roles("USER");
////    	auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
//    }
//    
//    @Bean
//    PasswordEncoder passwordEncoder() {
//    	return new BCryptPasswordEncoder();
//    }
//    
//    @Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    	http.formLogin().loginPage("/login");
//    	http.authorizeRequests().antMatchers("/confirm").hasRole("USER");
//    	http.exceptionHandling().accessDeniedPage("/403");
//    	return http.build();
//    }
//}
