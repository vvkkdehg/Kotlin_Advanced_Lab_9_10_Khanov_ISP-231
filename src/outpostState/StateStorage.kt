package outpostState

import java.io.File

object StateStorage {
    private const val FILE_NAME = "state.txt"

    fun save(resources: List<ObservableResource>) {
        val file = File(FILE_NAME)
        file.writeText(
            resources.joinToString("\n") {
                "${it.name};${it.amount}"
            }
        )
    }

    fun load(): List<ObservableResource> {
        val file = File(FILE_NAME)

        if (!file.exists()) {
            return emptyList()
        }
        return file.readLines().map { line ->
            val (name, amount) = line.split(";")
            ObservableResource(name, amount.toInt())
        }
    }
}