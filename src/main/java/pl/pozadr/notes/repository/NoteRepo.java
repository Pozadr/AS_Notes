package pl.pozadr.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.pozadr.notes.model.Note;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
        Optional<Note> findById(Long id);

        @Transactional
        @Modifying
        @Query(value = "UPDATE notes SET title =:title, content =:content, date =:date WHERE id =:id"
                , nativeQuery = true)
        void updateNoteById(@Param("id") Long id,
                            @Param("title") String title,
                            @Param("content") String content,
                            @Param("date")LocalDate date);
}
