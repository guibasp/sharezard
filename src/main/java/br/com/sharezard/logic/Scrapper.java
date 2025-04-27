package br.com.sharezard.logic;
import br.com.sharezard.models.PaperInfo;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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

    private static Optional<BigDecimal> extractValue (String value) {
        Matcher matcher = PATTERN.matcher(value.replace(",", "."));
        if (matcher.find()) {
            String decimalNumber = matcher.group();
            System.out.println("Extracted decimal number: " + decimalNumber);
            return Optional.of(new BigDecimal(decimalNumber));
        }
        return Optional.empty();
    }
    public static PaperInfo extractFIIs (String paperCode) throws IOException {

        var doc = Jsoup
                .connect("https://investidor10.com.br/fiis/" + paperCode)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
                .header("Accept-Language", "*").get();

        var cardBody = doc.getElementsByClass("_card-body");

        System.out.println("-----------");
        System.out.println(cardBody);
        var paperInfo = new PaperInfo();
        var value = cardBody.get(0).select("span").html().replace(",", ".");
        paperInfo.setUnitPrice(extractValue(value).orElse(null));
        paperInfo.setCode(paperCode);
        var yield = extractValue(cardBody.get(1).select("span").html());
        paperInfo.setDividendYield(yield.orElse(null));
        var pVP = extractValue(cardBody.get(2).select("span").html());
        paperInfo.setpVP(pVP.orElse(null));
        paperInfo.setTransactionAmountDaily(extractValue(cardBody.get(3).select("span").html()).orElse(null));
        paperInfo.setVariation(extractValue(cardBody.get(4).select("span").html()).orElse(null));
        return paperInfo;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(extractFIIs("MXRF11"));
    }
}
