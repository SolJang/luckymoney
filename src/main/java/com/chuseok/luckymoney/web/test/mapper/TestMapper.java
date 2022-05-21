package com.chuseok.luckymoney.web.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TestMapper {

    String findUserId(String data);
}
