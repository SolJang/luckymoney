package com.chuseok.luckymoney.web.test;

import com.chuseok.luckymoney.enums.StatusCodes;
import com.chuseok.luckymoney.web.ApiResponse;
import com.chuseok.luckymoney.web.test.dto.LuckyBoxRequest;
import com.chuseok.luckymoney.web.test.service.LuckyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("LuckyController")
public class LuckyController {

    private static final String URI_PREFIX = "/api/{version}";
    private static final String URI_LUCKY = URI_PREFIX + "/lucky";
    private static final String URI_LUCKY_BOX_CREATE = URI_LUCKY + "/create";

    private final LuckyService luckyService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public LuckyController(LuckyService luckyService){
        this.luckyService = luckyService;
    }

    @PostMapping(value = URI_LUCKY_BOX_CREATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse createLuckyBox(@PathVariable String version,
                                LuckyBoxRequest luckyBoxRequest) throws IllegalAccessException {
        log.info("createLuckyBox luckyBoxRequest : {}", luckyBoxRequest);

        luckyService.createLuckyBox(luckyBoxRequest);


        return new ApiResponse.Builder()
                .result(StatusCodes.SUCCESS)
                .build();
    }

}
