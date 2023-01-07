package com.example.notest.controller;

import com.example.notest.dto.BoardRequestDto;
import com.example.notest.dto.BoardResponseDto;
import com.example.notest.entity.Board;
import com.example.notest.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardRepository boardRepository;

    @PostMapping
    public ResponseEntity<Void> createBoard(@RequestBody BoardRequestDto requestDto){
        boardRepository.insert(requestDto.toEntity());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDto> findOne(@PathVariable String id){
        System.out.println("id : "+id);
        Board findBoard = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("존재x"));
        return ResponseEntity.ok(findBoard.toResponseDto());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateOne(@PathVariable String id){
        System.out.println("id : "+id);
        Board findBoard = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("존재x"));
        findBoard.update();
        boardRepository.save(findBoard);
        return ResponseEntity.ok().build();
    }


}
