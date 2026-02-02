package outpostState
class OutpostManager {
    val resources: List<ObservableResource> by lazy {
        println("Менеджер ресурсов инициализирован!")
        mutableListOf<ObservableResource>()
    }

    fun getAll(): List<ObservableResource> = resources.toList()

    fun add(resource: ObservableResource) {
        (resources as MutableList).add(resource)
        println("Добавлен ресурс ${resource.name}: ${resource.amount}")
    }
}