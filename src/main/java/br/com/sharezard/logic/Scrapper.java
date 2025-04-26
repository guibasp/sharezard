package br.com.sharezard.logic;
import org.jsoup.*;

import javax.swing.text.Element;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scrapper {
    private static Pattern PATTERN;
    static {
        PATTERN = Pattern.compile("\\d+\\.\\d+");
    }
    static class PaperInfo {
        private String code;
        private BigDecimal unitPrice, dividendYield, pVP, transactionAmountDaily, variation;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public BigDecimal getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
        }

        public BigDecimal getDividendYield() {
            return dividendYield;
        }

        public void setDividendYield(BigDecimal dividendYield) {
            this.dividendYield = dividendYield;
        }

        public BigDecimal getpVP() {
            return pVP;
        }

        public void setpVP(BigDecimal pVP) {
            this.pVP = pVP;
        }

        public BigDecimal getTransactionAmountDaily() {
            return transactionAmountDaily;
        }

        public void setTransactionAmountDaily(BigDecimal transactionAmountDaily) {
            this.transactionAmountDaily = transactionAmountDaily;
        }

        public BigDecimal getVariation() {
            return variation;
        }

        public void setVariation(BigDecimal variation) {
            this.variation = variation;
        }

        public String toString() {
            return "PaperInfo{" +
                    "code='" + code + '\'' +
                    ", unitPrice=" + unitPrice +
                    ", dividendYield=" + dividendYield +
                    ", pVP=" + pVP +
                    ", transactionAmountDaily=" + transactionAmountDaily +
                    ", variation=" + variation +
                    '}';
        }
    }

    private static Optional<BigDecimal> extractValue (String value) {
        Matcher matcher = PATTERN.matcher(value.replace(",", "."));
        if (matcher.find()) {
            String decimalNumber = matcher.group();
            System.out.println("Extracted decimal number: " + decimalNumber);
            return Optional.of(new BigDecimal(decimalNumber));
        }
        return Optional.empty();
    }

    public static void main(String[] args) throws IOException {
        var doc = Jsoup
                .connect("https://investidor10.com.br/fiis/hgru11")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
                .header("Accept-Language", "*").get();

        var cardBody = doc.getElementsByClass("_card-body");

        System.out.println("-----------");
        System.out.println(cardBody);
        var paperInfo = new PaperInfo();
        var value = cardBody.get(0).select("span").html().replace(",", ".");
        paperInfo.setUnitPrice(extractValue(value).orElse(null));
        paperInfo.setCode("hgru11");
        var yield = extractValue(cardBody.get(1).select("span").html());
        paperInfo.setDividendYield(yield.orElse(null));
        var pVP = extractValue(cardBody.get(2).select("span").html());
        paperInfo.setpVP(pVP.orElse(null));
        paperInfo.setTransactionAmountDaily(extractValue(cardBody.get(3).select("span").html()).orElse(null));
        paperInfo.setVariation(extractValue(cardBody.get(4).select("span").html()).orElse(null));
        System.out.println(paperInfo);
//        for (var span : spans) {
//            System.out.println(span);
//        }
//        System.out.println(cardBody);
    }
}
