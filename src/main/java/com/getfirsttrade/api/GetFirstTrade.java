package com.getfirsttrade.api;

import com.getfirsttrade.response.FirstTrade;
import com.google.api.server.spi.config.*;
import com.getfirsttrade.constant.Constants;

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
public class GetFirstTrade {

    private static final Logger LOGGER = Logger
            .getLogger(GetFirstTrade.class.getName());

    /**
     * Exposed API Endpoint. A reconciliation request will be processed,
     * reconciling data in each TableRequest against its BigQuery counterpart
     *
     * @return ResponseBundle of Reconciliation Results
     */
    @ApiMethod(name = "getfirsttrade", apiKeyRequired = AnnotationBoolean.FALSE)
    public FirstTrade reconcile() {
        FirstTrade trade = new FirstTrade();


        return trade;
    }







}
