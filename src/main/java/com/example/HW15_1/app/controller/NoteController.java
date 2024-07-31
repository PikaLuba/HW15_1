package com.example.HW15_1.app.controller;

import com.example.HW15_1.app.model.Note;
import com.example.HW15_1.app.model.NoteDao;
import com.example.HW15_1.app.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/note")
public class NoteController {

   @GetMapping("/list")  // mapAllnoteMaps
   public String mapAll(ModelMap modelMap) {
        NoteService noteService = new NoteService(new NoteDao());
        Map<Long, Note> noteMaps = noteService.mapAll();

        modelMap.addAttribute("noteMaps", noteMaps);

        return "page_list";
    }

    @GetMapping("/edit/{id}")
    public String findById(@PathVariable Long id, ModelMap modelMap) {
        NoteService noteService = new NoteService(new NoteDao());
        Note note = noteService.getById(id);

        modelMap.addAttribute("note", note);
        return "page_edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, ModelMap modelMap) {
            NoteService noteService = new NoteService(new NoteDao());
            Note note = noteService.deleteById(id);

            modelMap.addAttribute("note", note);
            return "page_delete";

    }
}

