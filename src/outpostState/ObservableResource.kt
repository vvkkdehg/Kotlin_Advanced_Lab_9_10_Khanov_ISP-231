package outpostState
import kotlin.properties.Delegates
data class ObservableResource(
    val name: String,
    var amountInit: Int
) {
    var amount: Int by Delegates.observable(amountInit) { _, old, new ->
        println("Ресурс $name изменен: $old → $new")
    }
}
