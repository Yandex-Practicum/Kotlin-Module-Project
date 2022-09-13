object Style {
    const val WIDTH_SCREEN = 60
    val SPACE: String
        get() = setIndention(WIDTH_SCREEN / 20)
    const val ITEM_BORDER = "\""
    const val ITEM_FOLDER_MARKER = "[\u2263] "
    const val ITEM_NOTE_MARKER = "\u2338 "
    const val LINE_SYMBOL = "-"

    fun printSampleInLineFormat(sample: String, isSpace: Boolean) {
        val countLeft: Int =
            if (sample.count() < WIDTH_SCREEN) (WIDTH_SCREEN - sample.count()) / 2 else 0
        val space = if (isSpace) " " else ""
        var printString = ""
        if (countLeft > 0) {
            for (i in 1..countLeft - 1) printString = printString + LINE_SYMBOL
            printString = printString + space + sample + space
            for (i in 1..(WIDTH_SCREEN - printString.count())) printString =
                printString + LINE_SYMBOL
        } else {
            println(sample)
            return
        }
        println(printString)
    }

    fun setIndention(count: Int): String {
        if (count < 1) return ""
        var sample = ""
        for (i in 1..count) sample = "$sample "
        return sample
    }
}