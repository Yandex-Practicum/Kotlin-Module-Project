import kotlin.system.exitProcess
/*

// option 1
import kotlin.system.exitProcess

class NoteApp {
    private val archives = mutableListOf<ArchiveItem>()

    fun start() {
        while (true) {
            when (showMenu()) {
                1 -> createArchive()
                2 -> viewArchives()
                3 -> searchNotes()
                4 -> {
                    println("Exiting the program.")
                    exitProcess(0)
                }
                0 -> println("Going back to the main menu.")
                null -> println("No entry done. Please try again.")
                else -> println("Invalid option. Please try again.")
            }
        }
    }

    private fun showMenu(): Int? {
        return showMenu(
            "Main Menu",
            listOf("Create Archive", "View Archives", "Search Notes", "Exit")
        )
    }

    private fun createArchive() {
        while (true) {
            val name = readInputString("Enter archive name (or press Enter to go back): ")
            if (name.isBlank()) {
                println("Warning: You entered an empty value. Going back to the main menu.")
                return
            }

            if (archives.any { it.title.equals(name, ignoreCase = true) }) {
                println("An archive with the name '$name' already exists. Please choose a different name.")
                continue
            }

            archives.add(ArchiveItem(name))
            println("Archive '$name' created successfully.")
            return
        }
    }

    private fun viewArchives() {
        if (archives.isEmpty()) {
            println("No archives available.")
            return
        }
        manageList(archives) { archive -> manageArchive(archive) }
    }

    private fun manageArchive(archive: ArchiveItem) {
        while (true) {
            when (showMenuForArchive(archive)) {
                1 -> addNoteToArchive(archive)
                2 -> viewManageableItems(archive.notes.map { NoteItem(it.title, it.content) }, "notes")
                0 -> return
                else -> println("Invalid option. Please try again.")
            }
        }
    }

    private fun showMenuForArchive(archive: ArchiveItem): Int? {
        return showMenu(
            "Managing Archive '${archive.title}'",
            listOf("Add Note", "View Notes")
        )
    }

    private fun addNoteToArchive(archive: ArchiveItem) {
        if (promptForTitleAndContent { title, content ->
                if (archive.notes.any { it.title.equals(title, ignoreCase = true) }) {
                    println("A note with the title '$title' already exists. Please use a different title.")
                } else {
                    archive.notes.add(NoteItem(title, content))
                    println("Note '$title' added to archive '${archive.title}' successfully.")
                }
            }) return
    }

    private fun <T : ManageableItem> viewManageableItems(items: List<T>, type: String) {
        if (items.isEmpty()) {
            println("No $type found.")
            return
        }

        println("\n====================")
        println("List of $type:")
        println("====================")
        items.forEach { item ->
            println("Title: ${item.title}")
            if (item is NoteItem) {
                println("Content: ${item.content}")
            }
            println()
        }
        println("====================")
    }

    private fun searchNotes() {
        val keyword = readInputString("Enter keyword to search (or press Enter to go back): ")
        if (keyword.isBlank()) {
            println("Warning: You entered an empty value. Going back to the main menu.")
            return
        }

        val foundNotes = archives.flatMap { it.notes }
            .filter { it.title.contains(keyword, ignoreCase = true) || it.content.contains(keyword, ignoreCase = true) }

        if (foundNotes.isEmpty()) {
            println("No notes found with keyword '$keyword'.")
        } else {
            println("\n====================")
            println("Found Notes:")
            println("====================")
            foundNotes.forEach { note ->
                println("Title: ${note.title}\nContent: ${note.content}\n")
            }
            println("====================")
        }
    }

    private fun manageList(items: List<ArchiveItem>, action: (ArchiveItem) -> Unit) {
        while (true) {
            println("\n====================")
            println("      Archives List    ")
            println("====================")
            items.forEachIndexed { index, item -> println("${index + 1}. ${item.title}") }
            println("0. Back")
            println("====================")

            when (val choice = readInput("Select an item to manage (0 to cancel): ", items.size)) {
                null -> println("Invalid input. Please try again.")
                0 -> return
                in 1..items.size -> action(items[choice - 1])
                else -> println("Invalid option. Please try again.")
            }
        }
    }

    private fun showMenu(title: String, options: List<String>): Int? {
        println("\n====================")
        println("       $title     ")
        println("====================")
        options.forEachIndexed { index, option -> println("${index + 1}. $option") }
        println("0. Back")
        println("====================")
        return readInput("Choose an option: ", options.size)
    }

    private fun promptForTitleAndContent(action: (String, String) -> Unit): Boolean {
        val title = readInputString("Enter title (or press Enter to go back): ")
        if (title.isBlank()) {
            println("Warning: You entered an empty value.")
            return false
        }

        val content = readInputString("Enter content (or press Enter to go back): ")
        if (content.isBlank()) {
            println("Warning: You entered an empty value.")
            return false
    private fun readInputString(prompt: String): String {
        print(prompt)
        return readlnOrNull() ?: ""
    }

    private fun readInput(prompt: String, maxOption: Int): Int? {
        while (true) {
            val userInput = readInputString(prompt)

            if (userInput.isBlank()) {
                return null
            }

            try {
                val input = userInput.toInt()
                if (input in 0..maxOption) {
                    return input
                } else {
                    println("Warning: Invalid option. Please enter a number between 1 and $maxOption.")
                }
            } catch (e: NumberFormatException) {
                println("Warning: Invalid input. Please enter a valid number between 1 and $maxOption.")
            }
        }
    }
}

// option 2 using inline and reified and local exit via return@promptForTitleAndContent
class NoteApp {
    private val archives = mutableListOf<ArchiveItem>()

    fun start() {
        while (true) {
            when (showMenu()) {
                1 -> createArchive()
                2 -> viewArchives()
                3 -> searchNotes()
                4 -> {
                    println("Exiting the program.")
                    exitProcess(0)
                }
                0 -> println("Going back to the main menu.")
                null -> println("No entry done. Please try again.")
                else -> println("Invalid option. Please try again.")
            }
        }
    }

    private fun showMenu(): Int? {
        return showMenu("Main Menu", listOf("Create Archive", "View Archives", "Search Notes", "Exit"))
    }

    private fun createArchive() {
        while (true) {
            val name = readInputString("Enter archive name (or press Enter to go back): ")
            if (name.isBlank()) {
                println("Warning: You entered an empty value. Going back to the main menu.")
                return
            }

            if (archives.any { it.title.equals(name, ignoreCase = true) }) {
                println("An archive with the name '$name' already exists. Please choose a different name.")
                continue
            }

            archives.add(ArchiveItem(name))
            println("Archive '$name' created successfully.")
            return
        }
    }

    private fun viewArchives() {
        if (archives.isEmpty()) {
            println("No archives available.")
            return
        }
        manageList(archives) { archive -> manageArchive(archive) }
    }

    private fun manageArchive(archive: ArchiveItem) {
        while (true) {
            when (showMenuForArchive(archive)) {
                1 -> addNoteToArchive(archive)
                2 -> viewManageableItems(archive.notes.map { NoteItem(it.title, it.content) }, "notes")
                0 -> return
                else -> println("Invalid option. Please try again.")
            }
        }
    }

    private fun showMenuForArchive(archive: ArchiveItem): Int? {
        return showMenu("Managing Archive '${archive.title}'", listOf("Add Note", "View Notes"))
    }

    private fun addNoteToArchive(archive: ArchiveItem) {
        if (promptForTitleAndContent { title, content ->
                if (checkDuplicateNoteTitle(archive, title)) return@promptForTitleAndContent
                archive.notes.add(NoteItem(title, content))
                println("Note '$title' added to archive '${archive.title}' successfully.")
            }) return
    }

    private fun checkDuplicateNoteTitle(archive: ArchiveItem, title: String): Boolean {
        return if (archive.notes.any { it.title.equals(title, ignoreCase = true) }) {
            println("A note with the title '$title' already exists. Please use a different title.")
            true
        } else {
            false
        }
    }

    private inline fun <reified T : ManageableItem> viewManageableItems(items: List<T>, type: String) {
        if (items.isEmpty()) {
            println("No $type found.")
            return
        }

        println("\n====================")
        println("List of $type:")
        println("====================")
        items.forEach { item ->
            println("Title: ${item.title}")
            if (item is NoteItem) {
                println("Content: ${item.content}")
            }
            println()
        }
        println("====================")
    }

    private fun searchNotes() {
        val keyword = readInputString("Enter keyword to search (or press Enter to go back): ")
        if (keyword.isBlank()) {
            println("Warning: You entered an empty value. Going back to the main menu.")
            return
        }

        val foundNotes = archives.flatMap { it.notes }
            .filter { it.title.contains(keyword, ignoreCase = true) || it.content.contains(keyword, ignoreCase = true) }

        if (foundNotes.isEmpty()) {
            println("No notes found with keyword '$keyword'.")
        } else {
            println("\n====================")
            println("Found Notes:")
            println("====================")
            foundNotes.forEach { note ->
                println("Title: ${note.title}\nContent: ${note.content}\n")
            }
            println("====================")
        }
    }

    private fun manageList(items: List<ArchiveItem>, action: (ArchiveItem) -> Unit) {
        while (true) {
            println("\n====================")
            println("      Archives List    ")
            println("====================")
            items.forEachIndexed { index, item -> println("${index + 1}. ${item.title}") }
            println("0. Back")
            println("====================")

            when (val choice = readInput("Select an item to manage (0 to cancel): ", items.size)) {
                null -> println("Invalid input. Please try again.")
                0 -> return
                in 1..items.size -> action(items[choice - 1])
                else -> println("Invalid option. Please try again.")
            }
        }
    }

    private fun showMenu(title: String, options: List<String>): Int? {
        println("\n====================")
        println("       $title     ")
        println("====================")
        options.forEachIndexed { index, option -> println("${index + 1}. $option") }
        println("0. Back") // Оставляем только один вариант возврата
        println("====================")
        return readInput("Choose an option: ", options.size)
    }

    private fun promptForTitleAndContent(action: (String, String) -> Unit): Boolean {
        val title = readInputString("Enter title (or press Enter to go back): ")
        if (checkEmptyOrNull(title, "You entered an empty title")) return false

        val content = readInputString("Enter content (or press Enter to go back): ")
        if (checkEmptyOrNull(content, "You entered an empty content")) return false

        action(title, content)
        return true
    }

    private fun checkEmptyOrNull(value: String, message: String): Boolean {
        if (value.isBlank()) {
            println("Warning: $message.")
            return true
        }
        return false
    }

    private fun readInputString(prompt: String): String {
        print(prompt)
        return readlnOrNull() ?: ""
    }

    private fun readInput(prompt: String, maxOption: Int): Int? {
        while (true) {
            val userInput = readInputString(prompt)

            if (userInput.isBlank()) {
                return null
            }

            try {
                val input = userInput.toInt()
                if (input in 0..maxOption) {
                    return input
                } else {
                    println("Warning: Invalid option. Please enter a number between 1 and $maxOption.")
                }
            } catch (e: NumberFormatException) {
                println("Warning: Invalid input. Please enter a valid number between 1 and $maxOption.")
            }
        }
    }
}

// option 3 using recursion

class NoteApp {
    private val archives = mutableListOf<ArchiveItem>()

    fun start() {
        handleMainMenu()
    }

    private fun handleMainMenu() {
        when (showMenu()) {
            1 -> createArchive().also { handleMainMenu() }
            2 -> viewArchives().also { handleMainMenu() }
            3 -> searchNotes().also { handleMainMenu() }
            4 -> {
                println("Exiting the program.")
                exitProcess(0)
            }
            0 -> println("Going back to the main menu.").also { handleMainMenu() }
            null -> println("No entry done. Please try again.").also { handleMainMenu() }
            else -> println("Invalid option. Please try again.").also { handleMainMenu() }
        }
    }

    private fun showMenu(): Int? {
        return showMenu("Main Menu", listOf("Create Archive", "View Archives", "Search Notes", "Exit"))
    }

    private fun createArchive() {
        val name = readInputString("Enter archive name (or press Enter to go back): ")
        if (name.isBlank()) {
            println("Warning: You entered an empty value. Going back to the main menu.")
            return
        }

        if (archives.any { it.title.equals(name, ignoreCase = true) }) {
            println("An archive with the name '$name' already exists. Please choose a different name.")
            return createArchive()  // Повторный вызов для ввода
        }

        archives.add(ArchiveItem(name))
        println("Archive '$name' created successfully.")
    }

    private fun viewArchives() {
        if (archives.isEmpty()) {
            println("No archives available.")
            return
        }
        manageList(archives) { archive -> manageArchive(archive) }
    }

    private fun manageArchive(archive: ArchiveItem) {
        when (showMenuForArchive(archive)) {
            1 -> addNoteToArchive(archive).also { manageArchive(archive) }
            2 -> viewManageableItems(archive.notes.map { NoteItem(it.title, it.content) }, "notes").also { manageArchive(archive) }
            0 -> return
            else -> println("Invalid option. Please try again.").also { manageArchive(archive) }
        }
    }

    private fun showMenuForArchive(archive: ArchiveItem): Int? {
        return showMenu("Managing Archive '${archive.title}'", listOf("Add Note", "View Notes"))
    }

    private fun addNoteToArchive(archive: ArchiveItem) {
        if (promptForTitleAndContent { title, content ->
                if (checkDuplicateNoteTitle(archive, title)) return@promptForTitleAndContent
                archive.notes.add(NoteItem(title, content))
                println("Note '$title' added to archive '${archive.title}' successfully.")
            }) return
    }

    private fun checkDuplicateNoteTitle(archive: ArchiveItem, title: String): Boolean {
        return if (archive.notes.any { it.title.equals(title, ignoreCase = true) }) {
            println("A note with the title '$title' already exists. Please use a different title.")
            true
        } else {
            false
        }
    }

    private inline fun <reified T : ManageableItem> viewManageableItems(items: List<T>, type: String) {
        if (items.isEmpty()) {
            println("No $type found.")
            return
        }

        println("\n====================")
        println("List of $type:")
        println("====================")
        items.forEach { item ->
            println("Title: ${item.title}")
            if (item is NoteItem) {
                println("Content: ${item.content}")
            }
            println()
        }
        println("====================")
    }

    private fun searchNotes() {
        val keyword = readInputString("Enter keyword to search (or press Enter to go back): ")
        if (keyword.isBlank()) {
            println("Warning: You entered an empty value. Going back to the main menu.")
            return
        }

        val foundNotes = archives.flatMap { it.notes }
            .filter { it.title.contains(keyword, ignoreCase = true) || it.content.contains(keyword, ignoreCase = true) }

        if (foundNotes.isEmpty()) {
            println("No notes found with keyword '$keyword'.")
        } else {
            println("\n====================")
            println("Found Notes:")
            println("====================")
            foundNotes.forEach { note ->
                println("Title: ${note.title}\nContent: ${note.content}\n")
            }
            println("====================")
        }
    }

    private fun manageList(items: List<ArchiveItem>, action: (ArchiveItem) -> Unit) {
        println("\n====================")
        println("      Archives List    ")
        println("====================")
        items.forEachIndexed { index, item -> println("${index + 1}. ${item.title}") }
        println("0. Back")
        println("====================")

        when (val choice = readInput("Select an item to manage (0 to cancel): ", items.size)) {
            null -> println("Invalid input. Please try again.").also { manageList(items, action) }
            0 -> return
            in 1..items.size -> action(items[choice - 1]).also { manageList(items, action) }
            else -> println("Invalid option. Please try again.").also { manageList(items, action) }
        }
    }

    private fun showMenu(title: String, options: List<String>): Int? {
        println("\n====================")
        println("       $title     ")
        println("====================")
        options.forEachIndexed { index, option -> println("${index + 1}. $option") }
        println("0. Back")
        println("====================")
        return readInput("Choose an option: ", options.size)
    }

    private fun promptForTitleAndContent(action: (String, String) -> Unit): Boolean {
        val title = readInputString("Enter title (or press Enter to go back): ")
        if (checkEmptyOrNull(title, "You entered an empty title")) return false

        val content = readInputString("Enter content (or press Enter to go back): ")
        if (checkEmptyOrNull(content, "You entered an empty content")) return false

        action(title, content)
        return true
    }

    private fun checkEmptyOrNull(value: String, message: String): Boolean {
        if (value.isBlank()) {
            println("Warning: $message.")
            return true
        }
        return false
    }

    private fun readInputString(prompt: String): String {
        print(prompt)
        return readlnOrNull() ?: ""
    }

    private fun readInput(prompt: String, maxOption: Int): Int? {
        val userInput = readInputString(prompt)

        if (userInput.isBlank()) {
            return null
        }

        return try {
            val input = userInput.toInt()
            if (input in 0..maxOption) {
                input
            } else {
                println("Warning: Invalid option. Please enter a number between 1 and $maxOption.")
                readInput(prompt, maxOption)
            }
        } catch (e: NumberFormatException) {
            println("Warning: Invalid input. Please enter a valid number between 1 and $maxOption.")
            readInput(prompt, maxOption)
        }
    }
}

 */
