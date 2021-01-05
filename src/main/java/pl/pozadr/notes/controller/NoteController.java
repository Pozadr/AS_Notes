package pl.pozadr.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.pozadr.notes.model.Note;
import pl.pozadr.notes.service.NoteService;

import java.time.LocalDate;


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
    public Note getOneNews(Long id) {
        return noteService.getNoteById(id);
    }

    @PostMapping("/add-note")
    public String addCar(@Validated Note newNote) {
        noteService.saveNote(new Note(newNote.getTitle(), newNote.getContent(), LocalDate.now()));
        return "redirect:/notes-home";
    }

    @RequestMapping(value = "/edit-note", method = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
    public String editNote(@Validated Note editedNote) {
        noteService.editNote(new Note(editedNote.getId(), editedNote.getTitle(), editedNote.getContent(),
                LocalDate.now()));
        return "redirect:/notes-home";
    }

    @GetMapping("/delete-note")
    public String deleteNote(Long id) {
        noteService.deleteNote(id);
        return "redirect:/notes-home";
    }
}
