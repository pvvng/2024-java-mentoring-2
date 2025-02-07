package com.lotto.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int getPurchaseAmount(){
        return scanner.nextInt();
    }

}
