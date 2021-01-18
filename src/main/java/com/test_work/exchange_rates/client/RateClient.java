package com.test_work.exchange_rates.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "rateClient", url = "${openexchangerates.url}")
public interface RateClient {

    @RequestMapping(method = RequestMethod.GET, value = "/latest.json?app_id={app_id}")
    ResponseEntity<Map> getCurrentRate(@RequestParam("app_id") String appId);

    @RequestMapping(method = RequestMethod.GET, value = "/historical/{date}.json?app_id={app_id}")
    ResponseEntity<Map> getYesterdayRate(@RequestParam("date") String date, @RequestParam("app_id") String appId);
}
