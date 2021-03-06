package br.com.aleferamos.BookStore.config;

import br.com.aleferamos.BookStore.services.AutenticacaoService;
import br.com.aleferamos.BookStore.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private AutenticacaoService autenticacaoService;
    private UsuarioService usuarioService;

    @Autowired
    public SecurityConfiguration(AutenticacaoService autenticacaoService, UsuarioService usuarioService) {
        super();
        this.autenticacaoService = autenticacaoService;
        this.usuarioService = usuarioService;
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    //configura????es de autentifica????o
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //Configura????es de autoriza????o
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/autenticacao/autenticar").permitAll().anyRequest().authenticated()
                .and()
                .cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new AutenticacaoFilter(autenticacaoService, usuarioService), UsernamePasswordAuthenticationFilter.class);
    }

    //Configura????es de recursos est??ticos
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resetPassword/**",
                        "/webjars/**",
                        "/pessoa/salvar",
                        "/autenticacao/validar",
                        "/configuration/**",
                        "/anuncio/listar",
                        "/anuncio/listarByStatus",
                        "/googlebook/**",
                        "/anuncio/buscarPorId/**",
                        "/anuncio/listarPorNomeEIntervaloDeCusto/**");
    }


}