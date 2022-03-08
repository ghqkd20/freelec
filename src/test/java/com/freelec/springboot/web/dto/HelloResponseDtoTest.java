package com.freelec.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class HelloResponseDtoTest {
    @Test
    public void 롬복_테스트(){
        //when
        String str = "hjh";
        int amount = 1000;

        //given
        HelloResponseDto test = new HelloResponseDto(str,amount);

        //then
        assertThat(test.getName()).isEqualTo(str);
        assertThat(test.getAmount()).isEqualTo(amount);
    }
}