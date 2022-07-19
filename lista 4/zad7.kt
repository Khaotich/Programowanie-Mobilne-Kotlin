//Karol Pichurski
//Lista 4 Zadanie 7

fun <T> isSorted(aa: List<T>, order: (T, T) -> Boolean): Boolean
{
    fun sort(t: List<T>): List<T>
    {
        val tt = t.toMutableList()
        for(i in 0..t.size)
            for(j in i+1..t.size - 1)
                if(order(tt[i], tt[j]))
                {
                    val tmp = tt[i]
                    tt.set(i, tt[j])
                    tt.set(j, tmp)
                }
        return tt.toList().reversed()
    }

    var result = false
    val tmp = sort(aa)
    if(tmp == aa) result = true
    return result
}

fun main()
{
    println(isSorted(listOf(1, 2, 3, 4), { i: Int, j: Int -> i < j }))
    println(isSorted(listOf(1, 1, 1, 1), { i: Int, j: Int -> i==j }))
    println(isSorted(listOf("ahyyhh", "bkjn", "cnn", "duu"), { i: String, j: String -> i.first() < j.first() }))
}