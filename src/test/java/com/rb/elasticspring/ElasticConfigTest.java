package com.rb.elasticspring;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.rb.elasticspring.model.Movie;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ElasticConfigTest {

    final String serverUrl = "https://localhost:9200";

    @Disabled
    @Test
    public void testClient() throws Exception {
        var esClient = getClient();

        Query query = new Query.Builder()
                .match(new MatchQuery.Builder()
                        .field("_id")
                        .query("mv_001")
                        .build())
                .build();

        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("movies")
                .query(query)
                .build();

//        var res = esClient.search(searchRequest, Movie.class);
//        System.out.println(res);
    }

    private ElasticsearchClient getClient(){
        RestClient restClient = RestClient
                .builder(HttpHost.create(serverUrl))
                .setDefaultHeaders(new Header[]{new BasicHeader("Authorization", "ApiKey ")})
                .build();

        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        return new ElasticsearchClient(transport);
    }


}
