package com.test_work.exchange_rates.controller;

import com.test_work.exchange_rates.client.GiphyClient;
import com.test_work.exchange_rates.client.RateClient;
import com.test_work.exchange_rates.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private RateClient rateClient;

    @Autowired
    private GiphyClient giphyClient;

    @Autowired
    private RateService rateService;

    @Value("${openexchangerates.id}")
    private String openexchangeratesId;

    @Value("${giphy.id}")
    private String giphyId;

    @GetMapping(path = "/checkRate")
    public HttpEntity<byte[]> getRate() {
        Double currentRUB = rateService.analysisRate(rateClient.getCurrentRate(openexchangeratesId).getBody());
        Double yesterdayRUB = rateService.analysisRate(rateClient.getYesterdayRate(rateService.createYesterdayDate(), openexchangeratesId).getBody());
        Map finalResponse = null;
        if ((currentRUB - yesterdayRUB) >= 0) {
            finalResponse = giphyClient.getRichGif(giphyId).getBody();
        } else finalResponse = giphyClient.getBrokeGif(giphyId).getBody();

        Map<String, String> gifInfo = (Map<String, String>) finalResponse.get("data");
        byte[] gifImage = rateService.grabGIF(gifInfo.get("id"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_GIF);
        headers.setContentLength(gifImage.length);
        return new HttpEntity<>(rateService.grabGIF(gifInfo.get("id")), headers);
    }
}
