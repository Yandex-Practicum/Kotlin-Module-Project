import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

open class MenuObject<T> {

    open var FIRST = ""
    open var LAST = "";

    var collection: ArrayList<T> = ArrayList()
    get() = field;

    fun createMenu(){

        val hs: HashMap<Int,String> = HashMap();

        hs.put(0,FIRST);

        var iterator: Int = 1

        for (element in collection){

            hs.put(iterator,element.toString())
            iterator++

        }

        hs.put(iterator,LAST);

        executeCommand(showMenu(hs),hs)

    }

    fun showMenu(hs: HashMap<Int,String>): Int{

        for (menu in hs){

            println("${menu.key} : ${menu.value}" )

        }

        var input = 0
        while (true){
            println("Введите команду")
            val sc = Scanner(System.`in`)
            try {
                input = sc.nextInt()

                if(!hs.containsKey(input)){

                    println("Несуществующая команда. Повторите ввод")
                    continue

                }

            } catch (e: InputMismatchException){
                println("Неправильный ввод. Ожидается цифра")
                continue
            }

            return input

        }


    }

    // для наследования
    open fun executeCommand(index: Int, hs: HashMap<Int,String>){

    }

}