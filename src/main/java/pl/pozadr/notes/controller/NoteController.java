package pl.pozadr.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.pozadr.notes.model.Note;
import pl.pozadr.notes.service.NoteService;

import java.util.List;

@Controller
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes-home")
    public String getAllNotes(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "notes-home";
    }
}
