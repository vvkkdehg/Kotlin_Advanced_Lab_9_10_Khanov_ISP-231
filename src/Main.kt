fun main() {
    val manager = ResourseManager()
    val gas = OutpostResource(1, "Gas", 100)
    val mineral = OutpostResource(2, "Mineral", 300)
    manager.add(gas)
    manager.add(mineral)
    manager.printAll()
    val bonusMineral = mineral.copy(3, amount = mineral.amount + 50)
    println("Бонусные минералы: $bonusMineral")
}