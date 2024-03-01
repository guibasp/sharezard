package br.com.sharezard.logic;

import br.com.sharezard.exceptions.ConflictException;
import br.com.sharezard.models.Bill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateBillTaxTest {

    private CalculateBillTax calculateBillTax;
    private Bill bill;

    @BeforeEach
    public void setupEach() {
        calculateBillTax = new CalculateBillTax();
        bill = Bill.builder().amount(1000).build();
    }

    @Test
    public void shouldApplyFivePercentTaxInAmountValueWithSuccess() {
        Assertions.assertEquals(
                50L,
                calculateBillTax.execute(bill, 5),
                "Tax value invalid for operation");
    }

    @Test
    public void shouldFailed() {
        Assertions.assertThrows(
                ConflictException.class,
                () -> calculateBillTax.execute(bill, -10)
        );
    }
}
