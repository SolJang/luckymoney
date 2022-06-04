package com.chuseok.luckymoney.web.test;

import com.chuseok.luckymoney.web.ApiResponse;
import com.chuseok.luckymoney.web.test.dto.TestRequest;
import com.chuseok.luckymoney.web.test.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("TestController")
public class TestController {

    private static final String URI_PREFIX = "/api/{version}";
    private static final String URI_TEST = URI_PREFIX + "/test";

    private final TestService testService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping(value = URI_TEST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse findTest(@PathVariable String version,
                                TestRequest testRequest){
        log.info("FindTest testRequest : {}", testRequest);

        String result = testService.findUserId(testRequest.getId());

        log.info("result : {}", result);

        return new ApiResponse.Builder()
                .result(result)
                .build();
    }

}
