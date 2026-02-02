import kotlin.properties.Delegates

//interface Base {
//    fun someFun()
//}
//
//interface Messenger {
//    fun sendTextMessage()
//    fun sendVideoMessage()
//}
//
//interface PhotoDevice {
//    fun takePhoto()
//}
//
//class BaseImpl() : Base {
//    override fun someFun() {}
//}
//
//class Derived(someBase: Base) : Base by someBase
//
//class InstantMessenger(val programName: String) : Messenger {
//    override fun sendTextMessage() = println("Send text message")
//    override fun sendVideoMessage() = println("Send video message")
//
//}
//
//class SmartPhone(val name: String, val m: Messenger) : Messenger by m{
//    override fun sendTextMessage() = println("Send sms")
//}
//
//class PhotoCamera : PhotoDevice {
//    override fun takePhoto() = println("Take a photo")
//}
//
//fun main() {
//    val max = InstantMessenger(programName = "MAX")
//    //val photoCamera = PhotoCamera()
//    val yotaPhone = SmartPhone(name = "YotaPhone", m = max)
//    yotaPhone.sendTextMessage()
//    yotaPhone.sendVideoMessage()
//}
class User {
    var name: String by Delegates.observable(initialValue = "<no name>") {
            _, old, new ->
        println("Имя изменено: '$old' → '$new'")
    }
}

var counter: Int by Delegates.observable(0) { _, old, new ->
    println("Счетчик изменился: $old -> $new")
}
fun main() {
    counter = 1
    counter = 5
    val user = User()
    user.name = "Вася"
    user.name = "Петя"
}