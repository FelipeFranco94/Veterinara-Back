package com.veterinaria.veterinariaback.util;

import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtil {

	private SecurityUtil() {
	}

	public static String getUser() {
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return currentUser.getUsername();
		}
		return "";
	}

	public static String getEmail() {
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			JWTClaimsSet claims  = (JWTClaimsSet) SecurityContextHolder.getContext().getAuthentication().getCredentials();
			return claims != null && claims.getClaims()!= null && claims.getClaims().containsKey("email")? (String) claims.getClaims().get("email") :"";
		}
		return "";
	}

	public static void injectUser(Auditoria auditoria) {
		auditoria.setCdusuario(getUser());
	}

}
