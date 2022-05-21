package com.chuseok.luckymoney.web;

import com.chuseok.luckymoney.enums.StatusCodes;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
public class ApiResponse {

    private final int status;
    private final String message;
    private final Object result;

    private ApiResponse(final StatusCodes status, final Object data) {
        this.status = status.getCode();
        this.result = data;
        this.message = status.getMessage();
    }

    public static class Builder {
        private StatusCodes status;
        private Object result;

        public Builder(){}

        public Builder result (final Object object) {
            if (!Objects.isNull(object)){
                result = object;
            }
            return this;
        }

        public Builder status (final StatusCodes status) {
            this.status = status;
            return this;
        }

        public ApiResponse build() {
            if (Objects.isNull(status)){
                return new ApiResponse(StatusCodes.SUCCESS, result);
            }
            return new ApiResponse(status, result);
        }
    }

}
