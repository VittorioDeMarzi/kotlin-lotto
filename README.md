# kotlin-lotto

## Features

- [x] Purchase amount validation (Greater or equal than 1000, divisible by 1000)
    - [x] The input amount must be greater than or equal to 1,000 KRW
    - [x] The amount must be divisible by 1,000 KRW
- [x] Calculate number of tickets from the amount: amount / 1000
- [x] Generate LottoTickets
    - [x] each ticket has 6 numbers
    - [x] Numbers must be in the range 1 to 45
    - [x] Numbers should be sorted in ascending order
    - [x] Display all purchased tickets to the user
- [x] Input and Validation winning numbers:
    - [x] Input 6 unique winning numbers (1–45)
    - [x] Input 1 bonus number (must not be among the 6 winning numbers)
- [x] Match tickets against winning numbers
    - [x] Compare each ticket against the winning numbers
    - [x] Count how many numbers match (include bonus number for 2nd prize)
- [x] Determine prize rank using Enum class
- [x] Show winning statistic
    - [x] Count and display how many tickets fall into each prize category
    - [x] Calculate and display winning rate
