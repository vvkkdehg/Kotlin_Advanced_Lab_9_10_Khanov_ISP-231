package outpostState
import kotlin.properties.Delegates

class ResourceObserver {
    var lastChange: String by Delegates.observable("Нет изменений") { _, old, new ->
        println("Ресурс изменен: $old -> $new")
    }
}
