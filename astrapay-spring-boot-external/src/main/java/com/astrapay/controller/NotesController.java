package com.astrapay.controller;

import com.astrapay.dto.NoteDto;
import com.astrapay.dto.NoteRequestDto;
import com.astrapay.service.NotesService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/notes")
@Api(value = "Notes Controller", tags = "Notes API")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @PostMapping
    @ApiOperation(value = "Add new note")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Note created successfully", response = NoteDto.class)
    })
    public NoteDto createNote(@Validated @RequestBody NoteRequestDto request) {
        return notesService.addNote(request);
    }

    @GetMapping
    @ApiOperation(value = "Get all notes")
    @ApiResponses({
            @ApiResponse(code = 200, message = "List of notes", response = NoteDto.class, responseContainer = "List")
    })
    public List<NoteDto> getNotes() {
        return notesService.getAllNotes();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete note by ID")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Note deleted successfully")
    })
    public Map<String, String> deleteNote(@PathVariable UUID id) {
        return notesService.deleteNote(id);
    }
}