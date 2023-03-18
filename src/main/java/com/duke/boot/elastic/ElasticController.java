package com.duke.boot.elastic;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dengkun11
 * @date: 2023/02/10
 * @description: controller
 */
@RestController
@Slf4j
public class ElasticController {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    //http://localhost:8087/elastic/create/xiaoming_index

    @RequestMapping(value =  "elastic/create/{createIndex}")
    @ResponseBody
    public String createEsIndex(@PathVariable("createIndex") String createIndex) {
        try {
            //创建索引请求
            //CreateIndexRequest request = new CreateIndexRequest("xiaoming_index");
            CreateIndexRequest request = new CreateIndexRequest(createIndex);

            System.out.println(JSONObject.toJSONString(restHighLevelClient));

            //通过高级客户端调用相关索引客户端，并执行请求
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);

            System.out.println(createIndexResponse);

            return JSONObject.toJSONString(createIndexResponse);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("createEsIndex", e);
        }
        return null;
    }
}
