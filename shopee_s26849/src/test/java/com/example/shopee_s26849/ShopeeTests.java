package com.example.shopee_s26849;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class ShopeeTests
{


    @Autowired
    private Storage storage;

    @Test
    public void testGetInstance()
    {
        Storage instance1 = Storage.getInstance();
        Storage instance2 = Storage.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    public void testAddItem()
    {
        int initialSize = storage.getItemStorage().size();

        Item newItem = new Item("newItem", 10.0);
        storage.addItem(newItem);

        assertEquals(initialSize + 1, storage.getItemStorage().size());
    }

    @Test
    public void testAddExistingItemToCart()
    {
        Customer customer = new Customer(1, 150.0);
        Cart cart = new Cart(customer);

        cart.addItemToCart("beer");
        cart.addItemToCart("milk");

        assertEquals(2, cart.getCart().size());
    }

    @Test
    public void testAddNotExistingItemToCart()
    {
        Customer customer = new Customer(1, 150.0);
        Cart cart = new Cart(customer);

        cart.addItemToCart("bread");
        cart.addItemToCart("water");

        assertEquals(0, cart.getCart().size());
    }

    @Test
    public void testOrderItemsWithSufficientSaldo()
    {
        Customer customer = new Customer(1, 50.0);
        Cart cart = new Cart(customer);

        cart.addItemToCart("milk");

        ShopService shopService = new ShopService(cart);
        Status status = shopService.orderItems();

        assertEquals(0, status.getStatus());
    }

    @Test
    public void CheckStatusIfTooLowSaldo()
    {
        Customer customer = new Customer(1, 10.0);
        Cart cart = new Cart(customer);

        cart.addItemToCart("beer");
        cart.addItemToCart("milk");

        ShopService shopService = new ShopService(cart);
        Status result = shopService.orderItems();

        assertEquals(1, result.getStatus());
    }



}




