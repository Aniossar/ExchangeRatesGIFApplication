package com.test_work.exchange_rates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.test_work.exchange_rates.client", "com.test_work.exchange_rates.controller"})
public class ExchangeRatesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeRatesApplication.class, args);
    }

}
