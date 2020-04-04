package xupt.edu.session;

import xupt.edu.cookie.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Wnlife
 * @create 2020-03-28 9:52
 */
public class SessionServlet extends BaseServlet {

    public void createOrGetServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建或获取session
        HttpSession session = request.getSession();
        //获取sessionID
        String id = session.getId();
        //判断session是不是为空
        boolean aNew = session.isNew();
        response.getWriter().write("获取sessionID=" + id + "  判断session是不是为空" + aNew);

    }

    public void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取Session 对象
        HttpSession session = req.getSession();
        // 设置当前Session3 秒后超时
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("当前Session 已经设置为3 秒后超时");
    }


}
