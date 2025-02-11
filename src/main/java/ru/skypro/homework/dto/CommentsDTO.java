package ru.skypro.homework.dto;

import java.util.List;

/**
 * DTO для списка комментариев.
 */
public class CommentsDTO {
    private Integer count;
    private List<CommentDTO> results;

    public CommentsDTO() {
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public List<CommentDTO> getResults() {
        return results;
    }
    public void setResults(List<CommentDTO> results) {
        this.results = results;
    }
}

