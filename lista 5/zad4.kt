//Karol Pichurski
//Lista 5 Zadanie 4

fun check(N: Int, list: List<Int>): Int
{
    var result = 0
    for(i in N .. list.size - 1)
    {
        val t = list[i]
        val tmp = mutableListOf<Int>()
        for(x in i - N .. i + N - 1)
        {
            for(y in i - N + 1 .. i + N)
            {
                tmp.add(list[x]+list[y])
            }
        }
        if(t !in tmp)
        {
            result = t
            break
        }
    }
    return result
}

fun main()
{
    println(check(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)))
}