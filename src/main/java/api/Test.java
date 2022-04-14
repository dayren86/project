package api;

import api.monobank.MonoBankApi;
import api.nbu.NbuApi;
import api.privatbank.CurrencyPrivatBank;
import api.privatbank.PrivatBankApi;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        PrivatBankApi privatBankApi = new PrivatBankApi();
        NbuApi nbuApi = new NbuApi();
        MonoBankApi monoBankApi = new MonoBankApi();

        try {
            privatBankApi.writeCurrencyToFile();
            nbuApi.writeCurrencyToFile();
            //monoBankApi.writeCurrencyToFile();
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }

        CurrencyPrivatBank currencyPrivatBankUSD = privatBankApi.readFromFileJPrivat().get(0);
        CurrencyPrivatBank currencyPrivatBankEUR = privatBankApi.readFromFileJPrivat().get(1);

        System.out.println(currencyPrivatBankUSD.getBuy());
        System.out.println(currencyPrivatBankUSD.getSale());


    }


}
