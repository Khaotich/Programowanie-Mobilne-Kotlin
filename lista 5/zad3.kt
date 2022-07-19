//Karol Pichurski
//Lista 5 Zadanie 3

fun permutations(vararg args: Int): Collection<List<Int>>
{
    val set: List<Int> = args.toList()
    if(set.isEmpty()) return emptySet()

    fun permutations_(list: List<Int>): Set<List<Int>>
    {
        if(list.isEmpty()) return setOf(emptyList())

        val result: MutableSet<List<Int>> = mutableSetOf()
        for(i in list.indices)
        {
            permutations_(list - list[i]).forEach{
                    item -> result.add(item + list[i])
            }
        }
        return result
    }
    return permutations_(set.toList())
}

fun main()
{
    println(permutations(1, 2, 3))
}