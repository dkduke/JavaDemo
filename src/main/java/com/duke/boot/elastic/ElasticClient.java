package com.duke.boot.elastic;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @author: dengkun11
 * @date: 2023/02/09
 * @description: 使用客户端操作索引数据
 */
public class ElasticClient {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void createESIndex() {

        try {
            //创建索引请求
            CreateIndexRequest request = new CreateIndexRequest("xiaoming_index");

            System.out.println(JSONObject.toJSONString(restHighLevelClient));

            //通过高级客户端调用相关索引客户端，并执行请求
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);

            System.out.println(createIndexResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
