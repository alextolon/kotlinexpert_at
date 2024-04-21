data class Note (val title: String, val description: String, val type:Type) {
    enum class Type {TEXT, AUDIO}
}

fun getNotes(callback: (List<Note>) -> Unit) {
    // Esto bloquea el hilo principal de ejecución
    Thread.sleep(2000)
    // por lo que esto sería una petición a un hilo secundario
    val notes = (0..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 2 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )
    }
    callback(notes)
}

