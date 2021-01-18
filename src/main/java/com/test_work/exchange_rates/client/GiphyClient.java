package com.test_work.exchange_rates.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "giphyClient", url = "${giphy.url}")
public interface GiphyClient {

    @RequestMapping(method = RequestMethod.GET, value = "/random?{api_key}&tag=rich&rating=r")
    ResponseEntity<Map> getRichGif(@RequestParam("api_key") String apiKey);

    @RequestMapping(method = RequestMethod.GET, value = "/random?{api_key}&tag=broke&rating=r")
    ResponseEntity<Map> getBrokeGif(@RequestParam("api_key") String apiKey);
}