// option 4 tail rec and while back
class NoteApp {
    private val archives = mutableListOf<ArchiveItem>()

    fun start() {
        handleMainMenu()
    }

    private fun handleMainMenu() {
        while (true) {
            when (showMenu()) {
                1 -> createArchive()
                2 -> viewArchives()
                3 -> searchNotes()
                4 -> {
                    println("Exiting the program.")
                    exitProcess(0)
                }
                0 -> println("Going back to the main menu.")
                null -> println("No entry done. Please try again.")
                else -> println("Invalid option. Please try again.")
            }
        }
    }

    private fun showMenu(): Int? {
        return showMenu("Main Menu", listOf("Create Archive", "View Archives", "Search Notes", "Exit"))
    }

    private fun createArchive() {
        while (true) {
            val name = readInputString("Enter archive name (or press Enter to go back): ")
            if (name.isBlank()) {
                println("Warning: You entered an empty value. Going back to the main menu.")
                return
            }

            if (archives.any { it.title.equals(name, ignoreCase = true) }) {
                println("An archive with the name '$name' already exists. Please choose a different name.")
            } else {
                archives.add(ArchiveItem(name))
                println("Archive '$name' created successfully.")
                return
            }
        }
    }

    private fun viewArchives() {
        if (archives.isEmpty()) {
            println("No archives available.")
            return
        }
        manageList(archives) { archive -> manageArchive(archive) }
    }

