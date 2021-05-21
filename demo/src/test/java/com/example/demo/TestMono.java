package com.example.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class TestMono {

    @Test
    public void testMono1() {
        Mono<String> mono=Mono.empty();
        mono.subscribe(System.out::println);
    }

    @Test
    public void testMono2() {
        Mono<String> mono=Mono.just("Spring");
        mono.subscribe(System.out::println);
    }

    @Test
    public void testMono3() {
        Mono<Integer> mono=Mono.just(10);
        mono.subscribe(System.out::println);
    }

    @Test
    public void testMono4() {
        Mono<String> mono=Mono.error(new RuntimeException("Exception occurred"));
        mono.subscribe(System.out::println);
    }

    @Test
    public void testMono5() {
        Mono<String> mono=Mono.just("Spring");
        StepVerifier.create(mono.log())
                .expectNext("Spring")
                .verifyComplete();
    }

    @Test
    public void testMono6() {
        Mono<String> mono=Mono.error(new RuntimeException("Exception occurred"));
        StepVerifier.create(mono.log())
                .expectError(RuntimeException.class)
                .verify();
        //Another approach
        StepVerifier.create(Mono.error(new RuntimeException("Exception")).log())
                .expectError(RuntimeException.class)
                .verify();
    }

}
