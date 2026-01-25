package gameCharacter
sealed class CharacterState {
    object Bezdeistvie : CharacterState(){
    override fun toString() = "Бездействие"
    }

    object Running : CharacterState() {
        override fun toString() = "Бег" }

    data class Attacking(val damage: Int) : CharacterState() {
        override fun toString() = "Атака ($damage урона)"
    }
    data class Dead(val prichina: String) : CharacterState(){
        override fun toString() = "Смерть($prichina)"
    }
}
