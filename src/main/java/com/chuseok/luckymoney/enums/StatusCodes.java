package com.chuseok.luckymoney.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.Nullable;

@ToString
@AllArgsConstructor
public enum StatusCodes {
    SUCCESS(0, "SUCCESS"),
    NOT_FOUNT(404, "요청 자원을 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "서버 에러"),
    VALIDATION_ERROR(9999, "서버 에러");

    private final int code;
    @Getter private final String message;

    public static StatusCodes valueOf (int code) {
        StatusCodes status = resolve(code);
        if( status == null ){
//            throw new IllegalAccessException("No matching constant for [" + code + "]");
            return null;
        } else {
            return status;
        }
    }

    @Nullable
    public static StatusCodes resolve(int code) {
        StatusCodes[] var = values();

        for (int i = 0; i < var.length; ++i ){
            StatusCodes status = var[i];
            if (status.code == code) {
                return status;
            }
        }
        return null;
    }

    public int getCode() {
        return this.code;
    }

    public String getEnumName() {
        return name();
    }

    public Boolean equalsCode(String code) {
        return this.code == Integer.parseInt(code);
    }
}
