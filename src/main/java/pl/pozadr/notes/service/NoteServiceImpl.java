package pl.pozadr.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pozadr.notes.model.Note;
import pl.pozadr.notes.repository.NoteRepo;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteRepo noteRepo;

    @Autowired
    public NoteServiceImpl(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    @Override
    public List<Note> getAllNotes() {
        return null;
    }
}
