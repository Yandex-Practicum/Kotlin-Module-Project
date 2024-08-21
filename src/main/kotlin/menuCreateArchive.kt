import java.util.Scanner

fun menuCreateArchive(): Archive{
    while(true){
        println("Введите название архива:")
        val input = Scanner(System.`in`).nextLine()
        if (input.isBlank()) println("Пустое название архива недопустимо.")
        else {
            return Archive(input)
        }
    }
}
