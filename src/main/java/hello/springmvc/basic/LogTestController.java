package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    //Slf4j 애노테이션을 적용하면 구현체를 생성하지 않아도 로그를 사용할 수 있다.
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

//        System.out.println("name = " + name);
//        log.trace(" trace log=" + name); 이건 문자열 더하기를 하기 때문에 trace 로그를 출력하지 않아도 연산이 이루어진다. == 자원 낭비
        log.trace(" trace log={},", name);
        log.debug(" debug log={},", name);
        log.info(" info log={},", name);
        log.warn(" warn log={},", name);
        log.error(" error log={},", name);

        return "ok";
    }
}
