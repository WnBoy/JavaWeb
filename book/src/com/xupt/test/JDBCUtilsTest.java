package com.xupt.test;

import com.xupt.utils.JDBCUtils;
import org.junit.Test;

/**
 * @author Wnlife
 * @create 2020-03-16 18:28
 */
public class JDBCUtilsTest {
    @Test
    public void test1(){
        System.out.println(JDBCUtils.getConnection());
    }
}
