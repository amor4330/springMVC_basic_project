package hello.springmvc.basic.requestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {
    //    @RequestMapping({"/hello-basic", "/hello-go"})    배열을 이용하여 요청 url을 2개로 할 수도 있다.
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }

    /**
     * PathVariable(경로 변수) 사용
     * 변수명이 같으면 생략 가능
     *
     * @PathVariable("userId") String userId -> @PathVariable userId
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId = {}", data);
        return "ok";
    }

//    @GetMapping("/mapping/{userId}")
//    public String mappingPath(@PathVariable String userId) {
//        log.info("mappingPath userId = {}", userId);
//        return "ok";
//    }

    /**
     * PathVariable 다중 매핑
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappringPath(@PathVariable String userId, @PathVariable String orderId) {
        log.info("mappingPath userId = {}", userId);
        log.info("mappingPath orderId = {}", orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑 (url 요청에 쿼리파라미터 조건을 걸 수 있다)
     * 다만 이 것보다는 경로변수를 많이 사용
     * params = "mode" //mode라는 쿼리파라미터가 있어야 url 매핑
     * params = "!mode" //mode라는 쿼리파라미터가 없어야 url 매핑
     * params = "mode=debug" //mode=debug 라는 쿼리파라미터가 있어야 url 매핑
     * params = "mode!=debug" //mode!=debug 라는 쿼리파라미터가 있어야 url 매핑
     * params = {"mode=debug", "data=good} //mode=debug || data=good 쿼리파라미터 필요
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappringParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode"
     * headers="!mode"
     * headers="mode=debug"
     * headers="!mode=debug"
     */
    @GetMapping(value = "/mapping-header", params = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/**"
     * MediaType.APPLICATION_JSON_VALUE
     * consumes: 요청데이터 타입
     * produces: 리턴데이터 타입
     */
//    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProducs");
        return "ok";
    }
}
