package com.chuseok.luckymoney.web.test.service;

import com.chuseok.luckymoney.enums.StatusCodes;
import com.chuseok.luckymoney.web.test.dto.LuckyBoxRequest;
import com.chuseok.luckymoney.web.test.mapper.LuckyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;


@Slf4j
@Service
public class LuckyService {
    private final LuckyMapper luckyMapper;

    @Autowired
    public LuckyService(LuckyMapper luckyMapper) {
        this.luckyMapper = luckyMapper;
    }

    public void createLuckyBox(LuckyBoxRequest luckyBoxRequest) throws IllegalAccessException {
        String pattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

        // 필수데이터 체크 (이메일, 닉네임, 박스시퀀스 )
        if(!luckyBoxRequest.essentialCheck()){
            throw new IllegalAccessException(StatusCodes.ESSENTIAL_DATA_NOT_FOUND.getMessage());
        }

        if( !Pattern.matches(pattern, luckyBoxRequest.getBoxMasterEmail())){
            throw new IllegalAccessException(StatusCodes.NOT_EMAIL_FORMAT.getMessage());
        }

        log.info("luckyBoxRequest : {}", luckyBoxRequest);
        luckyMapper.createLuckyBox(luckyBoxRequest);
    }


}
