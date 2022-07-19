//Karol Pichurski
//Lista 4 Zadanie 6

fun List<Any>.head(): Any
{
    return this[0]
}

fun List<Any>.tail(): List<Any>
{
    var result = mutableListOf<Any>()
    for(i in 1..this.size - 1)
        result.add(this[i])
    
    return result.toList()
}

fun main()
{
    val list = listOf(1, 2, 3, 4, 5)
    println(list.head())
    println(list.tail())
}