package com.example.shopee_s26849;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopeeS26849Application
{

	public static void main(String[] args)
	{
		SpringApplication.run(ShopeeS26849Application.class, args);


		Customer customer = new Customer(2137, 911 );
		Cart cart = new Cart(customer);

		cart.addItemToCart("milk");
		cart.addItemToCart("milk");
		cart.addItemToCart("beer");

		ShopService shopService = new ShopService(cart);
		Status result = shopService.orderItems();

		System.out.println(result.getStatus());
		System.out.printf(result.getReadSaldo());
		System.out.println(result.getNewSaldo());




	}

}
