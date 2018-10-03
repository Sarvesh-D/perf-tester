package com.ds.sample.perf.tester;

import java.time.Duration;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class PerfTesterApplicationTests {

    private static int LOAD_DURATION = 300;

    @Test
    public void perfTest() {
        WebClient.RequestBodySpec request = WebClient.create("http://localhost:9095/user/bulk")
                                                     .method(HttpMethod.POST);

        Counter counter = Counter.builder("reqeusts")
                                 .register(new SimpleMeterRegistry());
        Flux.fromStream(Stream.generate(User::random))
            .take(Duration.ofSeconds(LOAD_DURATION))
            .buffer(10)
            .map(request::syncBody)
            .parallel()
            .subscribe(req -> {
                req.exchange()
                   .block(Duration.ofSeconds(1));
                counter.increment();
            });
        System.out.println("Requests = " + counter.count());
        System.out.println("Throughput =  " + counter.count() / LOAD_DURATION + " req/s");
    }

}
