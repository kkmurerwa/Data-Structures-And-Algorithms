package codechallenges

import java.io.File
import java.io.InputStream

fun main() {
    decode("coding_input")
}

fun decode(message_file: String) {
    val path = System.getProperty("user.dir")
    val fileNamePath = "$path/codechallenges/testfiles/$message_file.txt"

    val map = mutableMapOf<Int, String>()

    var max = 0

    val inputStream: InputStream = File(fileNamePath).inputStream()

    inputStream.bufferedReader().use {
        var line = it.readLine()
        while (line != null) {
            val lineSplit = line.split(" ")

            val currKey = lineSplit[0].toInt()

            // Check if current key is greater than current max value
            max = max.coerceAtLeast(currKey)

            map[currKey] = lineSplit[1]

            line = it.readLine()
        }
    }

    var currentAdd = 1
    var currentCount = 0
    var currMax = 1
    val sb = StringBuilder()

    for (i in 0..max) {
        if (map.containsKey(i)) {
            currentCount += 1
            if (currentCount == currMax) {
                currentAdd += 1
                currMax = currentCount + currentAdd

                // Append to the string builder to create the final message
                sb.append(" " + map[i])
            }
        }
    }

    println(sb.trimStart())
}