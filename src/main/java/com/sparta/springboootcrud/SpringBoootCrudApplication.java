package com.sparta.springboootcrud;

import com.sparta.springboootcrud.entity.Board;
import com.sparta.springboootcrud.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBoootCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoootCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BoardRepository boardRepository) {
        return (args) -> {
            System.out.println("데이터 인쇄");
            List<Board> BoardList = boardRepository.findAll();
            for (int i=0; i<BoardList.size(); i++) {
                Board board = BoardList.get(i);
                System.out.println(board.getId());
                System.out.println(board.getTitle());
                System.out.println(board.getName());
                System.out.println(board.getPassword());
                System.out.println(board.getModifiedAt());
                System.out.println(board.getContent());
            }
            System.out.println("----------------Board Table List------------------");
        };
    }
}
