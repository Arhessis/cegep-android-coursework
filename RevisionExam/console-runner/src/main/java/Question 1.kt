enum class VARIETY {Grannysmith, Fiji, Honeycrisp}

// toString included in data class - know redefine toString

data class Apple (var variety: VARIETY)

val apple : MutableList<Apple> = mutableListOf()

fun main() {
    // println("WHY?")

    apple.add(Apple(VARIETY.Honeycrisp))
    apple.add(Apple(VARIETY.Fiji))
    apple.add(Apple(VARIETY.Grannysmith))

    // println(apple)

    // lambda filter
    // print(apple.filter { it.variety == VARIETY.Honeycrisp })

    // Map modify values in a list
    val nouvellelist = apple.map { it.variety = VARIETY.Fiji
        it}
    println(nouvellelist)

    // Loop
    apple.forEachIndexed { index, name -> println("$index $name")}
}