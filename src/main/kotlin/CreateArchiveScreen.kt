class CreateArchiveScreen : Screen {
    override fun show(repo: Repository, input: InputReader): NavCommand {
        println("Создание архива")
        println("Введите название архива (0 — назад)")

        while (true) {
            val name = input.readLine("Название: ").trim()
            if (name == "0") return NavCommand.Pop
            if (name.isBlank()) {
                println("Название не может быть пустым. Попробуйте ещё раз.\n")
                continue
            }
            repo.archives.add(Archive(name))
            println("Архив \"$name\" создан.\n")
            return NavCommand.Pop
        }

    }
}