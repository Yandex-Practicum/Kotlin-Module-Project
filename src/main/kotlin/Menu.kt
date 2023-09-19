import java.util.Scanner

open class Menu<E>(
    val name: String?, //название архива/заметки (у списка архивов очевидно не будет)
    val menuLevelList: List<String>,
    val level: Int,
    val previousElement: Menu<E>?
) {
    var contentList: MutableList<Any?> =
        mutableListOf(null) //список элементов меню."0." по задумке всегда
    // будет отведён в консоли на создание нового элемента. Т.к. 0 мне не нужен - этим заодно и
    // индекс приравниваю к номеру опции, и инициализацую переменной делаю.

    fun run() {


        val command: Int  //сюда закинем номер комманды для передачи в select
        while (true) { //крутим вывод опций/ввод до тех пор пока не получим рабочий ввод
            if (previousElement == null) {
                println("\nОткрыт ${menuLevelList[0]}: \n")
            } else {
                println("\nОткрыт ${this.menuLevelList[this.level]} \"${this.name}\":\n")
            }//чтобы проще ориентироваться, показываем где мы

            if (this.menuLevelList.get(level) != this.menuLevelList.last()) {
                println("0. Создать элемент: ${menuLevelList.get(this.level + 1)}")
            }  //если мы не на последнем меню(заметки) - покажем опцию пополнить список текущего

            for (i in 1 until contentList.size) {
                println("$i. ${(this.contentList[i] as? Menu<*>)?.name}")
            } //выводим все элементы текущего меню

            if (this.previousElement == null) {
                println("${contentList.size}. Завершить программу")
            } else {
                println("${contentList.size}. Назад")
            }

            val input: String = Scanner(System.`in`).nextLine() //всё вывели, получаем ввод
            //и фильтруем его на наличие ошибок.Немного рефлексирую что не оформил в when, но мне то
            // String, то Int, то Int+условие нужно, было неудобно, сдался.
            if (input == "") {
                println("Ошибка: пустой ввод")
                continue
            }

            if (input.toIntOrNull() == null) {
                println("Ошибка: введено не число")
                continue
            }
            if ((input.toInt() > (contentList.size)) || (input.toInt() < 0)) {
                println(
                    "Ошибка: команды для данного номера не существует " +
                            "(число за пределами выведенных опций)"
                )
                continue
            }
            if (input.toInt() == 0 && this.menuLevelList.get(level) == this.menuLevelList.last()) {
                println("Ошибка: создание элемента недоступно для этого меню")
                continue
            }

            command = input.toInt()
            break
        }
        this.select(command)
    }

    fun select(number: Int) {
        when (number) {
            0 -> this.createNew()

            in 1..this.contentList.size - 1 -> {
                if (this.menuLevelList.get(level + 1) == this.menuLevelList.last()) {
                    println("\nНазвание: \"${(this.contentList[number] as? Menu<*>)?.name}\":")
                    println("${(this.contentList[number] as? Menu<*>)?.contentList}")
                    println()
                    this.run()
                } //если мы в списке заметок - печатем содержание
                else {
                    (this.contentList[number] as Menu<*>).run()
                }
            } //если нет
            // - запускаем след. меню

            this.contentList.size -> this.back()
        }
    }


    fun createNew() {
        if (this.menuLevelList.get(this.level) == this.menuLevelList.last()) {
            println(
                "Ошибка: команды для данного номера не существует " +
                        "(новый элемент создать нельзя)"
            )
            this.run()
        }

        val name: String
        while (true) {
            println("Создаётся ${this.menuLevelList.get(this.level + 1)}. Введите название:")
            val input: String = Scanner(System.`in`).nextLine()
            if (input == "") {
                println("Ошибка: пустой ввод")
                continue
            }
            name = input
            break
        } //крутим луп до ненулевого ввода для названия эелемента
        val newElement = Menu(name, this.menuLevelList, this.level + 1, this)
        this.contentList.add(newElement)
        if (this.menuLevelList.get(this.level + 1) == this.menuLevelList.last()) {//если ниже
            // по уровню уже не меню а финальные текстовые элементы
            println("Создаётся ${this.menuLevelList.get(this.level + 1)}. Введите содержание.")
            while (true) {
                val input2: String = Scanner(System.`in`).nextLine()
                if (input2 == "") { //отфильтровываем пустые заметки
                    println("Ошибка: пустой ввод")
                    continue
                }
                (this.contentList[this.contentList.size - 1] as? Menu<*>)?.contentList?.apply {
                    clear()
                    add(input2)
                } //побочка того что я оставил тип списка гибким Any
                break
            }
        }

        this.run()
    }

    fun back() {
        previousElement?.run()
        //т.к. метод не перезапускает run(), то программа завершится если уровня выше нет
    }
}
