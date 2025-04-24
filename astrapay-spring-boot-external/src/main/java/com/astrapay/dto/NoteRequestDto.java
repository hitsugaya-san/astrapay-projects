package com.astrapay.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class NoteRequestDto {
    @NotEmpty(message = "{note.content.notempty}")
    private String content;
}