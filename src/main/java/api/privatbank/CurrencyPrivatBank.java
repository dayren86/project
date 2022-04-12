package api.privatbank;

import lombok.Data;

@Data
public class CurrencyPrivatBank {
        private String ccy;
        private String base_ccy;
        private float buy;
        private float sale;
}
