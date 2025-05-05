package br.com.sharezard.adapters;

import br.com.sharezard.models.Customer;
import br.com.sharezard.wire.in.CustomerDTO;
import br.com.sharezard.wire.out.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerAdapter {

    public Customer inToInternal (CustomerDTO customerDTO) {
        return Customer.builder().name(customerDTO.getName())
                .nickName(customerDTO.getNickName())
                .profile(customerDTO.getProfile())
                .customerId(customerDTO.getCustomerId())
                .build();
    }

    public CustomerResponse internalToOut (Customer customer) {
        return CustomerResponse
                .builder()
                    .name(customer.getName())
                    .id(customer.getCustomerId())
                    .nickName(customer.getNickName())
                .build();
    }
}
