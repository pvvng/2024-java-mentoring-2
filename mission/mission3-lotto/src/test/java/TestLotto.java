import com.lotto.domain.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Stream;

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
    public void ticketSizeTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5)
                .map(LottoNumber::new)
                .toList();
        String errorMessage = "로또의 번호가 6개가 아닙니다.";

        // when & then
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> new WinnerTicket(lottoNumbers));

        Assertions.assertEquals(errorMessage, thrown.getMessage());
    }

    @Test
    public void splitTest() {
        // given
        String str = "1, 2,  3, 4,   5,6";
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .toList();
        WinnerTicket ticket = new WinnerTicket(lottoNumbers);
        int expected = ticket.getNumber(2);

        // when
        WinnerTicketGenerator generator = new WinnerTicketGenerator();
        WinnerTicket resultTicket = generator.getWinnerTicket(str);
        int result = resultTicket.getNumber(2);

        // then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void splitErrorTest() {
        // given
        String str = "1, string, 3";
        String errorMessage = "입력된 값이 숫자가 아닙니다.";

        // when & then
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> new WinnerTicketGenerator().getWinnerTicket(str));

        Assertions.assertEquals(errorMessage, thrown.getMessage());
    }

}
