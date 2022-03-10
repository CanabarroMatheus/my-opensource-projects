package io.github.canabarromatheus.coworkingsystem.util;

import java.math.BigDecimal;

public class MoneyUtil {
    private MoneyUtil() {
    }

    public static BigDecimal convertMoneyToBigDecimal(String value) {
        String convertedValue = value.replace("R$", "")
                .replace(",", ".");
        return new BigDecimal(convertedValue);
    }

    public static String convertBigDecimalToMoney(BigDecimal value) {
        return "R$" + value.toPlainString()
                .replace(".", ",");
    }
}
