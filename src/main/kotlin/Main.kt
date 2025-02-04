import data.Storage
import navigation.Navigator
import screen.ArchiveScreen


fun main(args: Array<String>) {
    Navigator.push(ArchiveScreen())
    Storage.sc.close()
}