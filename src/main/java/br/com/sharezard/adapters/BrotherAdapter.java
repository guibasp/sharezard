package br.com.sharezard.adapters;

import br.com.sharezard.models.Brother;
import br.com.sharezard.wire.in.BrotherDTO;
import br.com.sharezard.wire.out.BrotherResponse;
import org.springframework.stereotype.Component;

@Component
public class BrotherAdapter {

    public Brother inToInternal (BrotherDTO brotherDTO) {
        return Brother.builder().name(brotherDTO.getName())
                .nickName(brotherDTO.getNickName())
                .profile(brotherDTO.getProfile())
                .brotherId(brotherDTO.getBrotherId())
                .build();
    }

    public BrotherResponse internalToOut (Brother brother) {
        return BrotherResponse
                .builder()
                    .name(brother.getName())
                    .id(brother.getBrotherId())
                .build();
    }
}
