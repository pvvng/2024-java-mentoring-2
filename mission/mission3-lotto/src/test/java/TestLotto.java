import com.lotto.domain.*;

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
    public void ticketTest() {
        List<LottoNumber> customNumbers = List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(6), new LottoNumber(5), new LottoNumber(4)
        );

        Ticket autoTicket = Ticket.builder()
                .withRandomNumbers()
                .build();

        Ticket customTicket = Ticket.builder()
                .withNumbers(customNumbers)
                .build();

        Ticket winnerTicket = Ticket.builder()
                .withNumbers(customNumbers)
                .withBonusNumber(4)
                .build();
    }

}
