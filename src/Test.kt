var age: Int = 18
    set(value) {
        if((value > 0) and (value < 110))
            field = value
    }

fun main() {
    println(age)
    age = 55
    println(age)
    age = -43
    println(age)
}