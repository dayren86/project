package api.privatbank;

import api.monobank.CurrencyMonoBank;
import api.monobank.MonoBankApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;

import java.io.IOException;

public class PrivatBankApi {
    private static final String URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";


    public CurrencyPrivatBank[] getCurrency() throws IOException, InterruptedException {

        String text = Jsoup
                .connect(URL)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        CurrencyPrivatBank[] currency = gson.fromJson(text, CurrencyPrivatBank[].class);

        return currency;

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PrivatBankApi privatBankApi = new PrivatBankApi();
        CurrencyPrivatBank[] df = privatBankApi.getCurrency();
        for (int i = 0; i < df.length; i++) {
            System.out.println(df[i]);
        }
    }
}
