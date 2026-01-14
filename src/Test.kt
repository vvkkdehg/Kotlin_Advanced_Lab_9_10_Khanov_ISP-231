var age: Int = 18
    set(value) {
        if((value > 0) and (value < 110))
            field = value
    }
data class Item(
    val id: Int,
    val name: String,
    val quantity: Int
) {
    override fun toString(): String {
        return "ID: $id | name: $name | quantity: $quantity"
    }
}
fun main() {
//    println(age)
//    age = 55
//    println(age)
//    age = -43
//    println(age)
    val sword = Item(1, "Sword", 1)
    val betterSword = sword.copy(quantity = 2, name = "Better Sword")
    println(sword.toString())
    println(betterSword.toString())
    val(id, name, quantity) = betterSword
    println("$id | $name | $quantity")
}