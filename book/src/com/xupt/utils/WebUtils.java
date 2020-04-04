package com.xupt.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author Wnlife
 * @create 2020-03-20 18:44
 */
public class WebUtils {

    /**
     * 将map中的属性赋值到bean中
     * @param value
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T copyParameter(Map value,T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bean;
    }

    /**
     * 字符串转int数值
     * @param intStr
     * @param defaultVal
     * @return
     */
    public static int parseInt(String intStr,int defaultVal){
        try {
            return Integer.parseInt(intStr);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultVal;
    }

}
