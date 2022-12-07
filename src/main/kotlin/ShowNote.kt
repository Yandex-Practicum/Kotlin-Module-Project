fun showNote(n:Int){
    while (true){
        val text = arhive[archiveName]!!.elementAt(n-1)
        println("Заметка $n.")
        println("Текст заметки: $text")
        println("0.Добавить текст")
        println("1.Назад")
        if(scanner.hasNextInt()){
            when(scanner.nextInt()){
                0 -> editNote(n-1)
                1 -> break
                else -> println("Данного числа нет повторите ввод")
            }
        }else {println("Неверный ввод.Вы ввели ${scanner.next()}.Введите число.")
            scanner.nextLine()}
    }
}