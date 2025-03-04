package com.racingcar.domain;

import com.racingcar.domain.vo.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RacingCarLogic {
    private final String CAR_NAME_SPLIT_PATTERN = ",";
    private final String JOIN_STRING = ", ";

    public String[] splitCarName(String carName) {
        return carName.split(CAR_NAME_SPLIT_PATTERN);
    }

    public Cars loopTryCount(int tryCount, Cars cars) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
        }

        return cars;
    }

    public ArrayList<String> arrayToArrayList(String[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public String buildListToString(List<String> winnerList) {
        return String.join(JOIN_STRING, winnerList);
    }

    public ArrayList<HashMap<String, String>> getCarsMovementRecord(Cars cars){
        return cars.getCarsMovementRecord();
    }
}
