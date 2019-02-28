package net.huadong.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具类
 * Created by ws on 2016/8/30.
 */

public class CommonUtils<T> extends PropertyNamingStrategy {
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * pojo对象转json字符串
     *
     * @param o pojo对象
     * @return
     */
    public static String objectToJson(Object o) {

        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * json字符串转换成指定对象
     *
     * @param json json字符串
     * @param c    类类型
     * @return
     */
    public static Object jsonToObject(String json, Class c) {
        try {
            if (null != json && !json.equals("")) {
                return mapper.readValue(json, c);
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * json字符串转换成指定对象LIST
     *
     * @param json json字符串
     * @param c    类类型
     * @return
     */
    public static <T> List<T> jsonToObjectList(String json, Class c) {
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, c);
            return (List<T>) mapper.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
       /* KafkaOrderMessage om = new KafkaOrderMessage();
        om.setHead("hed");
        om.setOrder("order");
        om.setContent("select * from qwer");

        String value1 = CommonUtils.objectToJson(om);

        System.out.println(value1);


        KafkaOrderMessage a = (KafkaOrderMessage) CommonUtils.jsonToObject(value1, KafkaOrderMessage.class);

        System.out.println(a.getContent());

        KafkaResultMessage rm = new KafkaResultMessage();
        rm.setHead("result");
        Map<String,String> map = new HashMap<>();
        map.put("111","222");
        map.put("333","444");
        map.put("555","666");
        map.put("777","888");
        map.put("999","000");
        rm.setResult(map);

        String value2 = CommonUtils.objectToJson(rm);

        System.out.println(value2);

        KafkaResultMessage b = (KafkaResultMessage)CommonUtils.jsonToObject(value2, KafkaResultMessage.class);

        System.out.println(b.getResult().get("333"));*/
    }

}
