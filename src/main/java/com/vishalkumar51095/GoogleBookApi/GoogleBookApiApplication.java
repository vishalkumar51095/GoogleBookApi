package com.vishalkumar51095.GoogleBookApi;

import com.google.gson.Gson;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

@SpringBootApplication
public class GoogleBookApiApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(GoogleBookApiApplication.class, args);
       // var url = "https://www.googleapis.com/books/v1/volumes?q=author:champak+Roy&key=AIzaSyCAsRzcbIw3FfXo0oEr3NIlqSzk33W81bU";
        var url="https://www.googleapis.com/books/v1/volumes?q=author:champak+Roy&key=AIzaSyCAsRzcbIw3FfXo0oEr3NIlqSzk33W81bU";
        //httprequest
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        var client = HttpClient.newBuilder().build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        String codebody = "" + response.body();
        System.out.println(codebody);
        Gson gson = new Gson();
        CR cr = gson.fromJson(codebody, CR.class);
        System.out.println(cr);
		/*
        cr=new CR();
		cr.items=new Object[]{"Lanka"};
		cr.kind="Danav";
		cr.totalItems="100";
		String jsonwa= gson.toJson(cr);
		System.out.println(jsonwa);
*/

    }

}

class SubCR {
    String kind, id, etag, selflink;

    @Override
    public String toString() {
        return "SubCR{" +
                "kind='" + kind + '\'' +
                ", id='" + id + '\'' +
                ", etag='" + etag + '\'' +
                ", selflink='" + selflink + '\'' +
                '}';
    }
}

class CR {
    String kind, totalItems;
    Object[] items;

    @Override
    public String toString() {
        return "CR{" +
                "kind='" + kind + '\'' +
                ", totalItems='" + totalItems + '\'' +
                ", items=" + Arrays.toString(items) +
                '}';

    }


}

