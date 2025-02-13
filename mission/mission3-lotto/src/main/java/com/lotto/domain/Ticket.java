package com.lotto.domain;

import com.lotto.common.ErrorMessage;
import com.lotto.common.LottoConfig;
import com.lotto.common.exception.InvalidTicketLength;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ticket {

    private final List<LottoNumber> lottoNumbers;
    private final int bonus;
    private final TicketType type;

    private Ticket(Builder builder) {
        this.lottoNumbers = builder.lottoNumbers;
        this.bonus = builder.bonus;
        this.type = builder.type;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonus() {
        return bonus;
    }

    public TicketType getType() {
        return type;
    }

    public int getNumber(int index) {
        return getLottoNumbers().get(index).lottoNumber();
    }

    public boolean isNumberAt(int index, int number) {
        return getLottoNumbers().get(index).lottoNumber() == number;
    }

    @Override
    public String toString() {
        return getLottoNumbers().stream()
                .map(LottoNumber::lottoNumber)
                .toList()
                .toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<LottoNumber> lottoNumbers;
        private int bonus = 0;
        private TicketType type;

        public Builder withRandomNumbers() {
            this.lottoNumbers = createRandomLottoNumbers();
            this.type = TicketType.AUTO;

            return this;
        }

        public Builder withNumbers(List<LottoNumber> numbers) {
            this.lottoNumbers = numbers;
            this.type = TicketType.CUSTOM;

            return this;
        }

        public Builder withBonusNumber(int bonus) {
            if (type != TicketType.CUSTOM) {
                throw new UnsupportedOperationException(ErrorMessage.NOT_ALLOWED_TICKET_TYPE.getMessage());
            }

            this.type = TicketType.WINNER;
            this.bonus = bonus;

            return this;
        }

        public Ticket build() {
            validate();

            return new Ticket(this);
        }

        private void validate() {
            if (lottoNumbers == null || lottoNumbers.size() != 6) {
                throw new InvalidTicketLength(ErrorMessage.INVALID_TICKET_LENGTH_ERROR.getMessage());
            }
        }

        private List<LottoNumber> createRandomLottoNumbers() {
            Set<LottoNumber> ticket = new HashSet<>();

            while (ticket.size() < LottoConfig.LOTTO_TICKET_LENGTH.getConfig()) {
                ticket.add(new LottoNumber(getRandomNumber()));
            }

            return ticket.stream().toList();
        }

        private int getRandomNumber() {
            return (int) (Math.random() * LottoConfig.MAX_LOTTO_NUMBER.getConfig()) + LottoConfig.MIN_LOTTO_NUMBER.getConfig();
        }
    }

    public enum TicketType {
        AUTO, CUSTOM, WINNER
    }
}
