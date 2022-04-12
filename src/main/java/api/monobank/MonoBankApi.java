package api.monobank;

import api.ApiService;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MonoBankApi extends ApiService {

    private static final String URL = "https://api.monobank.ua/bank/currency";

    public List<CurrencyMonoBank> getCurrency() throws IOException {
        List<CurrencyMonoBank> currencyMonoBanks = new ArrayList<>();

        String text = getJsoup(URL);

        CurrencyMonoBank[] currencyMonoBank = gson.fromJson(text, CurrencyMonoBank[].class);


        for (CurrencyMonoBank object : currencyMonoBank) {
            if (object.getCurrencyCodeA() == 840 || object.getCurrencyCodeA() == 978 || object.getCurrencyCodeA() == 826) {
                currencyMonoBanks.add(object);
            }
        }
        return currencyMonoBanks;

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MonoBankApi monoBank = new MonoBankApi();
        List<CurrencyMonoBank> currency = monoBank.getCurrency();
        for (CurrencyMonoBank currencyMonoBank : currency) {
            System.out.println(currencyMonoBank.getCurrencyCodeA());
        }
    }
}

enum CurrencyM {
    USD,
    EUR,
}
