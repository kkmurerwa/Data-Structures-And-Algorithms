package codechallenges

fun main() {
    println("LCM: ${findLCMOfTwoNums(2, 5)}")

    val testList = listOf(23,31)
    println("LCM of $testList: ${findLcmOfList(testList)}")
}

fun findLCMOfTwoNums(a: Int, b: Int): Int {
    var greater = a.coerceAtMost(b)

    while (true) {
        if (greater % a  == 0 && greater % b == 0) {
            return greater
        } else {
            greater += 1
        }
    }
}

fun findLcmOfList(list: List<Int>): Int {
    val maxNum = list.max()
    var start = maxNum

    while (true) {
        val divisibleNums = list.filter { num -> start % num == 0 }.size

        if (divisibleNums == list.size) {
            return start
        } else {
            start += maxNum
        }
    }
}