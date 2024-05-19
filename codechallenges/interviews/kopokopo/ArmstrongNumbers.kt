package codechallenges.interviews.kopokopo

import kotlin.math.pow

/**
 * Write a program to print out all Armstrong numbers between 1 and 500.
 * If sum of cubes of each digit of the number is equal to the number itself, then the number is called an Armstrong
 * number.
 *
 * For example;
 * 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 ) = 153 ~ is armstrong number
 * 12 = (1 * 1 * 1) + (2 * 2 * 2) = 9 ~ not armstrong number
 */
fun main() {
    for (i in 0..500) {
        if (isArmstrongNumber(i)) {
            println(i)
        }
    }
}

fun isArmstrongNumber(num: Int): Boolean {
    val numString = num.toString()
    var sum = 0

    for (i in numString.indices) {
        if (sum > num) {
            break
        }

        val curr = numString[i].digitToInt().toDouble()
        sum += curr.pow(numString.length).toInt()
    }

    return sum == num
}