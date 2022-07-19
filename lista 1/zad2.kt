//Karol Pichurski
//Lista 1 Zadanie 2

fun main(args: Array<String>)
{
    for(i in 1..200)
    {
        if(i % (3*5*7) == 0) println("trzypicesiedem")
        else if(i % (3*5) == 0) println("trzypice")
        else if(i % (3*7) == 0) println("trzysiedem")
        else if(i % (5*7) == 0) println("piecsiedem")
        else if(i % 3 == 0) println("trzy")
        else if(i % 5 == 0) println("piec")
        else if(i % 7 == 0) println("siedem")
        else println(i)
    }
}