package ui.console.exceptions

class CommandNotFoundException(command: Int): Exception("Команда $command не найдена")