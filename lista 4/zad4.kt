//Karol Pichurski
//Lista 4 Zadanie 4

fun main()
{
    fun log2(i: Int): Int { return (kotlin.math.log(i.toFloat(), 2.0.toFloat())).toInt() }
    println(log2(16))
}