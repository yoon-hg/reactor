package com.example.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxTestUsingStepVerifier {

    @Test
    void testFlux1() {
        //create-제어되지 않는 환경에서 새 StepVerifier를 준비합니다. 스텝. 그러면 실시간으로 차단됩니다.각 확인()은 시나리오를 완전히 재생합니다.
        //expectNext - 수신된 다음 요소가 지정된 값과 동일할 것으로 예상합니다.
        //verfy Complete - 완료 신호를 터미널 이벤트로 예상하여 확인을 트리거합니다.
        Flux<String> flux= Flux.just("Spring MVC","Spring Boot","Spring Web");
        StepVerifier.create(flux.log()).expectNext("Spring MVC")
                .expectNext("Spring Boot").expectNext("Spring Web")
                .verifyComplete();
    }
    @Test
    void testFlux2() {
        //expectNextCount-Expect 이전 기대치 또는 구독에서 시작하여 수신된 카운트 요소를 예상합니다.
        Flux<String> flux= Flux.just("Spring MVC","Spring Boot","Spring Web");
        StepVerifier.create(flux.log()).expectNextCount(3)
                .verifyComplete();
    }
    @Test
    void testFlux3() {
        //expectError - 지정된 유형의 오류가 필요합니다.
        //확인 - 이 가입자가 수신한 신호를 확인합니다.
        Flux<String> flux= Flux.just("Spring MVC","Spring Boot","Spring Web")
                .concatWith(Flux.error(new RuntimeException("Exception Occurred")));
        StepVerifier.create(flux.log())
                .expectNext("Spring MVC")
                .expectNext("Spring Boot")
                .expectNext("Spring Web")
                .expectError(RuntimeException.class)
                .verify();
    }
}
