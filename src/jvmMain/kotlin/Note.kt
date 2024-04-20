data class Note (val title: String, val description: String, val type:Type) {
    enum class Type {TEXT, AUDIO}
}

fun getNotes(): List<Note> = (1..10).map { Note(
    "Title $it",
    "Description $it",
    if (it % 2 == 0) Note.Type.AUDIO else Note.Type.TEXT
)
}

