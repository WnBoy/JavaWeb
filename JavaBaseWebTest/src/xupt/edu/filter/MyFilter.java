package xupt.edu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-04-01 10:10
 */
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        Object user = request.getSession().getAttribute("user");
        if(user==null){
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
