package sidequests

fun main() {
    val str = "Hello Kotlin Devs"

    for(i in 0..str.length - 1) {
        println("I: ${str.get(i)}")
    }

    for (i in str) {
        println("I: $i")
    }
}