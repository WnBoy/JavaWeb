package xupt.edu.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Wnlife
 * @create 2020-04-02 15:34
 */
public class I18nTest {

    @Test
    public void test1(){
        //获取默认系统默认的语言
//        Locale locale= Locale.getDefault();
//        System.out.println(locale);

        //获取所有的语言
//        for (Locale locale : Locale.getAvailableLocales()) {
//            System.out.println(locale);
//        }

        System.out.println(Locale.CHINA);
        System.out.println(Locale.US);

    }

    @Test
    public void test2(){
        ResourceBundle bundle=ResourceBundle.getBundle("i18n",Locale.US);
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        String age = bundle.getString("age");
        String sex = bundle.getString("sex");

        System.out.println("username= "+username+" password="+password+" age="+age+" sex="+sex);
    }

}
