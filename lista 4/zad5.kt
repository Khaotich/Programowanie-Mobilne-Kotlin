//Karol Pichurski
//Lista 4 Zadanie 5

tailrec fun fib(i: Int): Int = if(i == 1 || i == 2) 1 else (fib(i - 1) + fib(i - 2))

fun log2(i: Int): Int { return (kotlin.math.log(i.toFloat(), 2.0.toFloat())).toInt() }

fun myPrint(i: Int, f:(Int) -> Int): String
{
    var result = ""
    if(f == ::log2)
    {
        result = "log2(" + i.toString() + ") = " + f(i).toString()
    }
    else if(f == ::fib)
    {
        result = "Fibbonaci(" + i.toString() + ") = " + f(i).toString()
    }

    return result
}

fun main()
{
    println(myPrint(16, ::log2))
    println(myPrint(16, ::fib))
}