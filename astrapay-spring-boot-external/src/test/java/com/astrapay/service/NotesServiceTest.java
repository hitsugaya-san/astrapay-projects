package com.astrapay.service;

import com.astrapay.dto.NoteDto;
import com.astrapay.dto.NoteRequestDto;
import com.astrapay.exception.NoteNotFoundException;
import com.astrapay.service.model.NoteModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NotesServiceTest {

    private NotesService notesService;

    @BeforeEach
    void setUp() {
        notesService = new NotesService();
    }

    @Test
    void shouldAddNoteSuccessfully() {
        NoteRequestDto request = new NoteRequestDto();
        request.setContent("Ini catatan baru");

        NoteDto result = notesService.addNote(request);

        assertNotNull(result.getId());
        assertEquals("Ini catatan baru", result.getContent());
        assertNotNull(result.getCreatedAt());
    }

    @Test
    void shouldReturnAllNotes() {
        NoteRequestDto req1 = new NoteRequestDto();
        req1.setContent("Catatan 1");
        notesService.addNote(req1);

        NoteRequestDto req2 = new NoteRequestDto();
        req2.setContent("Catatan 2");
        notesService.addNote(req2);

        List<NoteDto> allNotes = notesService.getAllNotes();

        assertEquals(2, allNotes.size());
    }

    @Test
    void shouldDeleteNoteSuccessfully() {
        NoteRequestDto request = new NoteRequestDto();
        request.setContent("Catatan untuk dihapus");
        NoteDto saved = notesService.addNote(request);

        assertDoesNotThrow(() -> notesService.deleteNote(saved.getId()));
    }

    @Test
    void shouldThrowWhenDeletingNonexistentNote() {
        UUID fakeId = UUID.randomUUID();

        Exception exception = assertThrows(NoteNotFoundException.class, () -> {
            notesService.deleteNote(fakeId);
        });

        assertTrue(exception.getMessage().contains("Note not found"));
    }
}