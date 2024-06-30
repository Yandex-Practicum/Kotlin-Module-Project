fun main(){
    val workers = 50
    val salaryOfWorkers = 30_000 * workers
    val intern = 30
    val salaryOfIntern = 20_000 * intern
    val middleSalary = (salaryOfWorkers + salaryOfIntern) / (workers + intern)

    println("Расходы на выплату зарплат постоянным сотрудникам составляют: $salaryOfWorkers")
    println("Общие расходы составляют: ${salaryOfWorkers + salaryOfIntern}")
    println("Средняя заработная плата составляет: $middleSalary")
}