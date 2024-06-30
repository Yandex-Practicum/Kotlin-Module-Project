fun main () {

    val crystalOre = 7
    val ironOre = 11
    val buff = 20

    val bonusCrystalOre = (crystalOre * buff) / 100
    val bonusIronOre = (ironOre * buff) / 100

    println("Бонус кристаличской руды: $bonusCrystalOre\nБонус железной руды: $bonusIronOre")

}