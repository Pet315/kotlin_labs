fun MAX(a: Double, b: Double, c: Double, d: Double): Double {
    println("MAX($a, $b, $c, $d)")
    val y = maxOf(a, b, c, d)
    return y
}
fun powFour(x: Double): Double {
    println("y = $x^4")
    val y = Math.pow(x, 4.0)
    return y
}

fun squareEq(a: Double, b: Double, c: Double, x: Double): Double {
    println("y = $a*$x + $b*$x + $c")
    val y = a * x * x + b * x + c
    return y
}

fun eq1(y: Double): Double {
    println("x^4 = $y")
    if (y >= 0) {
        val x = Math.pow(y, 1.0 / 4.0)
        return x
    } else {
        throw IllegalArgumentException("y must be >= 0")
    }
}

fun eq2(a: Double, b: Double, c: Double, y: Double): String {
    println("y = $a*x^2 + $b*x + $c")
    val d = b * b - 4 * a * (c - y)
    if (d >= 0) {
        val x1 = (-b + Math.sqrt(d)) / (2 * a)
        val x2 = (-b - Math.sqrt(d)) / (2 * a)
        return "x1 = $x1, x2 = $x2"
    } else {
        return "no valid solutions"
    }
}

fun eq3(a: Double, c: Double, y: Double): Double {
    println("x = ($y - $c) / $a")
    val x = (y - c) / a
    return x
}

fun inputValues(lastValue: String): List<Double> {
    val variables = listOf("a", "b", "c", "d", lastValue)
    val values = mutableListOf<Double>()

    for (variable in variables) {
        print("Enter $variable in type Double: ")
        val input = readLine()?.toDoubleOrNull() ?: 0.0
        values.add(input)
    }

    return values
}

fun main() {
    println("1. Обчисліть значення функції та виведіть його на екран:")
    val task1 = inputValues("x")
    val (a1, b1, c1, d1, x) = task1
    println(MAX(a1, b1, c1, d1))
    println(powFour(x))
    println(squareEq(a1, b1, c1, x))

    println("2. Розв'яжіть рівняння та виведіть на екран результат")
    val task2 = inputValues("y")
    val (a2, b2, c2, d2, y) = task2
    val res = eq1(y)
    println("x1 = $res, x2 = ${-1 * res}")
    println(eq2(a2, b2, c2, y))
    println(eq3(a2, c2, y))
}



