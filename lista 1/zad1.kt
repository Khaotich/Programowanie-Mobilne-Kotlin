//Karol Pichurski
//Lista 1 Zadanie 1

fun main(args: Array<String>)
{
    for(i in 1..100)
    {
        if(i % 3 == 0 && i % 5 == 0) println("trzypice")
        else if(i % 3 == 0) println("trzy")
        else if(i % 5 == 0) println("piec")
        else println(i)
    }
}