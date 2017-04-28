package test;

import com.getfirsttrade.api.TradeAPI;
import com.getfirsttrade.response.TradeHistory;
import org.junit.Test;

/**
 * Created by matst on 28/04/2017.
 */
public class GetTradeHistory {

    @Test
    public void getTradeHistory() {
        TradeAPI tradeAPI = new TradeAPI();
        TradeHistory trade = tradeAPI.getTradeHistory();
        System.out.println(trade.getFirstTradeDate());
    }
}
