package codechallenges.misc

fun countFinalArrays(n: Int, arr: IntArray): Int {
    val MOD = 1_000_000_007L

    // Count occurrences of each element in the array
    val count = IntArray(arr.maxOrNull()!! + 1)
    for (num in arr) {
        count[num]++
    }

    // Calculate the number of different final arrays
    var result = 1L
    for (i in count.size - 1 downTo 1) {
        count[i - 1] += count[i]
    }

    return count.size
}

// Power function with modulo
fun pow(base: Long, exponent: Int, mod: Long): Long {
    var result = 1L
    var b = base % mod

    var e = exponent
    while (e > 0) {
        if (e % 2 == 1) {
            result = result * b % mod
        }
        b = b * b % mod
        e /= 2
    }

    return result
}

fun main() {
    val n = 2
    val arr = intArrayOf(1, 2)
    val result = countFinalArrays(n, arr)
    println(result)
}
