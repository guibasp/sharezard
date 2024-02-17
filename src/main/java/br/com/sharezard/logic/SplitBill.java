package br.com.sharezard.logic;

import br.com.sharezard.exceptions.ConflictException;
import br.com.sharezard.models.Balance;
import br.com.sharezard.models.Bill;

public class SplitBill implements Operation<Long, Bill> {
    @Override
    public Long execute(Balance<Bill> balance, long quantity) {
        if (quantity < 1)
            throw new ConflictException("The quantity should be greater than 0");
        return balance.value().getAmount() / quantity;
    }
}
