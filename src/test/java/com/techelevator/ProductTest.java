package com.techelevator;

import com.techelevator.Product.Candy;
import com.techelevator.Product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductTest {

    Candy testItem = new Candy("Wonka Bar", "1.50", 5, "1");

    Candy testItemOS = new Candy("Wonka Bar", "1.50", 0, "1");

    BigDecimal testBalanceEnough = new BigDecimal("2");

    @Test
    public void product_is_in_stock(){

        Product sut = testItem;

        boolean inItInStock = sut.inStock(sut);

        Assert.assertTrue(inItInStock);
    }

    @Test
    public void product_is_out_of_stock(){

        Product sut = testItemOS;

        boolean isItInStock = sut.inStock(sut);

        Assert.assertFalse(isItInStock);
    }

    @Test
    public void get_name_correct(){

        Product sut = testItem;

        String name = sut.getName();

        Assert.assertEquals("Wonka Bar", name);

    }

    @Test
    public void get_correct_price() {

        Product sut = testItem;

        String cost = sut.getCost();

        Assert.assertEquals("1.50", cost);
    }

    @Test
    public void get_correct_slot_location() {

        Product sut = testItem;

        String slot = sut.getSlotLocation();

        Assert.assertEquals("1",slot);
    }

    @Test
    public void does_stock_remove(){

        Product sut = testItem;

        Money test = new Money();

        test.feedMoney(testBalanceEnough);

        Product product = sut.removeStock(sut,test);

        Assert.assertEquals(4, product.getStock());

    }
}
