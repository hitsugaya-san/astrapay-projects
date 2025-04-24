package com.astrapay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class NoteDto {
    private UUID id;
    private String content;
    private LocalDateTime createdAt;
}
