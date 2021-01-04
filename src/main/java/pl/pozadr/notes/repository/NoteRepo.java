package pl.pozadr.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pozadr.notes.model.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {

}
