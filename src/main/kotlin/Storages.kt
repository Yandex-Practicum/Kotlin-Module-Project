import java.util.*

open class Storage<T>(                                     // Хранилище
    val title : String,     // - Фраза - приглашение при входе в хранилище
    val unitName : String,  // - название единицы хранения в именительном падеже (архив, папка)
    val genName : String,   // - название единицы хранения в родительном падеже (архива, папки)
    val accName : String    // - название единицы хранения в винительном падеже (архив, папку)
    ) {
    val content: MutableMap<String, T> = mutableMapOf()   // Содержимое хранилища
    var keyName : String = ""                             // Имя-ключ выбраннного объекта хранения

    protected val scanner: Scanner = Scanner(System.`in`)

    public fun createStorageUnit(unit : T) {      // Создание объекта хранения
        val name : String = keyName
        if (content.containsKey(name))
            println("$unitName '$name' уже существует, не могу создать $accName с таким именем")
        else {
            content[name] = unit
            println("Добавляется $unitName '$name'")
        }
    }

    public fun selectStorageUnit() : Boolean {    // Проверка наличия объекта хранения
        val name : String = keyName
        if (content.containsKey(name)) {
            println("Выбиратся $unitName '$name'")
            return true
        }
        else {
            println("$unitName '$name' не существует, не могу выбрать $accName с таким именем")
            return false
        }
    }

    public fun getUnit() : T {                   // Выдача объекта хранения
        return content[keyName]!!
    }

    public fun actionMenu() : Int {             // Меню обработки действий пользователя
        val menuList : MutableMap<Int, String> = mutableMapOf()
        var line : Int
        var digitTest : Boolean
        var input : String

        while(true) {
            println()
            println(title)
            println("Введите число от 0 до ${content.size+1} ")
            println("0. Создать $accName")
            line = 1
            for (key in content.keys) {
                println("$line. Выбрать $accName $key")
                menuList[line] = key
                line++
            }
            println("$line. Выход")
            digitTest = scanner.hasNextInt()
            input = scanner.nextLine().trim()

            if (input.isEmpty())
                println("Вы ничего не ввели, вводить нужно числа от 0 до $line")
            else {
                if (!digitTest) {
                    println("Вы ввели $input")
                    println("Вы ввели не целое число. Вводить можно только целые числа от 0 до $line")
                }
                else {
                    when (val menuLine : Int = input.toInt()) {
                        0 -> {
                            println("Вы ввели 0 - Создать $accName")
                            keyName = inputKeyName("Введите имя $genName")
                            return 0
                        }
                        in 1 until line -> {
                            keyName = menuList[menuLine]!!
                            println("Вы ввели $menuLine  - Выбрать $accName $keyName")
                            return 1
                        }
                        line -> {
                            println("Вы ввели $line - Выход")
                            return 2
                        }
                        else ->
                            println("На экране нет введенного вами варианта, вводить нужно числа от 0 до $line")
                    }
                }
            }
        }
    }

    private fun inputKeyName(prompt : String) : String {       // Ввод имени-ключа объекта хранния
        var input : String
        while(true) {
            println(prompt)
            input = scanner.nextLine().trim()
            if (input.isEmpty())
                println("Имя не может быть пустым")
            else
                return input
        }
    }
}

// Шкаф для папок (архивов)
class BoxCase() : Storage<Archive>(
    title = "Создание и выбор архивов",
    unitName = "архив",
    genName = "архива",
    accName = "архив")

// Папка (архив) для заметок
class Archive() : Storage<Note>(
    title = "Создание и выбор заметок",
    unitName = "заметка",
    genName = "заметки",
    accName = "заметку")

// Заметка из строк
class Note() : Storage<String>(
    title = "Создание текста заметки",
    unitName = "строка",
    genName = "строки",
    accName = "строку")
{
    val text : MutableList<String> = mutableListOf()

    public fun createForEmpty(archiveName : String, noteName : String) {
        var input : String
        if (text.isEmpty()) {
            println("Заметка $noteName из архива $archiveName пустая")
            println(title)
            while(true) {
                println("Наберите заметку построчно. Для завершения ввода заметки введите пустую строку")
                input = scanner.nextLine().trimEnd()
                if (input.isEmpty()) break
                text.add(input)
            }
        }
    }

    public fun view(archiveName : String, noteName : String) {
        println("НАЗВАНИЕ АРХИВА: $archiveName")
        println("НАЗВАНИЕ ЗАМЕТКИ: $noteName")
        if (text.isEmpty())
            println("Заметка пустая")
        else {
            println("ТЕКСТ ЗАМЕТКИ:")
            for (line in text)
                println(line)
        }
    }
}
