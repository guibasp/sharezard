package br.com.sharezard.models;

import java.math.BigDecimal;

public class PaperInfo {
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
