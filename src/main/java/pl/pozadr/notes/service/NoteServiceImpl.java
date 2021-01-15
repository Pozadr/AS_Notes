package pl.pozadr.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pozadr.notes.model.Note;
import pl.pozadr.notes.repository.NoteRepo;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepo noteRepo;

    @Autowired
    public NoteServiceImpl(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        try {
            Optional<Note> noteById = noteRepo.findById(id);
            if (noteById.isPresent())
                return noteById.get();

        } catch (EntityNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return new Note();
    }

    @Override
    public void editNote(Note editedNote) {
        noteRepo.updateNoteById(editedNote.getId(), editedNote.getTitle(), editedNote.getContent(),
                LocalDate.now());
    }

    @Override
    public void deleteNote(Long id) {
        noteRepo.deleteById(id);
    }

    @Override
    public void saveNote(Note newNote) {
        newNote.setDate(LocalDate.now());
        noteRepo.flush();
        noteRepo.save(newNote);
    }
}
