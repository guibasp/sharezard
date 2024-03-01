package br.com.sharezard.logic;

import br.com.sharezard.exceptions.ConflictException;
import br.com.sharezard.models.Bill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SplitBillTest {
    private SplitBill splitBill;
    private Bill bill;
    @BeforeEach
    public void setup() {
        splitBill = new SplitBill();
        bill= Bill.builder().amount(1000).build();

    }

    @Test
    public void shouldSlitBillEquallyBetweenBrothers() {
        Assertions.assertEquals(
                200L,
                splitBill.execute(bill, 5),
                "Unfair division");
    }

    @Test
    public void shouldThrownAnExceptionWhenQuantityLessThanOne () {
        Assertions.assertThrows(ConflictException.class,
                () -> splitBill.execute(bill, 0),
                "Didn't throw an exception");
    }



}
