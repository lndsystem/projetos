package br.com.lndsystem.liporeduce.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin@liporeduce.com.br").password("admin").roles("PESQUISAR_VINHO").and()
            .withUser("atendente@liporeduce.com.br").password("atendente").roles("CADASTRAR_VINHO", "PESQUISAR_VINHO").and()
            .withUser("medico@liporeduce.com.br").password("medico").roles("CADASTRAR_VINHO", "PESQUISAR_VINHO").and()
            .withUser("paciente@liporeduce.com.br").password("paciente").roles("CADASTRAR_VINHO", "PESQUISAR_VINHO");
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        	.antMatchers("/layout/**")
        	.antMatchers("/h2-console/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()                
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}