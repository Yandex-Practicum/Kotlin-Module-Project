class Navigator {

 fun navigateMenu(renderable: Renderable){

    while (true) {
        println("Выберите действие:")
        for ((index, option) in renderable.listOfOptions.withIndex()) {
            println("${index + 1}. $option")
        }
        val choice = getNumInput()
        if (choice in 1..renderable.listOfOptions.size) {

        }
    }
 }

}