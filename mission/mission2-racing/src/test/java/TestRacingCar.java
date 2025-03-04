import com.racingcar.domain.vo.Car;
import com.racingcar.domain.vo.IntegerParser;

import com.racingcar.domain.RacingCarLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRacingCar {
    
    @Test
    public void notIntegerErrorTest() {

        //given
        String strNumber = "1.5";

        String expectedErrorMessage = "입력된 값이 정수가 아닙니다.";

        //when
        IntegerParser integerParser = new IntegerParser();

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class,
                () -> integerParser.parseInteger(strNumber)
        );

        //then
        assertEquals(expectedErrorMessage, thrown.getMessage());
    }

    @Test
    public void minusErrorTest() {

        //given
        String strNumber = "-1";

        String expectedErrorMessage = "입력된 값이 음수입니다.";

        //when
        IntegerParser integerParser = new IntegerParser();

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class,
                () -> integerParser.parseInteger(strNumber)
        );

        //then
        assertEquals(expectedErrorMessage, thrown.getMessage());
    }

    @Test
    public void parseIntTest() {

        //given
        String strNumber = "1";

        int expected = 1;

        //when
        IntegerParser integerParser = new IntegerParser();

        int result = integerParser.parseInteger(strNumber);

        //then
        assertEquals(expected,result);
    }

    @Test
    public void parseStringNaNTest() {

        //given
        String strNumber = "ㅋㅋ루삥뽕빵빵뽕";

        String expectedErrorMessage = "입력된 값이 숫자가 아닙니다.";

        //when
        IntegerParser integerParser = new IntegerParser();

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class,
                () -> integerParser.parseInteger(strNumber)
        );

        //then
        assertEquals(expectedErrorMessage, thrown.getMessage());
    }

    @Test
    public void CarClassNameTest(){

        //given
        String carName = "test";

        //when
        Car car = new Car(carName);

        //then
        assertEquals(carName, car.getName());
    }

    @Test
    public void CarClassPositionTest(){

        //given
        String carName = "move";
        int expected = 1;

        //when
        Car car = new Car(carName);
        car.move(1);

        //then
        assertEquals(expected, car.getPosition());
    }

    @Test
    public void SplitTest(){

        //given
        String carName = "a,b,c,d";
        String[] expected = {"a", "b", "c", "d"};

        //when
        RacingCarLogic racingCarLogic = new RacingCarLogic();
        String[] result = racingCarLogic.splitCarName(carName);

        //then
        assertArrayEquals(expected, result);
    }

    @Test
    public void winnerStringTest(){

        //given
        List<String> winnerList = new ArrayList<>();
        winnerList.add("a");
        winnerList.add("b");

        String expected = "a, b";

        //when
        RacingCarLogic racingCarLogic = new RacingCarLogic();
        String result = racingCarLogic.buildListToString(winnerList);

        //then
        assertEquals(expected, result);
    }
}
