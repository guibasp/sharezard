package br.com.sharezard.adapters;

import br.com.sharezard.models.Brother;
import br.com.sharezard.models.PaperInfo;
import br.com.sharezard.wire.in.BrotherDTO;
import br.com.sharezard.wire.out.BrotherResponse;
import br.com.sharezard.wire.out.PaperInfoResponse;
import org.springframework.stereotype.Component;

@Component
public class PaperAdapter {

    public Brother inToInternal (BrotherDTO brotherDTO) {
        return Brother.builder().name(brotherDTO.getName())
                .nickName(brotherDTO.getNickName())
                .profile(brotherDTO.getProfile())
                .brotherId(brotherDTO.getBrotherId())
                .build();
    }

    public PaperInfoResponse internalToOut (PaperInfo paperInfo) {
        return PaperInfoResponse
                .builder()
                    .code(paperInfo.getCode())
                .pVP(paperInfo.getpVP())
                .dividendYield(paperInfo.getDividendYield())
                .transactionAmountDaily(paperInfo.getTransactionAmountDaily())
                .unitPrice(paperInfo.getUnitPrice())
                .variation(paperInfo.getVariation())
                .build();
    }
}
