import java.time.LocalDateTime

//Написати клас на kotlin, який описує студента НТУУ «КПІ» використовуючи наступні елементи:
// * змінні екземпляра
// * змінні класу
// * public і private методи
// * javadoc
// * toString
//Та клас який використовує клас Student.

class Student(private val name: String, private val group: String) {
    // змінні класу
    companion object {
        const val university = "НТУУ «КПІ»"
        var budget_places = 12260
        var number = 0
    }

    init {
        budget_places--
        number++
    }

    // javadoc
    /**
     * Метод для отримання інформації про студента
     * @return Рядок з інформацією про студента
     */

    // private method
    private fun studentCard(): String {
        return "$number. $name, $university, $group"
    }

    // public method
    fun sendLetter(email: String, letter: String) {
        println("email: $email, letter: $letter")
    }

    // toString
    override fun toString(): String {
        return studentCard()
    }
}

class Admission(private val time: LocalDateTime) {
    fun activate() {
        println("Дата: $time\nНові студенти:")

        val s1 = Student("Андрій Сірко", "ПК-21")
        println(s1.toString())

        val s2 = Student("Віктор Боровенко", "ТМ-13")
        println(s2.toString())

        println("Залишилось вільних бюджетних місць: ${Student.budget_places}")
        s1.sendLetter("romaniuk_af@gmail.com", "Гарного дня")
    }
}

fun main() {
    val adm = Admission(LocalDateTime.now())
    adm.activate()
}
