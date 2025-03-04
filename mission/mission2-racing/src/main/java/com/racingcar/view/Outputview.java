package com.racingcar.view;

public class Outputview {

    public void showCarNameInputPrompt(){
        System.out.println("경주할 자동차 이름을 입력하세요.");
    }

    public void showTryCountInputPrompt(){
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void showWinner(String winner){
        System.out.println(winner + "가 최종 우승했습니다.");
    }

    public void showCarMove(String carName, String carMove){
        System.out.println(carName + " : " + carMove);
    }

    public void showSpace(){
        System.out.println(" ");
    }
}
