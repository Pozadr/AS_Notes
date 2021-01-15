package pl.pozadr.notes.service;

import pl.pozadr.notes.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<Note> getAllNotes();
    Optional<Note> getNoteById(Long id);
    void editNote(Note editedNote);
    void deleteNote(Long id);
    void saveNote(Note newNote);
}
