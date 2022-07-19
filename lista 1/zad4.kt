//Karol Pichurski
//Lista 1 Zadanie 4

//zwraca -1 jeśli nie brakuje liczby
fun missingNumber(intArray: IntArray) : Int
{
    val maks:Int = intArray.maxOrNull() ?: 0
    for(i in 0..maks)
    {
        if(i !in intArray) return i
    }
    return -1
}

fun main(args: Array<String>)
{
    val tab: IntArray = intArrayOf(0, 1, 2, 3, 5)
    println(missingNumber(tab))
}