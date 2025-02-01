import com.lotto.domain.IntegerParser;

import com.lotto.domain.LottoDomain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestLotto {
    @Test
    public void testLottoTicketCountCalculator() {
        // given
        int value = 1230;
        int expected = 1;

        // when
        LottoDomain lottoDomain = new LottoDomain();
        int result = lottoDomain.calculateLottoTicketCount(value);

        // then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMinimumPriceError(){
        // given
        int value = 999;
        String errorMessage = "로또를 구매하기 위한 최소 금액은 1000원입니다.";

        // when
        LottoDomain lottoDomain = new LottoDomain();
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class,
                () -> lottoDomain.isUnderMinimumLottoPrice(value)
        );
        // then
        Assertions.assertEquals(errorMessage, thrown.getMessage());
    }

    @Test
    public void parseIntTest() {

        //given
        String strNumber = "14500";
        int expected = 14500;

        //when
        IntegerParser integerParser = new IntegerParser();

        int result = integerParser.parseInteger(strNumber);

        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void parseStringNaNTest() {

        //given
        String strNumber = "ㅋㅋㅋㅋㅋㅋㅋㅋ";
        String expectedErrorMessage = "입력된 값이 숫자가 아닙니다.";

        //when
        IntegerParser integerParser = new IntegerParser();

        //then
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class,
                () -> integerParser.parseInteger(strNumber)
        );

        Assertions.assertEquals(expectedErrorMessage, thrown.getMessage());
    }
}
