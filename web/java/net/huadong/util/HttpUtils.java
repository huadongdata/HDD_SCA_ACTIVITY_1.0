package net.huadong.util;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaohongwei on 2017/9/16.
 */
public class HttpUtils {

    private static String address = "http://localhost:8080/";

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private Logger logger = LoggerFactory.getLogger(getClass());


    private static OkHttpClient client = new OkHttpClient();

    /**
     * post请求public class CommonUtils<T> extends PropertyNamingStrategy {

     *
     * @param url
     * @param bodyParams
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String, String> bodyParams) {
        String jsonParams = CommonUtils.objectToJson(bodyParams);
        //构造RequestBody
        RequestBody body = RequestBody.create(JSON, jsonParams);
        Request request = new Request.Builder()
                .url(address + url)
                .post(body)
                .build();
        Response response = null;

        try {
            //设置等待时间
            client = new OkHttpClient.Builder()
                    .connectTimeout(20 * 1000, TimeUnit.SECONDS)
                    .writeTimeout(20 * 1000, TimeUnit.SECONDS)
                    .readTimeout(20 * 1000, TimeUnit.SECONDS)
                    .build();

            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            HttpUtils ht = new HttpUtils();
            ht.logger.info(e.toString());
            return null;
        }
    }

    /**
     * get请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url) {
        Request request = new Request.Builder()
                .url(address + url)
                .build();

        Response response = null;
        try {
            //设置等待时间
            client = new OkHttpClient.Builder()
                    .connectTimeout(20 * 1000, TimeUnit.SECONDS)
                    .writeTimeout(20 * 1000, TimeUnit.SECONDS)
                    .readTimeout(20 * 1000, TimeUnit.SECONDS)
                    .build();

            response = client.newCall(request).execute();
            return response.body().string();

        } catch (IOException e) {
            HttpUtils ht = new HttpUtils();
            ht.logger.info(e.toString());
            return null;
        }
    }

    /**
     * post的请求参数，构造RequestBody
     *
     * @param BodyParams
     * @return
     */
    private static RequestBody setRequestBody(Map<String, String> BodyParams) {
        RequestBody body = null;
        okhttp3.FormBody.Builder formEncodingBuilder = new okhttp3.FormBody.Builder();
        if (BodyParams != null) {
            Iterator<String> iterator = BodyParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                formEncodingBuilder.add(key, BodyParams.get(key));
//                Log.d("post http", "post_Params==="+key+"===="+BodyParams.get(key));
            }
        }
        body = formEncodingBuilder.build();


        return body;

    }
}
