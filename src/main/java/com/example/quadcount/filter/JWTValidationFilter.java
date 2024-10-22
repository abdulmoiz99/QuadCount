package com.example.quadcount.filter;

import com.example.quadcount.model.User;
import com.example.quadcount.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JWTValidationFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }else{
            String token = header.replace("Bearer ", "");
            if(jwtTokenUtil.validateToken(token)){
                Claims claims = jwtTokenUtil.getClaimsFromToken(token);
                String subject = claims.getSubject();  // id,email,role
                String[] subArr = subject.split(",");
                User u = new User();
                u.setId(Long.parseLong(subArr[0]));
                u.setEmail(subArr[1]);
                u.setRole(subArr[2]);

                //set securityContext
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken usernamePasswordToken = new UsernamePasswordAuthenticationToken(u, null, u.getAuthorities());
                context.setAuthentication(usernamePasswordToken);

                SecurityContextHolder.setContext(context);
                filterChain.doFilter(request, response);
            }else{
                filterChain.doFilter(request, response);
            }
        }
    }
}
