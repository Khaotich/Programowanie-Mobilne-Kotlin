//Karol Pichurski
//Lista 4 Zadanie 9

fun countElements(a: Array<Array<Char>>): Map<String, Int>
{
    var result: MutableMap<String, Int> = mutableMapOf<String, Int>()
    for(i in a)
        for(j in i)
        {
            val t = j.toString()
            if(t !in result.keys)
                result += Pair(t, 1)
            else
                result.set(t, result.getValue(t) + 1)
        }

    return result.toMap()
}

fun main()
{
    val input = arrayOf(arrayOf('a', 'b', 'c'), arrayOf('c', 'd', 'f'), arrayOf('d', 'f', 'g'))
    println(countElements(input))
}
