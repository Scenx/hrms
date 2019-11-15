package com.scen.boot.hrms.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * 自定义json工具类
 */
public class JsonUtils {
    
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     *
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String objectToJson4e(Object data) throws JsonProcessingException {
        String string = MAPPER.writeValueAsString(data);
        return string;
    }
    
    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     *
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static <T> List<T> jsonToList4e(String jsonData, Class<T> beanType) throws IOException {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        List<T> list = MAPPER.readValue(jsonData, javaType);
        return list;
    }
    
    /**
     * 将Object对象转换成POJO
     * 当从Map<String, Object>中取出对象时，需要通过此方法获取POJO
     *
     * @param data
     * @param beanType
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T objectToPojo(Object data, Class<T> beanType) {
        return jsonToPojo(objectToJson(data), beanType);
    }
    
    
    /**
     * 把object对象转换成带有泛型的list集合
     *
     * @param data
     * @param beanType
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> List<T> objectToList(Object data, Class<T> beanType) {
        return jsonToList(objectToJson(data), beanType);
    }
    
    public static <T> List<T> objectToList4e(Object data, Class<T> beanType) throws IOException {
        return jsonToList4e(objectToJson4e(data), beanType);
    }
}
