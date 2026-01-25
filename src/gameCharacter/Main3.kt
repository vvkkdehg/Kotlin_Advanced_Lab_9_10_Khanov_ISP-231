package gameCharacter

fun obrabState(state: CharacterState) {
    when (state) {
        CharacterState.Bezdeistvie -> println("Персонаж бездействует")
        CharacterState.Running -> println("Персонаж бежит")
        is CharacterState.Attacking -> println("Персонаж атакует с уроном ${state.damage}")
        is CharacterState.Dead -> println("Персонаж погиб: ${state.prichina}")
    }
}

fun main() {
    val zhenek = GameCharacter("Женек")
    println("Имя: ${zhenek.name}, Состояние: ${zhenek.state}")
    zhenek.changeState(CharacterState.Running)
    obrabState(zhenek.state)
    zhenek.changeState(CharacterState.Attacking(50))
    obrabState(zhenek.state)
    zhenek.changeState(CharacterState.Dead("Споткнулся в 2.20"))
    obrabState(zhenek.state)

}