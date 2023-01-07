package com.example.notest.dto;


import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponseDto {

    private String title;
    private String content;
}
