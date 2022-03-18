const val NUMBER_OF_SECOND = 3605
const val JUST_NOW = 60
const val NUMBER_OF_SECONDS_PER_HOUR = 3600
const val DAY = 86_400
const val TODAY = 172_800
const val YESTERDAY = 259_200
const val MINUTES = NUMBER_OF_SECOND / 60
const val HOURS = NUMBER_OF_SECOND / 3600

fun main() {
    print("Был(а) в сети: ")
    agoToText()
}

fun agoToText() {
    when (NUMBER_OF_SECOND) {
        in 0..JUST_NOW -> print("только что")
        in JUST_NOW..NUMBER_OF_SECONDS_PER_HOUR -> print(
            "$MINUTES " + lastNumber(
                "минуту",
                "минуты",
                "минут"
            ) + " назад"
        )
        in NUMBER_OF_SECONDS_PER_HOUR..DAY -> print("$HOURS " + lastNumber("час", "часа", "часов") + " назад")
        in DAY..TODAY -> print("сегодня")
        in TODAY..YESTERDAY -> print("вчера")
        in YESTERDAY..Int.MAX_VALUE -> print("давно")
    }
}

fun lastNumber(
    variant1: String,
    variant2: String,
    variant3: String
): String {
    val lastNumberMinut1: Int = MINUTES % 10
    val lastNumberMinut11: Int = MINUTES % 100
    val lastNumberHour: Int = HOURS % 10
    return if (lastNumberMinut1 == 1 || lastNumberHour == 1) variant1 else if (lastNumberMinut1 in 2..4 || lastNumberHour in 2..4) variant2 else if (lastNumberMinut11 == 11) variant3 else variant3
}
