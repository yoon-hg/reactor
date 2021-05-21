package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class TestFlux {

    @Test
    void testPrint(){
        System.out.println("hello");
    }


    @Test
    void testFlux1() {
        //어떤 항목도 내보내지 않고 완료되는 Flux를 만듭니다.
        Flux<String> flux = Flux.empty();
        flux.subscribe(System.out::println);
    }
    @Test
    void testFlux2() {
        //단일 요소만 방출한 다음 Complete에서 방출하는 새 Flux를 만듭니다.
        Flux<String> flux= Flux.just("Spring 5");
        flux.subscribe(System.out::println);
    }
    @Test
    void testFlux3() {
        //Create a Flux that emits the provided elements and then completes.
        Flux<String> flux= Flux.just("Spring MVC","Spring Boot","Spring Web");
        flux.subscribe(System.out::println);
    }
    @Test
    void testFlux4() {
        //제공된 요소를 방출한 후 완료되는 Flux를 생성합니다.
        Flux<String> flux = Flux.fromArray(new String[]{"A", "B", "C"});
        flux.subscribe(System.out::println);
    }
    @Test
    void testFlux5() {
        //제공된 Itable에 포함된 항목을 방출하는 Flux를 생성합니다.각 가입자에 대해 새 반복자가 생성됩니다.
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Flux<Integer> flux=Flux.fromIterable(list);
        flux.subscribe(System.out::println);
    }
    @Test
    void testFlux6() {
        // 제공된 게시자와 이 Flux의 배출물을 연결합니다(인터리브 없음).
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Flux<Integer> flux=Flux.fromIterable(list)
                .concatWith(Flux.just(6,7,8));
        flux.subscribe(System.out::println);
    }
    @Test
    void testFlux7() {
        //가입 후 즉시 지정된 오류와 함께 종료되는 Flux를 생성합니다.
        Flux<String> flux= Flux.error(new RuntimeException("Error Occurred"));
        flux.subscribe(System.out::println);
    }
}
