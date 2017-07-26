package elasticsearchdemo;


import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;

public class Test {

    public static void main(String[] args) throws IOException {
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();

        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));


//        initElasticData(client);

        SearchResponse searchResponse = executeSearch(client);

        SearchHit[] searchHits = searchResponse.getHits().getHits();

        for (SearchHit searchHit : searchHits) {
            System.out.println(searchHit.getSource());
        }

        client.close();

    }

    private static SearchResponse executeSearch(Client client) {
        return client.prepareSearch("company")
                .setQuery(QueryBuilders.matchQuery("name", "jack")).get();
    }

    public static void initElasticData(Client client) throws IOException {
        client.prepareIndex("company", "employee", "1")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "jack")
                        .field("age", "20")
                        .endObject()
                ).get();
    }


}
