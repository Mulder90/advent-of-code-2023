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

    fun String.extractWordDigits(vararg replacements: Pair<String, String>): String {
        var result = this
        replacements.forEach { (left, right) ->
            val replacement = "${left.first()}$right${left.last()}"
            result = result.replace(left, replacement)
        }
        return result
    }

    fun getCalibrationValueCountingWords(line: String): Int {
        val lineWithExtractedNumbers = line.extractWordDigits(
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )
        return getCalibrationValue(lineWithExtractedNumbers)
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { getCalibrationValueCountingWords(it) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)

    // test if implementation meets criteria from the description, like:
    val testInput2 = readInput("Day01_test_2")
    check(part2(testInput2) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
