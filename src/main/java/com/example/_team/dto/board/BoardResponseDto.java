package com.example._team.dto.board;

import com.example._team.domain.Board;
import com.example._team.domain.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponseDto {

    private Integer boardIdx;
    private String title;
    private String content;
    private Category category;
    private Integer views;
    private Integer status;
    private Integer userIdx; // Use Integer instead of Long
//    private Integer answerBoardIdx; // Use Integer instead of Long



    // Static method to convert from entity to DTO
    public static BoardResponseDto fromEntity(Board board) {
        return BoardResponseDto.builder()
                .boardIdx(board.getBoardIdx())
                .title(board.getTitle())
                .content(board.getContent())
                .category(board.getCategory())
                .views(board.getViews())
                .status(board.getStatus())
                .userIdx(board.getUserIdx() != null ? board.getUserIdx().getUserIdx() : null) // Corrected method to get ID
//                .answerBoardIdx(board.getAnswerBoardIdx() != null ? board.getAnswerBoardIdx().getBoardIdx() : null) // Corrected method to get ID
                .build();
    }
}
