package br.com.sharezard.wire.out;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaperInfoResponse {

    private String code;
    private BigDecimal unitPrice, dividendYield, pVP, transactionAmountDaily, variation;

}
