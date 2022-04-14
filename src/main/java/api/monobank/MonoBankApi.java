package api.monobank;

import api.ApiService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonoBankApi extends ApiService {

    private static final String URL = "https://api.monobank.ua/bank/currency";

    private static final String FILE = "src/main/java/api/monobank/MonoBank.json";

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

    public List<CurrencyMonoBank> readFromFileJMonoBank() throws FileNotFoundException {

        CurrencyMonoBank[] currencyMonoBank = gson.fromJson(new FileReader(FILE), CurrencyMonoBank[].class);

        List<CurrencyMonoBank> currencyMonoBankList = new ArrayList<>();
        for (CurrencyMonoBank monoBank : currencyMonoBank) {
            if (monoBank.getCurrencyCodeA() == 840 || monoBank.getCurrencyCodeA() == 978 || monoBank.getCurrencyCodeA() == 826) {
                currencyMonoBankList.add(monoBank);
            }
        }
        return currencyMonoBankList;

    }
}
