package br.com.joaofellipe.todolist;

import java.io.IOException;
import java.util.Base64;

import at.favre.lib.crypto.bcrypt.BCrypt;
import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        var servletPath = request.getServletPath();
        if (servletPath.equals("/tasks/")) {
            var authorization = request.getHeader("Authorization");

            var user_password = authorization.substring("Basic".length()).trim();

            byte[] authDecode = Base64.getDecoder().decode(user_password);

            var authString = new String(authDecode);

            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            var user = this.userRepository.findByUsername(username);

            if (user == null) {
                response.sendError(401);
            } else {
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if (passwordVerify.verified) {
                    request.setAttribute("idUser", user.getId());
                    chain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }

            }
        }else{
            chain.doFilter(request, response);
        }
    }
}