package org.stitane.katas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringJoiner;

public class Transaction {
    private final String date;
    private final BigDecimal amount;
    private final BigDecimal balance;

    public Transaction(String date, int amount, BigDecimal balance) {
        this.date = date;
        this.amount = BigDecimal.valueOf(amount);
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return new StringJoiner("||", "", "\n").add(date).add(getAmount()).add(getBalance()).toString();
    }

    public String getAmount() {
        BigDecimal creditStr = this.amount.setScale(2, RoundingMode.HALF_UP);
        return BigDecimal.ZERO.equals(creditStr) ? "" : String.valueOf(creditStr);
    }

    public String getBalance() {
        BigDecimal creditStr = this.balance.setScale(2, RoundingMode.HALF_UP);
        return BigDecimal.ZERO.equals(creditStr) ? "" : String.valueOf(creditStr);
    }
}
