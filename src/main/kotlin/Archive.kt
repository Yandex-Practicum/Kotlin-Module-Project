class Archive(
        private var header: String,
        private var notes: MutableList<Note>
        ) {

        fun getNotes(): MutableList<Note> {
                return  notes
        }

        override fun toString(): String {
                return header
        }
}