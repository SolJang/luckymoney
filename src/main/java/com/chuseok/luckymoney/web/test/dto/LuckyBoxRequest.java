package com.chuseok.luckymoney.web.test.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

@Getter
@Setter
@ToString
public class LuckyBoxRequest {
    String boxMasterEmail;
    String nickname;
    String boxColor;


    public boolean essentialCheck(){
        if( StringUtils.isEmpty(boxMasterEmail) ||
                StringUtils.isEmpty(nickname) ||
                StringUtils.isEmpty(boxColor)) {
            return false;
        }
        return true;
    }
}
