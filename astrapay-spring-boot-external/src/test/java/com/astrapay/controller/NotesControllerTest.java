package com.astrapay.controller;

import com.astrapay.dto.NoteDto;
import com.astrapay.dto.NoteRequestDto;
import com.astrapay.exception.NoteNotFoundException;
import com.astrapay.service.NotesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NotesController.class)
class NotesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotesService notesService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnListOfNotes() throws Exception {
        NoteDto note = new NoteDto(UUID.randomUUID(), "Test Note", LocalDateTime.now());
        Mockito.when(notesService.getAllNotes()).thenReturn(List.of(note));

        mockMvc.perform(get("/api/notes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].content").value("Test Note"));
    }

    @Test
    void shouldAddNote() throws Exception {
        NoteRequestDto request = new NoteRequestDto();
        request.setContent("Note baru");

        NoteDto response = new NoteDto(UUID.randomUUID(), "Note baru", LocalDateTime.now());
        Mockito.when(notesService.addNote(any(NoteRequestDto.class))).thenReturn(response);

        mockMvc.perform(post("/api/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.content").value("Note baru"));
    }

    @Test
    void shouldRejectEmptyNote() throws Exception {
        NoteRequestDto request = new NoteRequestDto();
        request.setContent(""); // Kosong

        mockMvc.perform(post("/api/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("{note.content.notempty}"));
    }

    @Test
    void shouldReturnNotFoundOnDeleteNonexistentNote() throws Exception {
        UUID fakeId = UUID.randomUUID();
        Mockito.doThrow(new NoteNotFoundException("Note not found"))
                .when(notesService).deleteNote(eq(fakeId));

        mockMvc.perform(delete("/api/notes/" + fakeId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Note not found"));
    }
}
