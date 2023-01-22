fun main() {
    val arches = mutableListOf<Arch>()
    val navigator = Navigator(
        createArch = {
            arches.add(it)
        },
        getArches = { arches }
    )
    navigator.nextScreen(AllScreens.ARCH,null)
}

fun navigationInput2(title: String, navigation: List<String>, funbb: (Int) -> Unit) {
    println(title)
    navigation.forEachIndexed { index, s ->
        println("${index + 1} - $s")
    }
    val answer = readLine()
    val temp = answer?.trim()?.toIntOrNull()
    if (temp != null && temp <= navigation.count()) {
        //какая то функция
        funbb(temp)
    } else {
        if (temp == null){
            println("Ошибка, введите цифру")
        }else {
        println("Ошибка, такого номера нет, выберете из предложенного")
        }
        navigationInput2(title, navigation, funbb)
    }
}
