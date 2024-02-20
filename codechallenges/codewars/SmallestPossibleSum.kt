package codechallenges.codewars

import codechallenges.misc.pow
import java.util.*
import kotlin.math.pow

/**
 * Description
 * Given an array X of positive integers, its elements are to be transformed by running the following operation on them as many times as required:
 *
 * if X[i] > X[j] then X[i] = X[i] - X[j]
 *
 * When no more transformations are possible, return its sum ("smallest possible sum").
 *
 * For instance, the successive transformation of the elements of input X = [6, 9, 21] is detailed below:
 *
 * X_1 = [6, 9, 12] # -> X_1[2] = X[2] - X[1] = 21 - 9
 * X_2 = [6, 9, 6]  # -> X_2[2] = X_1[2] - X_1[0] = 12 - 6
 * X_3 = [6, 3, 6]  # -> X_3[1] = X_2[1] - X_2[0] = 9 - 6
 * X_4 = [6, 3, 3]  # -> X_4[2] = X_3[2] - X_3[1] = 6 - 3
 * X_5 = [3, 3, 3]  # -> X_5[1] = X_4[0] - X_4[1] = 6 - 3
 *
 * The returning output is the sum of the final transformation (here 9).
 *
 * Example
 * solution([6, 9, 21]) #-> 9
 * Solution steps:
 * [6, 9, 12] #-> X[2] = 21 - 9
 * [6, 9, 6] #-> X[2] = 12 - 6
 * [6, 3, 6] #-> X[1] = 9 - 6
 * [6, 3, 3] #-> X[2] = 6 - 3
 * [3, 3, 3] #-> X[1] = 6 - 3
 *
 */
fun main() {
    val longArray1 = longArrayOf(6,9,21)
    println("${findGcd(longArray1)} expected 9")

    val longArray2 = longArrayOf(6,9,12)
    println("${findGcd(longArray2)} expected 9")

    val longArray3 = longArrayOf(71,71,71,71,71,71,71,71,71,71,71,71,71)
    println("${findGcd(longArray3)} expected 923")

    val longArray4 = longArrayOf(3,13,23,7,83)
    println("${findGcd(longArray4)} expected 5")
//
//    val longArray5 = longArrayOf(9)
//    println("${solution(longArray5)} expected 9")
//
//    val longArray6 = longArrayOf(600925, 371293, 1529437, 541008, 444925, 2632500, 469300, 157300, 1638325, 1364688, 1004692, 2810925, 1306357, 2471248, 2632500, 3224052, 1467648, 421200, 110032, 1760512, 1828125, 675792, 2774772, 724048, 1390077, 1770093, 1041157, 2038608, 1041157, 1619917, 165997, 812500, 43732, 122317, 812500, 2945488, 2847312, 1731925, 2100852, 65533, 617812, 872053, 1085773, 899197, 2786797, 148837, 1867333, 3045328, 454597, 755053, 243997, 851968, 3146832, 42237, 832117, 243997, 567853, 199888, 2738853, 2028325, 646477, 1556308, 2018068, 1779700, 49972, 1004692, 663988, 71188, 1520532, 2174653, 100672, 525213, 1415700, 1610752, 449748, 48373, 2750800, 2574325, 2228148, 2896192, 1407133, 838708, 535717, 206388, 165997, 151632, 2644213, 573300, 2048917, 1967173, 2471248, 1100853, 663988, 1322893, 2516800, 1789333, 130000, 1741428)
//    println("${solution(longArray6)} expected 1274")
//
//    val longArray7 = longArrayOf(2170590940, 4242752815, 528910375, 4967134375, 1800738940, 2774440375, 3417520540, 488755015, 3883446000, 425351815, 2900894535, 104813415, 2470633375, 1343113135, 401223375, 577761660, 71526735, 3452304240, 2382925615, 1604893500, 721233415, 1813353535, 1236560535, 2916899440, 769842535, 1994581015, 1375937500, 1604893500, 2853144000, 5503750000, 1409158135, 721233415, 450184735, 2034538240, 820036735, 5307398215, 3682691215, 1813353535)
//    println("${solution(longArray7)} expected 836570")
//
//    println("GCD: ${findGcd(longArrayOf(2, 5))} expected 1")
//    println("GCD: ${findGcd(longArrayOf(15, 70))} expected 5")

//    val longArray1 = longArrayOf(6,9,21)
//    println("${findGcd(longArray1)} expected 9")
}

fun solution(numbers: LongArray): Long {
    val compareByCount = Comparator<Long> {t1, t2 -> (t2 - t1).toInt() }
    val ts = TreeSet(compareByCount)
    var min = Long.MAX_VALUE

    for (i in numbers) {
        min = i.coerceAtMost(min)
        ts.add(i)
    }

    var curr = ts.pollFirst()!!

    if (ts.isEmpty()) return min * numbers.size

    while (!ts.isEmpty()) {
        val modded = curr - ts.first()
        min = min.coerceAtMost(modded)
        ts.add(modded)

        curr = ts.pollFirst()!!
    }

    return min * numbers.size
}

fun solutionWithGcd(numbers: LongArray): Long {
    val max = numbers.max()

    for (i in 1 until max) {
        for (num in numbers) {
            if (num % i != 0L) {
                break
            }
        }

        return max * numbers.size
    }

    return max
}

fun findLcm(numbers: LongArray): Long {
    val maxNum = numbers.max()
    var start = maxNum

    while (true) {
        val divisibleNums = numbers.filter { num -> (start % num).toInt() == 0 }.size

        if (divisibleNums == numbers.size) {
            return start
        } else {
            start += maxNum
        }
    }
}

fun findGcd(numbers: LongArray): Long {
    val lcm = findLcm(numbers)
    return numbers.reduce { acc, l -> acc * l } / lcm
}

//fun printEntirePq(pq: PriorityQueue<Long>) {
//    val pqCopy = PriorityQueue(pq)
//    println("************")
//    while (pqCopy.isNotEmpty()) {
//        println(pqCopy.poll())
//    }
//    println("************")
//}
//
//fun printEntireTs(ts: TreeSet<Long>) {
//    val tsCopy = TreeSet(ts)
//    println("************")
//    while (tsCopy.isNotEmpty()) {
//        println(tsCopy.pollFirst())
//    }
//    println("************")
//}