fun main(args: Array<String>) {
    val name = "Madrigal"
    val healthPoints = (0..100).random()
    var isBlessed = true
    val isImmortal = false

    // Aura
    val auraColor = auraColor(healthPoints)

    // Health
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // Status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus, healthPoints, isImmortal)

}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    return when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quickly."
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty badly hurt."
        else -> "is knocking on death's door"
    }
}

private fun printPlayerStatus(auraColor: String, isBlessed: Boolean, name: String, healthStatus: String, healthPoints: Int, isImmortal: Boolean) {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal

    println("Health points: $healthPoints")

    if (auraVisible) {
        println("Aura: $auraColor " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
        println("$name $healthStatus")

    } else
        println("NO AURA")

}

private fun auraColor(healthPoints: Int): String {
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20 ) .toInt()

    return when (karma) {
        in 0..5 -> "RED"
        in 6..10 -> "ORANGE"
        in 11..15 -> "PURPLE"
        in 16..20 -> "GREEN"
        else -> "NONE"
    }
}