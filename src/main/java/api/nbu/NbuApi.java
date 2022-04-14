package api.nbu;

import api.ApiService;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NbuApi extends ApiService {
    private static final String URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    private static final String FILE = "src/main/java/api/nbu/nbu.json";

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

    public List<CurrencyNbu> getCurrency() throws IOException {
        CurrencyNbu[] currencyNbu = gson.fromJson(new FileReader(FILE), CurrencyNbu[].class);

        List<CurrencyNbu> currencyNbuList = new ArrayList<>();

        for (CurrencyNbu nbu : currencyNbu) {
            if (nbu.getR030() == 840 || nbu.getR030() == 978) {
                currencyNbuList.add(nbu);
            }
        }

        return currencyNbuList;
    }
}
