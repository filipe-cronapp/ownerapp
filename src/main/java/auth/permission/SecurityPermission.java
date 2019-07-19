package auth.permission;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

import cronapp.framework.authentication.security.Permission;

@Component
public class SecurityPermission implements Permission {
  
    public static final String ROLE_ADMIN_NAME = "Administrators";

  public static final String ROLE_CLLIENT_NAME = "Clientes";

  @Override
  public void loadSecurityPermission(HttpSecurity http) throws Exception {

    // public
  	http.authorizeRequests().antMatchers("/api/cronapi/**").permitAll();
  	http.authorizeRequests().antMatchers("/auth/**").permitAll();
  	http.authorizeRequests().antMatchers("/components/**").permitAll();
  	http.authorizeRequests().antMatchers("/css/**").permitAll();
  	http.authorizeRequests().antMatchers("/device/**").permitAll();
  	http.authorizeRequests().antMatchers("/favicon.ico").permitAll();
  	http.authorizeRequests().antMatchers("/i18n/**").permitAll();
  	http.authorizeRequests().antMatchers("/img/**").permitAll();
  	http.authorizeRequests().antMatchers("/index.html").permitAll();
  	http.authorizeRequests().antMatchers("/js/**").permitAll();
  	http.authorizeRequests().antMatchers("/lib/**").permitAll();
  	http.authorizeRequests().antMatchers("/plugins/**").permitAll();
  	http.authorizeRequests().antMatchers("/public/**").permitAll();
  	http.authorizeRequests().antMatchers("/signin/**").permitAll();
  	http.authorizeRequests().antMatchers("/views/error/**").permitAll();
  	http.authorizeRequests().antMatchers("/views/login.view.html").permitAll();
  	http.authorizeRequests().antMatchers("/views/public/**").permitAll();
  
  	// role hasAuthority permission
  	http.authorizeRequests().antMatchers("/api/security/**").hasAuthority(ROLE_ADMIN_NAME);
  	http.authorizeRequests().antMatchers("/views/admin/**").hasAuthority(ROLE_ADMIN_NAME);
  
  	// autenticated
  	http.authorizeRequests().antMatchers("/api/rest/**").authenticated();
  	http.authorizeRequests().antMatchers("/views/logged/**").authenticated();
  	http.authorizeRequests().antMatchers("POST", "/changePassword").authenticated();
  	http.authorizeRequests().antMatchers("POST", "/changeTheme").authenticated();
  
  	// deny all
  	http.authorizeRequests().antMatchers("/**").denyAll();
  }
}