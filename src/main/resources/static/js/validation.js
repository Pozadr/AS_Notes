// Validate Edit Note
let editTitleError;
let editContentError;
function validateEditNote() {
    // title
    let titleEditValue = $('#titleEditNote').val();
    if (titleEditValue.length === 0) {
        $('#titleEditNoteMessage').show();
        editTitleError = true;
    } else {
        $('#titleEditNoteMessage').hide();
        editTitleError = false;
    }
    // content
    let contentEditValue = $('#contentEditNote').val();
    if (contentEditValue.length === 0) {
        $('#contentEditNoteMessage').show();
        editContentError = true;
    } else {
        $('#contentEditNoteMessage').hide();
        editContentError = false;
    }
    return !(editTitleError || editContentError);
}

// validate add Note
let addTitleError;
let addContentError;
function validateAddNote() {
    // title
    let titleAddValue = $('#titleAddNote').val();
    if (titleAddValue.length === 0) {
        $('#titleAddNoteMessage').show();
        addTitleError = true;
    } else {
        $('#titleAddNoteMessage').hide();
        addTitleError = false;
    }
    // content
    let contentAddValue = $('#contentAddNote').val();
    if (contentAddValue.length === 0) {
        $('#contentAddNoteMessage').show();
        addContentError = true;
    } else {
        $('#contentAddNoteMessage').hide();
        addContentError = false;
    }
    return !(addTitleError || addContentError);
}


// Submit edit Car
$('#submitEdit').click(function () {
    return validateEditNote();
});

// Submit add Car
$('#submitAdd').click(function () {
    return validateAddNote();
});


// toggleAddModal on click
$('#toggleAddModal').click(function () {
    $('#titleAddNoteMessage').hide();
    $('#contentAddNoteMessage').hide();
});

// toggleEditModal on click
$('#toggleEditModal').click(function () {
    $('#titleEditNoteMessage').hide();
    $('#contentAddNoteMessage').hide();
});