    private tailrec fun manageArchive(archive: ArchiveItem) {
        val choice = showMenuForArchive(archive)
        when (choice) {
            1 -> {
                addNoteToArchive(archive)
                manageArchive(archive) // tail
            }
            2 -> {
                viewManageableItems(archive.notes.map { NoteItem(it.title, it.content) }, "notes")
                manageArchive(archive) // tail
            }
            0 -> return  // return to list of archives
            else -> {
                println("Invalid option. Please try again.")
                manageArchive(archive) // tail
            }
        }
    }

    private fun showMenuForArchive(archive: ArchiveItem): Int? {
        return showMenu("Managing Archive '${archive.title}'", listOf("Add Note", "View Notes"))
    }

    private fun addNoteToArchive(archive: ArchiveItem) {
        if (promptForTitleAndContent { title, content ->
                if (checkDuplicateNoteTitle(archive, title)) return@promptForTitleAndContent
                archive.notes.add(NoteItem(title, content))
                println("Note '$title' added to archive '${archive.title}' successfully.")
            }) return
    }

    private fun checkDuplicateNoteTitle(archive: ArchiveItem, title: String): Boolean {
        return if (archive.notes.any { it.title.equals(title, ignoreCase = true) }) {
            println("A note with the title '$title' already exists. Please use a different title.")
            true
        } else {
            false
        }
    }

