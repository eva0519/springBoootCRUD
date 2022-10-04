package com.sparta.springboootcrud.entity;

import com.sparta.springboootcrud.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board extends Timestamped {

//    id(PK), title, name, password, content, date
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String content;

//    새로운 게시글 생성시 사용
    public Board (BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }
}
