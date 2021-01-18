/*
package com.test_work.exchange_rates;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.test_work.exchange_rates.client.GiphyClient;
import com.test_work.exchange_rates.client.RateClient;
import com.test_work.exchange_rates.service.RateService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientWireMockTest {

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

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @BeforeClass
    public static void setup(){
        WireMockServer wireMockServer = new WireMockServer(8089);
        wireMockServer.start();
    }

    @Test
    public void shouldCallCurrentRateService() throws Exception{
        wireMockRule.stubFor(get(urlPathMatching("/latest\\.json\\?app_id=.*")).
                willReturn(aResponse()
                        .withBody("{\"rates\":[" +
                                "\"RUB\" : \"100.1\"]}")
                        .withHeader("Content-Type","application/json")
                        .withStatus(200)));

        Optional<Double> currentRubRateResponse =Optional.of(rateService.analysisRate
                (ResponseEntity.ok(rateClient.getCurrentRate(openexchangeratesId)).getBody()));
        Optional<Double> expectedCurrentRateResponse = Optional.of(100.1);
        Assert.assertEquals(currentRubRateResponse, expectedCurrentRateResponse);
    }

    @Test
    public void shouldCallYesterdayRateService() throws Exception{
        wireMockRule.stubFor(get(urlPathMatching("/historical/\\d{2}-\\d{2}-\\d{4}\\.json\\?app_id=.*")).
                willReturn(aResponse()
                        .withBody("{\"rates\":[" +
                                "\"RUB\" : \"100.1\"]}")
                        .withHeader("Content-Type","application/json")
                        .withStatus(200)));

        Optional<Double> currentRubRateResponse =Optional.of(rateService.analysisRate
                (ResponseEntity.ok(rateClient.getYesterdayRate(rateService.createYesterdayDate(), openexchangeratesId)).getBody()));
        Optional<Double> expectedCurrentRateResponse = Optional.of(100.1);
        Assert.assertEquals(currentRubRateResponse, expectedCurrentRateResponse);
    }

    @Test
    public void shouldCallRichGiphyService() throws Exception{
        wireMockRule.stubFor(get(urlPathMatching("/random?.*&tag=rich&rating=r")).
                willReturn(aResponse()
                        .withBody("{\"data\":[" +
                                "\"id\" : \"Good GIF ID\"]}")
                        .withHeader("Content-Type","application/json")
                        .withStatus(200)));
        ResponseEntity<Map> finalResponse = ResponseEntity.ok(giphyClient.getRichGif(giphyId).getBody());
        Map<String,String> gifInfo = (Map<String, String>) finalResponse.getBody().get("data");
        Optional<String> richGiphyResponce =Optional.of(gifInfo.get("id"));
        Optional<String> expectedRichGiphyResponce = Optional.of("Good GIF ID");
        Assert.assertEquals(richGiphyResponce, expectedRichGiphyResponce);
    }

    @Test
    public void shouldCallBrokeGiphyService() throws Exception{
        wireMockRule.stubFor(get(urlPathMatching("/random?.*&tag=broke&rating=r")).
                willReturn(aResponse()
                        .withBody("{\"data\":[" +
                                "\"id\" : \"Good GIF ID\"]}")
                        .withHeader("Content-Type","application/json")
                        .withStatus(200)));
        ResponseEntity<Map> finalResponse = ResponseEntity.ok(giphyClient.getBrokeGif(giphyId).getBody());
        Map<String,String> gifInfo = (Map<String, String>) finalResponse.getBody().get("data");
        Optional<String> brokeGiphyResponse =Optional.of(gifInfo.get("id"));
        Optional<String> expectedBrokeGiphyResponse = Optional.of("Good GIF ID");
        Assert.assertEquals(brokeGiphyResponse, expectedBrokeGiphyResponse);
    }
}
*/
