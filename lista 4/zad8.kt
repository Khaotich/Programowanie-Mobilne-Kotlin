//Karol Pichurski
//Lista 4 Zadanie 8

fun suma(a: Array<Double>): Double
{
    val aa = a.filter { it > 0.0}
    val sum = aa.reduce { acc, int -> acc + int }
    return sum
}

fun main()
{
    val array = arrayOf(-1.0, -2.5, 5.6, 6.7)
    println(suma(array))
}

