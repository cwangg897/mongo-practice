package com.example.notest.entity;

import com.example.notest.dto.BoardResponseDto;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "boards")
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    private String id;
    private String title;
    private String content;


    public BoardResponseDto toResponseDto(){
        return BoardResponseDto
                .builder()
                .title(title)
                .content(content)
                .build();
    }


    public void update() {
        this.title = "title변경";
        this.content = "content변경";
    }
}
