package com.example.notest.repository;

import java.util.Optional;

import com.example.notest.entity.Board;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardRepository extends MongoRepository<Board, String> {

}
