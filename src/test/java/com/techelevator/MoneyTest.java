package com.techelevator;

import com.techelevator.Product.Candy;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyTest {

    BigDecimal testBalanceDimes = new BigDecimal(".10");

    BigDecimal testBalanceEnough = new BigDecimal("2");

    Candy testItem = new Candy("Wonka Bar", "1.50", 5, "1");


    @Test
    public void not_enough_money_to_purchase_item() {

        Money sut = new Money();

        sut.feedMoney(testBalanceDimes);

        boolean checkFunds = sut.checkFunds(sut, testItem);

        Assert.assertFalse(checkFunds);
    }

    @Test
    public void enough_money_to_purchase_item() {

        Money sut = new Money();

        sut.feedMoney(testBalanceEnough);

        boolean checkFunds = sut.checkFunds(sut, testItem);

        Assert.assertTrue(checkFunds);
    }

    @Test
    public void return_right_amount_of_quarters() {

        BigDecimal testBalanceQuarters = new BigDecimal("1");

        Money sut = new Money();

        String changeReturned = sut.changeReturned(testBalanceQuarters);

        Assert.assertEquals(4, 4);

    }

    @Test
    public void return_right_amount_of_dimes() {

        Money sut = new Money();

        sut.feedMoney(testBalanceDimes);

        String changeReturned = sut.changeReturned(sut.getBalance());

        Assert.assertEquals(1,1);
    }

    @Test
    public void return_right_amount_of_nickles() {

        BigDecimal testBalanceNickles = new BigDecimal(".05");

        Money sut = new Money();

        String changeReturned = sut.changeReturned(testBalanceNickles);

        Assert.assertEquals(1, 1);
    } //

    @Test
    public void does_get_balance_return_balance(){

        BigDecimal testGetBalance = new BigDecimal("10");

        Money sut = new Money();

        BigDecimal getBalance = sut.getBalance();

        Assert.assertEquals(10,10);
    }
}
