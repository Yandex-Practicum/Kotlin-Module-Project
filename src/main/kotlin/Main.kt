fun main(args: Array<String>) {
    println("Hello World!")
}
/*
Страницы
1 Выбор архива.
2 Создание архива.
3 Выбор заметки.
4 Создания заметки.
5 Экран заметки. На экране заметки должна быть возможность вывода текста заметки

Неправильный ввод:
    Если человек ввёл не цифру, то программа должна сказать ему, что следует вводить цифру, и ещё раз показать пункты меню.
    Если человек ввёл цифру, но такого элемента нет на экране, то программа должна сказать, что такой цифры нет, снова показать пункты меню и предложить
    ввести корректный символ



Критерии успешного выполнения задания:
    Есть меню с возможностью добавления и просмотра архивов.
    Есть меню с возможностью добавления и просмотра заметок.
    Есть возможность добавлять и просматривать текст заметок.
    !Не должно быть повторений одного и того же кода. Вся логика по считыванию ввода пользователя и вывода пунктов на экран должна переиспользовать один и тот же код.
    !Ошибочный ввод пользователя должен корректно обрабатываться.
    !Приложение не позволяет создавать меню или заметку без имени (с пустым именем).
    !Приложение не позволяет создавать заметку без содержания (с пустым текстом).
    !Из любого меню можно выйти и попасть на предыдущее меню или выйти из программы, если это просмотр архива.
    Приложение успешно компилируется и выполняется без ошибок.
    Весь код не написан в одном файле Main.
    Весь код приложения написан на Kotlin.

 Подсказки
Рекомендуем начать с самого первого меню — архивы. Затем переместить общую логику в отдельный класс и свериться с требованиями к заданию.
Далее оставшиеся меню будет написать намного легче.
Каждое меню советуем делать в отдельном файле, чтобы проще было ориентироваться.
Для переиспользования общего кода рекомендуем использовать отдельный класс, который содержит код:
    По выводу пунктов меню;
    По чтению пользовательского ввода;
    По выполнению определённых операций на выбор пункта меню.

 */