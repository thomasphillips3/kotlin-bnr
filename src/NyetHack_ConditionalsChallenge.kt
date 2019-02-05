fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    var isBlessed = true
    val isImmortal = false

    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"

    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quickly."
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty badly hurt."
        else -> "knocking on death's door"
    }

    // Player status
    println("(Aura: $auraColor) " +
        "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}