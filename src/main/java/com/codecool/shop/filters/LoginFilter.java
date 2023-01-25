package com.codecool.shop.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = "/account/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(true);

        Object isLogged = session.getAttribute("isLogged");

        if(Objects.isNull(isLogged) || !(boolean)isLogged) {
            ((HttpServletResponse) response).sendRedirect(request.getServletContext().getContextPath() + "/login");
            //((HttpServletResponse) response).sendError(401, "Musisz sie zalogowac chłopei!");
            return;
        }

        chain.doFilter(request, response);
    }
}
