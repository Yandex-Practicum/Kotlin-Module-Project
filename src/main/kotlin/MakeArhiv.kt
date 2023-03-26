import java.util.Scanner

//class inArhive {


    //val arhivArrayList: MutableList<String> = ArrayList()

    //fun spiSka(

    //) {
        //arhivArrayList.add(scanner.toString())
    //}

//}

fun makeArhive(

) {
    println("Список архивов:")
    println("0. Создать архив")
    println("1. Уже созданный архив")
    println("2. Выход из программы")
    println("Выберите пункт меню")
    logika()
}

class Card(val numbers: Map<String, MutableSet<String>>)

class inArhive(val name: String) {
    val card: Card = spiSka()
    private fun spiSka(): Card {
        val numbers: Set<String> = generateNumbers()
        val iterator: Iterator<Int> = numbers.iterator()
        var currentLine = 1
        val cardNumbers: MutableMap<String, MutableSet<String>> = mutableMapOf(
            1 to mutableSetOf(),
            2 to mutableSetOf(),
            3 to mutableSetOf()
        )
        while (iterator.hasNext()) {
            val number = iterator.next()
            cardNumbers[currentLine]?.add(number)
            if (currentLine < 3) {
                currentLine++
            } else {
                currentLine = 1
            }
        }
        return Card(cardNumbers)
    }


