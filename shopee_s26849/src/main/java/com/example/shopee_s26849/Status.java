package com.example.shopee_s26849;

public class Status
{
    private int status;
    private double newSaldo;
    private String readSaldo;

    public Status(int code, String SaldoReading, double saldo)
    {
        status = code;  // 0 = ACCEPTED, 1 = DECLINED
        newSaldo = saldo;
        readSaldo = SaldoReading;
    }

    public int getStatus()
    {
        return status;
    }
    public double getNewSaldo()
    {
        return newSaldo;
    }

    public String getReadSaldo() {
        return readSaldo;
    }
}
