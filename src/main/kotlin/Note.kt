data class Note(val noteName: String, val noteText: String){
    override fun toString(): String{
        return "noteName = `${this.noteName}` noteText = ${this.noteText}"
    }
    }

