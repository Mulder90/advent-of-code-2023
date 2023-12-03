fun main() {
    fun getCalibrationValue(line: String): Int {
        val digits = line.filter { it.isDigit() }
        val firstDigit = digits.first()
        val lastDigit = digits.last()
        return "$firstDigit$lastDigit".toInt()
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { getCalibrationValue(it) }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
