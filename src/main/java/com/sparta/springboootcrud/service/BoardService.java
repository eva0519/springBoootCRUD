package com.sparta.springboootcrud.service;

import com.sparta.springboootcrud.dto.BoardRequestDto;
import com.sparta.springboootcrud.entity.Board;
import com.sparta.springboootcrud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        board.update(requestDto);
        return board.getId();
    }

    @Transactional
    public Board search(Long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
    }

    public List<Board> getDescBoardList() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    public BoardRequestDto createBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return requestDto;
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
