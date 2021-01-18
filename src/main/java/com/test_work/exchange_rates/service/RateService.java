package com.test_work.exchange_rates.service;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

@org.springframework.stereotype.Service
public class RateService {

    public double analysisRate(Map responseEntity) {
        Map<String, Double> rates = (Map<String, Double>) responseEntity.get("rates");
        return rates.get("RUB");
    }

    public byte[] grabGIF(String gifId) {

        String gifURL = "https://i.giphy.com/" + gifId + ".gif";

        try (InputStream inputStream = new BufferedInputStream((new URL(gifURL)).openStream())) {
            return IOUtils.toByteArray(inputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String createYesterdayDate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(calendar.getTime());
    }
}
