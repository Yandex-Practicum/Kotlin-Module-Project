class Notes(var titel: String, var text: String) {

    fun continueNote(newText: String) {
        text = text + newText
    }
}