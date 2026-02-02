package outpostState

fun main() {
    val loadedResources = StateStorage.load()

    val manager = OutpostManager()

    if (loadedResources.isEmpty()) {
        manager.add(ObservableResource(name = "Minerals", amountInit = 300))
        manager.add(ObservableResource(name = "Gas", amountInit = 100))
    } else {
        loadedResources.forEach {
            manager.add(it)
        }
    }

    val mineral = manager.resources[0]
    mineral.amount = 80

    StateStorage.save(manager.getAll())
    println("Состояние сохранено")
}