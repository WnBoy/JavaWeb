package com.xupt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-04-01 13:50
 */
public class ManagerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) req;
        Object user = httpServletRequest.getSession().getAttribute("user");
        if(user==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
