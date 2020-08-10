package org.luapp.gq.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author: 86150
 * @create: 2020/08/10
 **/
public class GreetingWebClient {

    public static void test1() {
        WebClient client = WebClient.create("http://localhost:8080");

        Mono<ClientResponse> result = client.get()
                .uri("/statuses/ok")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        String s = result.flatMap(res -> res.bodyToMono(String.class)).block();

        System.out.println(s);
    }

    public static void test2() {
        WebClient client = WebClient.create("http://localhost:8080");

        Mono<ClientResponse> result = client.get()
                .uri("/hello")
                .accept(MediaType.TEXT_PLAIN)
                .exchange();

        String s = result.flatMap(res -> res.bodyToMono(String.class)).block();

        System.out.println(s);
    }

    public static void main(String[] args) {
        test1();
    }
}
