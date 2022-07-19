//Karol Pichurski
//Lista 2 Zadanie 3

fun isCyclic(i: String): Boolean
{
    var result = true
    val tab = i.toCharArray().sorted().toString()
    for(x in 1..i.length)
    {
        val c = (i.toInt() * x).toString().toCharArray().sorted().toString()
        if(tab != c) result = false
    }
    return result
}

fun main()
{
    println(isCyclic("142857"))
    println(isCyclic("120"))
}