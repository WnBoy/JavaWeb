package com.xupt.filter;

import com.xupt.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-04-01 17:05
 */
public class TransactionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(req, resp);
            JDBCUtils.closeAndCommit();//关闭提交事务
        } catch (Exception e) {
            JDBCUtils.closeAndRollback();//关闭回滚事务
            e.printStackTrace();
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
