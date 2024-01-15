class RecursionTasks {
    fun doTasks() {
        // task1
        print("Enter the number of Fibonacci numbers: ")
        var number = readLine()?.toInt() ?: 0
        println("Result:")
        for (i in 0 until number) {
            println("$i - ${task1(i)}")
        }

        // task2
        print("\nEnter the number (must be >= 0): ")
        number = readLine()?.toInt() ?: 0
        if (number < 0) {
            println("The number is not >= 0")
        } else {
            println("$number! = ${task2(number)}")
        }

        // task3
        print("\nEnter the natural number: ")
        number = readLine()?.toInt() ?: 0

        if (number < 0) {
            println("The number is not natural")
        } else {
            println("The number of digits in $number: ${task3(number)}")
        }
    }

    fun task1(n: Int): Int = if (n <= 1) n else task1(n - 1) + task1(n - 2)

    fun task2(n: Int): Long = if (n <= 1) 1 else n.toLong() * task2(n - 1)

    fun task3(n: Int): Int = if (n < 10) 1 else 1 + task3(n / 10)
}

fun main() {
    val rt = RecursionTasks()
    rt.doTasks()
}
