package api.nbu;

import api.monobank.CurrencyMonoBank;
import api.monobank.MonoBankApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;

import java.io.IOException;

public class NbuApi {
    private static final String URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";


    public CurrencyNbu[] getCurrency() throws IOException, InterruptedException {

        String text = Jsoup
                .connect(URL)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        CurrencyNbu[] currency = gson.fromJson(text, CurrencyNbu[].class);

        return currency;

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        NbuApi nbuApi = new NbuApi();
        CurrencyNbu[] df = nbuApi.getCurrency();
        for (int i = 0; i < df.length; i++) {
            System.out.println(df[i]);
        }
    }
}
