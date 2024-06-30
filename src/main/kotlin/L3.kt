fun main () {

    val trainHour = 9
    val trainMinute = 39
    val trainTimeOfTrip = 457

    val totalTrainMinutes = trainHour * 60 + trainMinute
    val arrivalTotalMinutes = totalTrainMinutes + trainTimeOfTrip

    val arrivalHour = (arrivalTotalMinutes / 60) % 24
    val arrivalMinute = arrivalTotalMinutes % 60

    println("Поезд прибудет в $arrivalHour:$arrivalMinute")
}