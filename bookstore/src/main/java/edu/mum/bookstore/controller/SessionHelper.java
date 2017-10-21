package edu.mum.bookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import edu.mum.bookstore.domain.User;
import edu.mum.bookstore.service.UserService;

@Component
public class SessionHelper {
	
	public static final String USER_KEY="user";

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	public User getLoginUser() {
		User u = (User)session.getAttribute(USER_KEY);
		if(null == u) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails ud = (UserDetails)auth.getPrincipal();
			u = userService.findByUsername(ud.getUsername());
			session.setAttribute(USER_KEY, u);
			u = (User)session.getAttribute(USER_KEY);
		}
		return u;
	}
	
	public User reloadLoginUser() {
		User u = (User)session.getAttribute(USER_KEY);
		if(null != u) {
			u = userService.findOne(u.getId()) ;
			session.setAttribute(USER_KEY, u);
			u = (User)session.getAttribute(USER_KEY);
		}
		return u;
	}
}
