package codechallenges.interviews.andela

fun main() {
    val withFirst = combine(1, ::addTwoNumbers)
    val res1 = withFirst(2)
    println("Res 1: $res1")

    val withFirst2 = combine(1, ::addThreeNumbers)
    val withSecond2 = combine(2, withFirst2)
    val res2 = withSecond2(3)
    println("Res 2: $res2")

    val withFirst3 = combine("Hello", ::concatTwoStrings)
    val res3 = withFirst3("World")
    println("Res 3: $res3")

    val withFirst4 = combine("Hello", ::concatThreeStrings)
    val withSecond4 = combine("There", withFirst4)
    val res4 = withSecond4("Kenneth")
    println("Res 4: $res4")
}

fun <T> combine(a: T, func: (T, T) -> T): (T) -> T {
    return { num: T -> func(a, num) }
}

fun <T> combine(a: T, func: (T, T, T) -> T): (T, T) -> T {
    return { num1: T, num2: T -> func(a, num1, num2) }
}

fun addTwoNumbers(a: Int, b: Int): Int {
    return a + b
}

fun addThreeNumbers(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

fun concatTwoStrings(a: String, b: String): String {
    return "$a $b"
}

fun concatThreeStrings(a: String, b: String, c: String): String {
    return "$a $b $c"
}