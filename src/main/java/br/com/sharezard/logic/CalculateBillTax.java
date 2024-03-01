package br.com.sharezard.logic;

import br.com.sharezard.exceptions.ConflictException;
import br.com.sharezard.models.Balance;
import br.com.sharezard.models.Bill;

public class CalculateBillTax implements Operation<Long, Bill>{
    public Long execute(Balance<Bill> balance, long valueTax) {

        if(valueTax < 1) {
            throw new ConflictException("tax value should greater than zero.");
        }
        return (long) (balance.value().getAmount() * (valueTax / 100.0));
    }
}
