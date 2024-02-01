package com.example.shopee_s26849;

public class Customer
{

    private int id;
    private double saldo;

    public Customer(int id, double saldo)
    {
        this.id = id;
        this.saldo = saldo;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }



}
