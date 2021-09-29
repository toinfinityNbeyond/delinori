package com.noriteo.delinori.security.config;

import com.noriteo.delinori.security.handler.CustomAccessDeniedHandler;
import com.noriteo.delinori.security.handler.CustomAuthenticationEntryPoint;
import com.noriteo.delinori.security.handler.CustomLoginSuccessHandler;
import com.noriteo.delinori.security.service.CustomUserDetailsService;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Log4j2
@MapperScan(basePackages = "com.noriteo.delinori.security.mapper")
@ComponentScan(basePackages = "com.noriteo.delinori.security.service")
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests()
//                .antMatchers("/notice/doNori").permitAll()
//                .antMatchers("/notice/doDeli").access("hasRole('ROLE_DELI')")
//                .antMatchers("/notice/doAdmin").access("hasRole('ROLE_ADMIN')");

//        log.info("--------security config---------------");
//        log.info("--------security config---------------");
//        log.info("--------security config---------------");
//        log.info("--------security config---------------");
//        log.info("--------security config---------------");
//        log.info("--------security config---------------");
//        log.info("--------security config---------------");


        //http.formLogin();

        http.formLogin().loginPage("/customLogin").loginProcessingUrl("/login");


        //http.logout().invalidateHttpSession(true);// 디폴드 값이라 주지 않아도 작동

        http.csrf().disable(); //시큐리티 설정에 csrf를 사용하지 않겠다.

        http.rememberMe().tokenRepository(persistentTokenRepository())
                .key("zerock").tokenValiditySeconds(60*60*24*30);

//        http.exceptionHandling()
//                .authenticationEntryPoint(customAuthenticationEntryPoint());


    }



//    @Bean
//    public CustomAccessDeniedHandler customAccessDeniedHandler(){
//        return new CustomAccessDeniedHandler();
//    }


//    @Bean
//    public CustomAuthenticationEntryPoint customAuthenticationEntryPoint(){  //빈으로 등록
//        return new CustomAuthenticationEntryPoint();
//    }


    @Bean //빈으로 등록
    public CustomLoginSuccessHandler customLoginSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(customUserDetailsService);

//        auth.inMemoryAuthentication().withUser("deli1").password("$2a$10$aPY61JHKza0jGC9jl4oTfu3nzFPvwQIbC8j5T9zDKSiCSSUFVHmMC")
//                .roles("DELI");
//        auth.inMemoryAuthentication().withUser("admin1").password("$2a$10$aPY61JHKza0jGC9jl4oTfu3nzFPvwQIbC8j5T9zDKSiCSSUFVHmMC")
//                .roles("ADMIN");
    }

        @Bean
        public PersistentTokenRepository persistentTokenRepository(){
            JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
            repository.setDataSource(dataSource);
            return repository;

        }

    }




