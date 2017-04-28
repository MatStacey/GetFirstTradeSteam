package com.getfirsttrade.api;

import com.getfirsttrade.constant.Constants;
import com.getfirsttrade.response.TradeHistory;
import com.google.api.server.spi.config.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * The Echo API which Endpoints will be exposing.
 */
// [START echo_api_annotation]
@Api(
        name = "getfirsttrade",
        version = "v1",
        namespace =
        @ApiNamespace(
                ownerDomain = "api.getfirsttrade.com",
                ownerName = "api.getfirsttrade.com",
                packagePath = ""
        ),
        // [START_EXCLUDE]
        issuers = {
                @ApiIssuer(
                        name = "firebase",
                        issuer = "https://securetoken.google.com/" + Constants.PROJECT_ID,
                        jwksUri = "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com")
        }
        // [END_EXCLUDE]
)
// [END echo_api_annotation]
public class TradeAPI {

    private static final Logger LOGGER = Logger
            .getLogger(TradeAPI.class.getName());


    /**
     * Exposed API Endpoint. A reconciliation request will be processed,
     * reconciling data in each TableRequest against its BigQuery counterpart
     *
     * @return ResponseBundle of Reconciliation Results
     */
    @ApiMethod(name = "gettradehistory", apiKeyRequired = AnnotationBoolean.FALSE)
    public TradeHistory getTradeHistory() {
        TradeHistory trade = new TradeHistory();
        trade.setFirstTradeDate(
                doSteamAPIRequest()
        );
        return trade;
    }

    /**
     * Submit API Request to Steam Web API
     *
     * @return String of Steam Web API Response (JSON)
     */
    private String doSteamAPIRequest() {
        HttpClient client = getHttpClient();
        HttpGet getRequest = new HttpGet("https://api.steampowered.com/IEconService/GetTradeHistory/v1/?key=69D27D28A041392DB16B9839AA3C75BE&max_trades=1");

        try {
            HttpResponse response = client.execute(getRequest);
            return getHttpResponseAsString(response);
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        } finally {
            getRequest.releaseConnection();
        }

    }

    /**
     * Retrieve HTTP Client used to send Requests.
     *
     * @return
     */
    private HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }

    /**
     * Convert HttpResponse to a String.
     *
     * @param resp HttpResponse from Steam Web API
     * @return JSON Response as String
     * @throws IOException Error converting to String.
     */
    private String getHttpResponseAsString(HttpResponse resp) throws IOException {
        return EntityUtils.toString(resp.getEntity());
    }
}









