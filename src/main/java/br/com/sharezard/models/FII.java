package br.com.sharezard.models;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("fiis")
public class FII {
    private BigDecimal unitPrice, dividendYield, pVP, transactionAmountDaily, variation;
}
