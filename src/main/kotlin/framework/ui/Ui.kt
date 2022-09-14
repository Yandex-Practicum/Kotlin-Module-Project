package main.kotlin.framework.ui

data class Ui(
    private val header: String?,
    private val message: String? = null,
    private val body: List<String>? = null,
    private val animationTime: Long = 0
) {
    fun draw() {
        clear()
        println()
        val maxValue = body?.maxOf { it.length } ?: 4
        printHeader(maxValue)
        printMessage(message)
        printBody()
        printBottom(maxValue, header)
    }

    private fun printMessage(message: String?) {
        message?.let {
            println(it)
        }
    }

    private fun printBottom(maxValue: Int, header: String?) {
        val size = header?.let { it.length + (maxValue / 2) * 2 } ?: (maxValue * 2)
        for (i in 1..size) print("*")
        println()
    }

    private fun printHeader(maxValue: Int) {
        header?.let {
            val size = it.length + (maxValue / 2) * 2
            for (i in 1..size) {
                Thread.sleep(animationTime)
                if (i <= maxValue / 2)
                    print("*")
                if (i == maxValue / 2 + 1) {
                    print(it)
                }
                if (i > (maxValue / 2) + it.length)
                    print("*")
            }
        } ?: repeat(maxValue * 2) {
            print("*")
        }
        println()
    }

    private fun printBody() {
        body?.forEachIndexed { index, menuLine ->
            println(" $index) $menuLine")
        }
    }

    private fun clear() {
        repeat(10000) {
            println("\b")
        }
    }
}
