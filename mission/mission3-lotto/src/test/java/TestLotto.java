import com.lotto.domain.*;

import com.lotto.domain.generator.CustomLottoNumbersGenerator;
import com.lotto.domain.model.LottoNumber;
import com.lotto.domain.vo.Money;
import com.lotto.domain.model.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

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
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> new Money(value));

        Assertions.assertEquals(errorMessage, thrown.getMessage());
    }

    @Test
    public void testLottoNumberError() {
        // given
        int value = 46;
        String errorMessage = "로또 숫자가 1~45 사이의 범위에 존재하지 않습니다.";

        // when & then
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> new LottoNumber(value));

        Assertions.assertEquals(errorMessage, thrown.getMessage());
    }

    @Test
    public void testLottoPrizeCalculator() {
        // given
        int expected1 = 30000000;
        int expected2 = 1500000;
        int expected3 = 0;

        // when
        RewardVoucher voucher1 = new RewardVoucher(5, true);
        RewardVoucher voucher2 = new RewardVoucher(5, false);
        RewardVoucher voucher3 = new RewardVoucher(2, true);

        LottoPrizeCalculator calculator = new LottoPrizeCalculator();

        // then
        Assertions.assertEquals(expected1, calculator.getPrize(voucher1));
        Assertions.assertEquals(expected2, calculator.getPrize(voucher2));
        Assertions.assertEquals(expected3, calculator.getPrize(voucher3));
    }

    @Test
    public void splitStringTest() {

        // given
        String value = "1,2,3,   4,  5,6";
        List<LottoNumber> expected = List.of(new LottoNumber(1));

        // when
        List<LottoNumber> result = CustomLottoNumbersGenerator.create(value).getNumbers();

        // then
        Assertions.assertEquals(result.getFirst().lottoNumber(), expected.getFirst().lottoNumber());
    }

    @Test
    public void splitErrorTest() {
        String value = "1,2,3,,  NaN,6";
        String errorMessage = "입력된 값이 숫자가 아닙니다.";

        // when & then
        RuntimeException thrown = Assertions.assertThrows(
                RuntimeException.class,
                () -> CustomLottoNumbersGenerator.create(value).getNumbers()
        );

        Assertions.assertEquals(errorMessage, thrown.getMessage());
    }

    @Test
    public void customTicketTest() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        String expected = "[1, 2, 3, 4, 5, 6]";

        // when
        List<LottoNumber> numbers = list.stream()
                .map(LottoNumber::new)
                .toList();
        String result = Ticket.builder()
                .withNumbers(numbers)
                .build()
                .toString();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void autoTicketTest() {
        // given
        int expected = 6;

        // when
        Ticket ticket = Ticket.builder()
                .withRandomNumbers()
                .build();
        int result = ticket.getLottoNumbers().size();

        // then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void bonusTicketTest() {
        // given
        int expected = 43;

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        List<LottoNumber> numbers = list.stream()
                .map(LottoNumber::new)
                .toList();

        // when
        Ticket ticket = Ticket.builder()
                .withNumbers(numbers)
                .withBonusNumber(43)
                .build();

        int result = ticket.getBonus();

        // then
        Assertions.assertEquals(expected, result);
    }

}
