package com.lotto.domain;

public enum ErrorMessage {
    NAN_ERROR("입력된 값이 숫자가 아닙니다."),
    NOT_INTEGER_ERROR("입력된 값이 정수가 아닙니다."),
    MIN_PRICE_ERROR("로또를 구매하기 위한 최소 금액은 1000원입니다."),
    INVALID_LOTTO_NUMBER_COUNT_ERROR("로또 번호가 6개가 아닙니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}