    private inline fun <reified T : ManageableItem> viewManageableItems(items: List<T>, type: String) {
        if (items.isEmpty()) {
            println("No $type found.")
            return
        }

        println("\n====================")
        println("List of $type:")
        println("====================")
        items.forEach { item ->
            println("Title: ${item.title}")
            if (item is NoteItem) {
                println("Content: ${item.content}")
            }
            println()
        }
        println("====================")
    }

    private fun searchNotes() {
        val keyword = readInputString("Enter keyword to search (or press Enter to go back): ")
        if (keyword.isBlank()) {
            println("Warning: You entered an empty value. Going back to the main menu.")
            return
        }

        val foundNotes = archives.flatMap { it.notes }
            .filter { it.title.contains(keyword, ignoreCase = true) || it.content.contains(keyword, ignoreCase = true) }

        if (foundNotes.isEmpty()) {
            println("No notes found with keyword '$keyword'.")
        } else {
            println("\n====================")
            println("Found Notes:")
            println("====================")
            foundNotes.forEach { note ->
                println("Title: ${note.title}\nContent: ${note.content}\n")
            }
            println("====================")
        }
    }

    private fun manageList(items: List<ArchiveItem>, action: (ArchiveItem) -> Unit) {
        while (true) {
            println("\n====================")
            println("      Archives List    ")
            println("====================")
            items.forEachIndexed { index, item -> println("${index + 1}. ${item.title}") }
            println("0. Back")
            println("====================")

            when (val choice = readInput("Select an item to manage (0 to cancel): ", items.size)) {
                null -> println("Invalid input. Please try again.")
                0 -> return
                in 1..items.size -> {
                    action(items[choice - 1])
                }
                else -> println("Invalid option. Please try again.")
            }
        }
    }

