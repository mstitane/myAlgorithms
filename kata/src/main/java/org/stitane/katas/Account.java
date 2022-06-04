package org.stitane.katas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;
    private final List<Transaction> statments = new ArrayList<>();

    public void deposit(int amount) {
        this.balance = balance.add(BigDecimal.valueOf(amount));
        saveTransaction(amount);
    }

    public void withdraw(int amount) {
        this.balance = balance.subtract(BigDecimal.valueOf(amount));
        saveTransaction(-1 * amount);
    }

    public String printStatement() {
        StringBuilder out = new StringBuilder("DATE||AMOUNT||BALANCE\n");
        statments.stream().map(Transaction::toString).forEach(out::append);
        return out.toString();
    }

    private void saveTransaction(int amount) {
        statments.add(0, new Transaction(LocalDate.now().toString(), amount, balance));
    }
}
