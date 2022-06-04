package com.chuseok.luckymoney.web.test.mapper;

import com.chuseok.luckymoney.web.test.dto.LuckyBoxRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LuckyMapper {

    void createLuckyBox(LuckyBoxRequest luckyBoxRequest);
}
