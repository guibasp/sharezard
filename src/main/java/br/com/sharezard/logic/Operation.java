package br.com.sharezard.logic;

import br.com.sharezard.models.Balance;

public interface Operation<T, E> {


    T execute(Balance<E> balance, long value);


}
