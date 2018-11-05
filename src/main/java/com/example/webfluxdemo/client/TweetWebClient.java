package com.example.webfluxdemo.client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

@Component
public class TweetWebClient
{
	private AtomicInteger integer = new AtomicInteger(0);

	public void testRESTClient() {
		WebClient client = WebClient.create("http://www.google.com"); // 1
		Mono<ClientResponse> result = client
				.get().uri("").accept(MediaType.TEXT_PLAIN).exchange();
		result.subscribe(new Consumer(){

			@Override
			public void accept(Object o)
			{
				integer.incrementAndGet();
			}
		});
	}

	public void main(int count) throws InterruptedException
	{
		long st1 = System.currentTimeMillis();
		int totalCount = count;
		while(totalCount-- > 0)
		{
			testRESTClient();
		}
		while(integer.get() < count){}
		long st2 = System.currentTimeMillis();
		System.out.println(st2-st1);
	}

}
