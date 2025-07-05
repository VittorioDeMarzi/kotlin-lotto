package lotto.ui

enum class Error(val message: String) {
    BONUS("BONUS NUMBER MUST NOT BE IN THE WINNING LOTTO"),
    LOW_PURCHASE_AMOUNT("PURCHASE AMOUNT MUST ABOVE OR EQUAL TO 1000"),
    NOT_DIVISIBLE_BY_1000("PURCHASE AMOUNT MUST DIVISIBLE BY 1000"),
    INVALID_INPUT("INVALID INPUT"),
    INVALID_WINNING_SIZE("[ERROR] Winning numbers must be 6 numbers."),
    DUPLICATE_WINNING("[ERROR] Winning numbers must be unique."),
    OUT_OF_RANGE("[ERROR] Numbers must be between 1 and 45."),
}
