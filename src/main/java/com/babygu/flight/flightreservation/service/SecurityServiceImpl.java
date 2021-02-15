package com.babygu.flight.flightreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Qualifier("userDetailServiceImpl")
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public boolean login(String userName, String password) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,password,
                    userDetails.getAuthorities());
            authenticationManager.authenticate(token);
            boolean authenticated = token.isAuthenticated();
            if(authenticated){
                SecurityContextHolder.getContext().setAuthentication(token);
            }
            return authenticated;

        }catch (Exception e){
            return false;
        }
    }
}
