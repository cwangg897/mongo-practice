package com.example.notest.dto;


import com.example.notest.entity.Board;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequestDto {

    private String title;
    private String content;

    public BoardRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }


}
