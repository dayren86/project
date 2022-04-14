package api.privatbank;

import api.ApiService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrivatBankApi extends ApiService {
    private static final String URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

    private static final String FILE = "src/main/java/api/privatbank/privatBank.json";

    public void writeCurrencyToFile() {

        String text = getJsoup(URL);

        try {
            FileWriter fileWriter = new FileWriter(FILE);

            fileWriter.write(text);

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CurrencyPrivatBank> readFromFileJPrivat() throws FileNotFoundException {

        CurrencyPrivatBank[] currencyPrivatBanks = gson.fromJson(new FileReader(FILE), CurrencyPrivatBank[].class);

        List<CurrencyPrivatBank> currencyPrivatBankList = new ArrayList<>();

        for (CurrencyPrivatBank currencyPrivatBank : currencyPrivatBanks) {
            if (currencyPrivatBank.getCcy().equals("USD") || currencyPrivatBank.getCcy().equals("EUR")) {
                currencyPrivatBankList.add(currencyPrivatBank);
            }
        }

        return currencyPrivatBankList;
    }
}
