package com.duke.boot.elastic;

import com.jd.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author: dengkun11
 * @date: 2023/02/09
 * @description: 注入RestHighLevelClient客户端
 */
@Slf4j
@Configuration
public class ElasticSearchConfig {

    //超时时间设为5分钟
    private static final int TIME_OUT = 5 * 60 * 1000;
    private static final int ADDRESS_LENGTH = 2;
    private static final String HTTP_SCHEME = "http";

    private final int connectTimeOut = 1000; // 连接超时时间
    private final int socketTimeOut = 30000; // 连接超时时间
    private final int connectionRequestTimeOut = 500; // 获取连接的超时时间

    private final int maxConnectNum = 100; // 最大连接数
    private final int maxConnectPerRoute = 100; // 最大路由连接数


    private final String[] address = {"localhost:9200"};

    @Bean
    public RestHighLevelClient restHighLevelClient() {
//        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
//                RestClient.builder(new HttpHost("localhost", 9200, "http"))
//        );

        HttpHost[] hosts = Arrays.stream(address).map(this::makeHttpHost).filter(Objects::nonNull).toArray(HttpHost[]::new);
        log.debug("hosts:{}", Arrays.toString(hosts));
        System.out.println("hosts:{}" + Arrays.toString(hosts));

        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(hosts)
                .setRequestConfigCallback(
                        requestConfigBuider ->
                                requestConfigBuider
                                .setConnectionRequestTimeout(connectionRequestTimeOut)
                                .setSocketTimeout(socketTimeOut)
                                .setConnectionRequestTimeout(connectionRequestTimeOut))
        );

        System.out.println(JSON.toJSONString(restHighLevelClient));

        return restHighLevelClient;
    }

    /**
     * 处理请求地址
     * @param s address
     * @return HttpHost
     */
    private HttpHost makeHttpHost(String s) {
        assert !Objects.isNull(s);
        String[] address = s.split(":");
        if (address.length == ADDRESS_LENGTH) {
            String ip = address[0];
            int port = Integer.parseInt(address[1]);
            return new HttpHost(ip, port, HTTP_SCHEME);
        } else {
            return null;
        }
    }

}
