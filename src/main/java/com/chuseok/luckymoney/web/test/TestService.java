package com.chuseok.luckymoney.web.test;

import com.chuseok.luckymoney.web.test.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {
    private final TestMapper testMapper;

    @Autowired
    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public String findUserId(String data){
        return testMapper.findUserId(data);
    }


}
