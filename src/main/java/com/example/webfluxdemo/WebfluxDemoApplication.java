package com.example.webfluxdemo;

import com.example.webfluxdemo.client.TweetWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
//@EnableReactiveMongoRepositories
public class WebfluxDemoApplication {

	public static void main(String[] args) throws InterruptedException
	{
		SpringApplication.run(WebfluxDemoApplication.class, args);
		TweetWebClient client = new TweetWebClient();
		client.main(10000);
	}
}
