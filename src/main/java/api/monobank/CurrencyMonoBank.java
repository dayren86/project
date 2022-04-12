package api.monobank;

import lombok.Data;

@Data
public class CurrencyMonoBank {
    private int currencyCodeA;
    private int currencyCodeB;
    private int date;
    private float rateSell;
    private float rateBuy;
    private float rateCross;

}