    private fun showMenu(title: String, options: List<String>): Int? {
        println("\n====================")
        println("       $title     ")
        println("====================")
        options.forEachIndexed { index, option -> println("${index + 1}. $option") }
        println("0. Back")
        println("====================")
        return readInput("Choose an option: ", options.size)
    }

    private fun promptForTitleAndContent(action: (String, String) -> Unit): Boolean {
        val title = readInputString("Enter title (or press Enter to go back): ")
        if (checkEmptyOrNull(title, "You entered an empty title")) return false

        val content = readInputString("Enter content (or press Enter to go back): ")
        if (checkEmptyOrNull(content, "You entered an empty content")) return false

        action(title, content)
        return true
    }

    private fun checkEmptyOrNull(value: String, message: String): Boolean {
        if (value.isBlank()) {
            println("Warning: $message.")
            return true
        }
        return false
    }

    private fun readInputString(prompt: String): String {
        print(prompt)
        return readlnOrNull() ?: ""
    }

    private fun readInput(prompt: String, maxOption: Int): Int? {
        val userInput = readInputString(prompt)

        if (userInput.isBlank()) {
            return null
        }

        return try {
            val input = userInput.toInt()
            if (input in 0..maxOption) {
                input
            } else {
                println("Warning: Invalid option. Please enter a number between 1 and $maxOption.")
                readInput(prompt, maxOption)
            }
        } catch (e: NumberFormatException) {
            println("Warning: Invalid input. Please enter a valid number between 1 and $maxOption.")
            readInput(prompt, maxOption)
        }
    }
}