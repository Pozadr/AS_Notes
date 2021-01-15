package pl.pozadr.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.pozadr.notes.model.Note;
import pl.pozadr.notes.service.NoteService;

import java.util.Optional;


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

    @GetMapping("/get-note-by-id")
    @ResponseBody
    public ResponseEntity<Note> getOneNews(Long id) {
        Optional<Note> noteOpt = noteService.getNoteById(id);
        return noteOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add-note")
    public String addCar(@Validated Note newNote) {
        noteService.saveNote(new Note(newNote.getTitle(), newNote.getContent()));
        return "redirect:/notes-home";
    }

    @RequestMapping(value = "/edit-note", method = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
    public String editNote(@Validated Note editedNote) {
        noteService.editNote(new Note(editedNote.getId(), editedNote.getTitle(), editedNote.getContent()));
        return "redirect:/notes-home";
    }

    @GetMapping("/delete-note")
    public String deleteNote(Long id) {
        noteService.deleteNote(id);
        return "redirect:/notes-home";
    }
}
