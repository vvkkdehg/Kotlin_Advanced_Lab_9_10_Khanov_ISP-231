import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourseManager
object SystemLogger {
    init {
        println("SystemLogger инициализирован")
    }

    fun log(message: String) {
        println("[LOG] $message")
    }
}
val logger by lazy {
    SystemLogger
}
fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success ->
            println("УСПЕХ: ${result.message}")
        is ModuleResult.ResourceProduced ->
            println("Произведено: ${result.resourceName} +${result.amount}")
        is ModuleResult.NotEnoughResources ->
            println(
                "Недостаточно ресурса ${result.resourceName}. " +
                        "Нужно: ${result.required}, есть: ${result.available}"
            )
        is ModuleResult.Error ->
            println("ОШИБКА: ${result.reason}")
    }
}

fun main() {
//    val processor = PaymentProcessor()
//    val payments = listOf(
//        Payment("4111111111111111", 1000, CardType.VISA),
//        Payment("5111111111111111", 2000, CardType.MASTERCARD),
//        Payment("2222222222222222", 1500, CardType.MIR),
//        Payment("1234567812345678", 500, CardType.UNKNOWN),
//        Payment("123", 3000, CardType.VISA),
//    )
//    println("=== Обработка платежей ===")
//    payments.forEach { payment ->
//        println("\nПлатеж ${payment.type}: ${payment.card.take(4)}..., ${payment.sum} руб")
//        val result = processor.pay(payment)
//        processor.show(result)
//    }
//    println("\n=== Работа с enum ===")
//    val cardType = CardType.VISA
//    println("Тип карты: $cardType")
//    println("Порядковый номер: ${cardType.ordinal}")
//    println("Все типы карт: ${CardType.values().joinToString()}")
//
//    val payment1 = Payment("4111111111111111", 1000, CardType.VISA)
//    val payment2 = payment1.copy(type = CardType.MASTERCARD, sum = 2000)
//
//    println("\n=== Сравнение data class ===")
//    println("Платеж 1: $payment1")
//    println("Платеж 2: $payment2")
//    println("Одинаковые? ${payment1 == payment2}")
    logger.log("Запуск базы")

    val generator = EnergyGenerator()
    val lab = ResearchLab()
    val manager = ResourseManager()
    val loadedResources = FileStorage.load()
    loadedResources.forEach { manager.add(it) }
    if (loadedResources.isEmpty()) {
        manager.add(OutpostResource(id = 1, name = "Minerals", amountInit = 300))
        manager.add(OutpostResource(id = 2, name = "Gas", amountInit = 100))
    }
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager.printAll()

    FileStorage.save(manager.getAll())
}


