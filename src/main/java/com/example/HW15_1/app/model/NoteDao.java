package com.example.HW15_1.app.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class NoteDao {
    private Map<Long, Note> noteMap;
    public NoteDao() {
        noteMap = new HashMap<>();
        noteMap.put(1l, new Note(1l, "breakfast", "make coffee"));
        noteMap.put(2l, new Note(2l, "shop", "buy bread"));
        noteMap.put(3l, new Note(3l, "goit", "to do homework"));
    }

    public Optional<Note> getByID(Long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return Optional.ofNullable(noteMap.get(id));
    }

    @Transient
    public Optional<Note> deleteById(Long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return Optional.ofNullable(noteMap.remove(id));
    }

    public void updateNote() {
        noteMap.put(2l, new Note(2l, "supermarket", "buy water"));
    }

    public void addNote() {
        noteMap.put(4l, new Note(4l, "evening", "go to bed"));
    }

    public Map<Long, Note> mapAll() {
        return noteMap;
    }


}


