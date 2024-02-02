package utils

import java.io.File
import java.io.InputStream

object InputGetter {
    fun getFileInput(fileName: String = "input"): String {
        val path = System.getProperty("user.dir")
        val fileNamePath = "$path/codechallenges/testfiles/$fileName.txt"

        println("Path: $fileNamePath")

        val inputStream: InputStream = File(fileNamePath).inputStream()

        return inputStream.bufferedReader().use { it.readLine() }
    }
}