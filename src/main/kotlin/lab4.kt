// 1. Написати программу, що робить перевірку, чи є значення символьної змінної, що
// введена з клавіатури:
// - цифрою від '0' до '9';
// - малою латинською літерою;
// - латинською літерою (великою чи малою)
fun task1() {
    print("Enter some symbol: ")
    val input = readLine()?.trim()

    if (input != null && input.length == 1) {
        val char = input[0]

        when {
            char in '0'..'9' -> println("It's a digit: $char")
            char in 'a'..'z' -> println("It's a small latin letter: $char")
            char in 'A'..'Z' -> println("It's a big latin letter: $char")
            else -> println("It's something else")
        }
    } else {
        println("Введено більше або менше одного символу")
    }
}

// 2. У розкладі рейсів літаків дні тижня позначаються номерами від 1 до 7.
// Припустимо, що в програмі дні тижня подаються enum типом Weekd. Написати
// програму, що у відповідь на введення номера дня виводить текстове подання дня
// тижня.
enum class Weekd {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;

    companion object {
        fun dayOfWeek(number: Int): Weekd? {
            return when (number) {
                1 -> Monday
                2 -> Tuesday
                3 -> Wednesday
                4 -> Thursday
                5 -> Friday
                6 -> Saturday
                7 -> Sunday
                else -> null
            }
        }
        fun calendar(currentDay: Weekd): Weekd {
            return when (currentDay) {
                Monday -> Tuesday
                Tuesday -> Wednesday
                Wednesday -> Thursday
                Thursday -> Friday
                Friday -> Saturday
                Saturday -> Sunday
                Sunday -> Monday
            }
        }
    }
}

fun tasks2_3() {
    print("Enter the number of day of the week (from 1 to 7): ")
    val dayNumber = readLine()?.toIntOrNull() ?: 0
    val day = Weekd.dayOfWeek(dayNumber)
    if (day != null) {
        println("Ви ввели: ${day.name}")
    } else {
        println("Wrong number")
    }

//    3. За понеділком іде вівторок тощо, а за неділею – понеділок. Написати функцію
//    обчислення за днем тижня (типу Weekd) наступного за ним дня.
    println("Task 3")
    var today = Weekd.Monday
    for (i in 1..7) {
        val tomorrow = Weekd.calendar(today)
        println("Next day after $today is $tomorrow")
        today = tomorrow
    }
}

// 4. Написати "найпростіший калькулятор", що отримує на вхід 2 числа і операцію над
// ними після чого повертає результат обчислень.
fun task4() {
    print("First number: ")
    val number1 = readLine()?.toDoubleOrNull() ?: return println("This type isn't Double")

    print("Second number: ")
    val number2 = readLine()?.toDoubleOrNull() ?: return println("This type isn't Double")

    print("Enter the operation (+, -, *, /): ")
    val operator = readLine()

    val result = when (operator) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "*" -> number1 * number2
        "/" -> {
            if (number2 != 0.0) {
                number1 / number2
            } else {
                println("Error: Division by zero")
                return
            }
        }
        else -> {
            println("Wrong operation")
            return
        }
    }

    println("Result: $result")
}

// 5. Написати процедуру обчислення за цілим N>3 таких натуральних A і B, що 5A-2B=N,
// причому A+B мінімально.
fun findNumbers(N: Int) {
    var minSum = Int.MAX_VALUE
    var resultA = 0
    var resultB = 0

    for (A in 1..N) {
        for (B in 1..N) {
            if (5 * A - 2 * B == N && A + B < minSum) {
                minSum = A + B
                resultA = A
                resultB = B
            }
        }
    }

    if (resultA != 0 && resultB != 0) {
        println("A = $resultA, B = $resultB")
    } else {
        println("Impossible to find numbers A and B")
    }
}

fun task5() {
    print("Enter the number: ")
    val N = readLine()?.toIntOrNull() ?: return println("This type isn't Int")

    if (N > 3) {
        findNumbers(N)
    } else {
        println("N must be more than 3")
    }
}


fun main() {
    println("Task 1:")
    task1()
    println("Task 2:")
    tasks2_3()
    println("Task 4:")
    task4()
    println("Task 5:")
    task5()
}