package gameCharacter

class GameCharacter(
    val name: String,
    var state: CharacterState = CharacterState.Bezdeistvie
) {
    fun changeState(newState: CharacterState) {
        state = newState
        println("$name меняет состояние на $newState")
    }
}