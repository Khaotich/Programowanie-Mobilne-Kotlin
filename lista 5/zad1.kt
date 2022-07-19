//Karol Pichurski
//Lista 5 Zadanie 1

fun list_pow(list: List<Number>): List<Number>
{
    val result = mutableListOf<Number>()
    for(i in 0..list.size -1)
    {
        if((i + 1) % 2 != 0 && list[i].toDouble() > 0)
        {
            val a = list[i].toDouble()
            result.add(a * a)
        }
    }

    return result.toList()
}

fun main()
{
    val li = listOf(1, 2, 3.5, 5, -6, 1, 1)
    println(list_pow(li))
}