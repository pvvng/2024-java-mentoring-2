import com.lotto.domain.LottoNumber;
import com.lotto.domain.Money;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestLotto {

    @Test
    public void testMoney() {
        // given
        int value = 12333;
        int expected = 12;

        // when
        Money money = new Money(value);
        int result = money.getLottoTicketAmount();

        // then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMoneyError() {
        // given
        int value = 999;
        String errorMessage = "로또를 구매하기 위한 최소 금액은 1000원입니다.";

        // when & then
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            new Money(value);
        });

        Assertions.assertEquals(errorMessage, thrown.getMessage());
    }

    @Test
    public void testLottoNumberError() {
        // given
        int value = 46;
        String errorMessage = "로또 숫자가 1~45 사이의 범위에 존재하지 않습니다.";

        // when & then
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            new LottoNumber(value);
        });

        Assertions.assertEquals(errorMessage, thrown.getMessage());
    }

}
