package com.ua.sutty.springRestApi.transfer;

import com.ua.sutty.springRestApi.domain.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {

    private String value;

    public static TokenDTO from(Token token){
        return new TokenDTO(token.getValue());

    }

}
