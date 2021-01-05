$(document).ready(function () {
    $('.card-body .editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (note, status) {
            $('#idEditNote').val(note.id);
            $('#titleEditNote').val(note.title);
            $('#contentEditNote').val(note.content);
        });

        $('#titleEditNoteMessage').hide();
        $('#contentEditNoteMessage').hide();

        $('#editModal').modal();
    });

    $('.card-body .deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #idDelete').attr('href', href);
        $('#deleteModal').modal();
    });

});
