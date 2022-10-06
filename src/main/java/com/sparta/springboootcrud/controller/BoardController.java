package com.sparta.springboootcrud.controller;

import com.sparta.springboootcrud.dto.BoardRequestDto;
import com.sparta.springboootcrud.entity.Board;
import com.sparta.springboootcrud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    public final BoardService boardService;

//    전체 게시글 목록 조회 API
//        - 제목, 작성자명, 작성 날짜를 조회하기
//        - 작성 날짜 기준으로 내림차순 정렬하기
    @GetMapping("/api/boards")
    public List<Board> getBoards() {
        List<Board> boardList = boardService.getDescBoardList();
        return boardList;
    }

//        게시글 작성 API
//        - 제목, 작성자명, 비밀번호, 작성 내용을 입력하기
    @PostMapping("/api/boards")
    public BoardRequestDto createPost(@RequestBody BoardRequestDto requestDto) {
        BoardRequestDto requestDtoTemp = boardService.createBoard(requestDto);
        return requestDtoTemp;
//        Board board = new Board(requestDto);
//        return boardRepository.save(board);
    }

//        게시글 조회 API
//        - 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기
//        (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
    @GetMapping("/api/boards/{id}")
    public Board searchPost(@PathVariable Long id) {
        return boardService.search(id);
    }

//        게시글 비밀번호 확인 API
//        - 비밀번호를 입력 받아 해당 게시글의 비밀번호와 일치여부 판단하기
    @PostMapping("/api/boards/{id}")
    public Boolean confirmPassword(@PathVariable Long id, @RequestBody String password) {
        return boardService.search(id).getPassword().equals(password);
    }

//        게시글 수정 API
//        - 제목, 작성자명, 비밀번호, 작성 내용을 수정되게 하기
    @PutMapping("/api/boards/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        boardService.update(id, requestDto);
        return id;
    }

    //        게시글 삭제 API
//        - 글이 삭제되게 하기
    @DeleteMapping("api/boards/{id}")
    public Long deletePost(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return id;
    }
}

//      테이블이 가져야 할 필드 정리 : id(PK), title, name, password, content, date