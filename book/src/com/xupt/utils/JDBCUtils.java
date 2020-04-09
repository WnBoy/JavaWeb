package com.xupt.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Wnlife
 * @create 2020-03-16 16:39
 */
public class JDBCUtils {

    private static DruidDataSource dataSource;
    //设置ThreadLocal
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal();
    static {
        try {
            // 读取 jdbc.properties属性配置文件
            Properties properties=new Properties();
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建 数据库连接 池
            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接对象
     * @return
     */
    public static Connection getConnection(){
        Connection connection = threadLocal.get();
        if(connection==null){
            try {
                connection=dataSource.getConnection();//从数据库连接池中获取连接
                threadLocal.set(connection);// 保存到ThreadLocal 对象中，供后面的jdbc 操作使用
                connection.setAutoCommit(false);// 设置为手动管理事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 关闭连接和提交事务
     */
    public static void closeAndCommit(){
        Connection connection = threadLocal.get();
        if(connection!=null){
            try {
                connection.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove 操作，否则就会出错。（因为Tomcat 服务器底层使用了线程池技术）
        threadLocal.remove();
    }

    /**
     * 关闭连接和回滚事务
     */
    public static void closeAndRollback(){
        Connection connection = threadLocal.get();
        if(connection!=null){
            try {
                connection.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();// 关闭连接，资源资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove 操作，否则就会出错。（因为Tomcat 服务器底层使用了线程池技术）
        threadLocal.remove();
    }


    /**
     * 关闭连接对象
     * @param connection
     */
   /* public static void close(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/
}
