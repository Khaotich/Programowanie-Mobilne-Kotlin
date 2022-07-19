//Karol Pichurski
//Lista 1 Zadanie 3

fun main(args: Array<String>)
{
    for(i in 1..16000)
    {
        if(i % (3*5*7*11*13) == 0) println("trzypicesiedemjedenascietrzynascie")
        else if(i % (3*5*7*11) == 0) println("trzypicesiedemjedenascie")
        else if(i % (3*5*7) == 0) println("trzypicesiedem")
        else if(i % (3*5) == 0) println("trzypice")
        else if(i % (3*7) == 0) println("trzysiedem")
        else if(i % (3*13) == 0) println("trzytrzynascie")
        else if(i % (3*11) == 0) println("trzyjedenascie")
        else if(i % (5*7) == 0) println("piecsiedem")
        else if(i % 3 == 0) println("trzy")
        else if(i % 5 == 0) println("piec")
        else if(i % 7 == 0) println("siedem")
        else if(i % 11 == 0) println("jedenascie")
        else if(i % 13 == 0) println("trzynascie")
        else println(i)
    }
}