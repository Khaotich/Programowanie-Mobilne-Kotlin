//Karol Pichurski
//Lista 4 Zadanie 1

val multiStr = fun(s: String, i: Int): String
{
    var result = ""
    for(x in 1..i) result += s
    return result
}


fun main()
{
    println(multiStr("as", 5))
}