package xupt.edu.utils;

import javax.servlet.http.Cookie;

/**
 * @author Wnlife
 * @create 2020-03-27 20:42
 */
public class CookieUtils {

    public static Cookie findCookie(String name,Cookie[]cookies){
        if(name==null||cookies==null||cookies.length==0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
