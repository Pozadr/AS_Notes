package pl.pozadr.notes.service;

import pl.pozadr.notes.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    void editNote(Note editedNote);
    void deleteNote(Long id);
    void saveNote(Note newNote);
}
