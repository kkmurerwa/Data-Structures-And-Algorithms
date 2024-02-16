package codechallenges.leetcode

fun main() {
    val n = 15

    for (i in 1..n) {
        if (i % 3 == 0 && i % 5 == 0) {
            println("FizzBuzz")
        } else if (i % 5 == 0) {
            println("Buzz")
        } else if (i % 3 == 0) {
            println("Fizz")
        } else {
            println(i)
        }
    }
}