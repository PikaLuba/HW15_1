package com.example.HW15_1.app.service;

import com.example.HW15_1.app.exeption.BadRequestException;
import com.example.HW15_1.app.model.Note;
import com.example.HW15_1.app.model.NoteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteDao noteDao;

    public Note getById(Long id) {
        return noteDao.getByID(id).orElseThrow(BadRequestException::new);
    }

    public Note deleteById(Long id) {
        return noteDao.deleteById(id).orElseThrow(BadRequestException::new);
    }

    public Map<Long, Note> mapAll() {
        return noteDao.mapAll();
    }

    public void create() {
        noteDao.addNote();
    }

    public void update() {
        noteDao.updateNote();
    }
}
