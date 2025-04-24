package com.astrapay.service;

import com.astrapay.dto.NoteDto;
import com.astrapay.dto.NoteRequestDto;
import com.astrapay.exception.NoteNotFoundException;
import com.astrapay.service.model.NoteModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class NotesService {

    private final Map<UUID, NoteModel> notes = new ConcurrentHashMap<>();

    public NoteDto addNote(NoteRequestDto request) {
        NoteModel model = NoteModel.builder()
                .id(UUID.randomUUID())
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .build();
        notes.put(model.getId(), model);
        return toDto(model);
    }

    public List<NoteDto> getAllNotes() {
        return notes.values().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Map<String, String> deleteNote(UUID id) {
        Map<String, String> map = new HashMap<>();
        if (!notes.containsKey(id)) {
            throw new NoteNotFoundException("Note not found: " + id);
        }
        notes.remove(id);
        map.put("result", "Note deleted successfully");

        return map;
    }

    private NoteDto toDto(NoteModel model) {
        return new NoteDto(model.getId(), model.getContent(), model.getCreatedAt());
    }
}
