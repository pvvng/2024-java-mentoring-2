package com.lotto.common;

public enum ErrorMessage {

    NAN_ERROR("입력된 값이 숫자가 아닙니다."),
    NOT_INTEGER_ERROR("입력된 값이 정수가 아닙니다."),
    MIN_PRICE_ERROR("로또를 구매하기 위한 최소 금액은 1000원입니다."),
    INVALID_LOTTO_NUMBER_ERROR("로또 숫자가 1~45 사이의 범위에 존재하지 않습니다."),
    INVALID_TICKET_LENGTH_ERROR("로또의 번호가 6개가 아닙니다."),
    INVALID_PRIZE_MONEY_PLACE_ERROR("허용된 등수 인덱스 범위가 아닙니다. (허용된 인덱스 범위 : 0~4)");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
