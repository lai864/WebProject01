package com.hello_world.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean){
        /*获取所有请求参数，将键值对注入object对象，使用Map*/
        try {
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    //String转int类型数值
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return defaultValue;
    }
}
