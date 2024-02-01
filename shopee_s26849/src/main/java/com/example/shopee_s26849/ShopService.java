package com.example.shopee_s26849;

import java.util.ArrayList;
import java.util.List;


public class ShopService
{

    private double full_price;
    private double saldo;
    private List<Item> cart;
    private Customer customer;
    public ShopService(Cart customer_cart)
    {

        this.cart = new ArrayList<>(customer_cart.getCart());
        Customer customer = customer_cart.getCustomer();
        this.saldo = customer.getSaldo();

    }

    public Status orderItems()
    {

        for (Item item : cart)
        {
            if (item.getName().equals("milk"))
            {
                full_price += item.getPrice();
            }
            else if (item.getName().equals("beer"))
            {
                full_price += item.getPrice();
            }
        }

        if (full_price > saldo)
        {
            return new Status(1, "Stan konta: " + saldo +" jest zbyt niski, by dokonać zakupów o podanej kowcie: ", full_price);
        }
        else if (full_price <= saldo)
        {
            saldo -= full_price;
        }
        return new Status(0, "Nowy stan konta po zakupach to: ", saldo);

    }

}
