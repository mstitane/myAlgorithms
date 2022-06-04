package org.stitane.katas;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankingKataTests {

    Account account;

    @BeforeAll
    public void setUp() {
        account = new Account();
    }

    @Test
    void when_client_makes_deposit_and_withdraw_it_should_works() {
        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);
        String s = LocalDate.now().toString();
        Assertions.assertEquals("DATE||AMOUNT||BALANCE\n" + s + "||500.00||1400.00\n" + s + "||-100.00||900.00\n" + s + "||1000.00||1000.00\n", account.printStatement());

    }
}
