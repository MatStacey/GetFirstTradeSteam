package test;

import com.getfirsttrade.api.TradeAPI;
import com.getfirsttrade.response.FirstTrade;
import org.junit.Test;

/**
 * Created by matst on 28/04/2017.
 */
public class GetFirstTrade {

    @Test
    public void getFirstTrade() {
        TradeAPI tradeAPI = new TradeAPI();
        FirstTrade trade = tradeAPI.getFirstTrade();
        System.out.println(trade.getFirstTradeDate());
    }
}
