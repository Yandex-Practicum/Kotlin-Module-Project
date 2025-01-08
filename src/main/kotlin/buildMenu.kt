fun <T> buildMenu(
    title: String,
    items: List<T>,
    itemDescription: (T) -> String,
    onSelect: (T) -> Unit,
    additionalOptions: List<Pair<String, () -> Unit>> = emptyList())
{
    val menu = Menu(title)

    items.forEach { item ->

        menu.addOption(itemDescription(item)) { onSelect(item) }
    }

    additionalOptions.forEach { (description, action) ->
        menu.addOption(description, action)}

    menu.show()
}
