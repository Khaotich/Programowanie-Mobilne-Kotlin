//Karol Pichurski
//Lista 5 Zadanie 2

fun string_list(list: List<String>): List<Pair<Char, List<String>>>
{
    val letters = mutableListOf<Char>()
    val result: MutableList<Pair<Char, List<String>>> = mutableListOf()
    val r: MutableMap<Char, MutableList<String>> = mutableMapOf()
    for(i in list)
    {
        val tmp: Char = i[0]
        val boolean: Boolean = i.length % 2 == 0
        if(tmp !in letters)
        {
            letters.add(tmp)
            if(boolean)
                r.put(tmp, mutableListOf(i))
            else
                r.put(tmp, mutableListOf())
        }
        else if(tmp in letters && boolean)
        {
            r[tmp]?.add(i)
        }
    }

    val r_ = r.toSortedMap()
    for(i in r_)
    {
        val char: Char = i.key
        val l: List<String> = i.value
        result.add(Pair(char, l))
    }

    return result
}

fun main()
{
    val list = listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")
    println(string_list(list))
}