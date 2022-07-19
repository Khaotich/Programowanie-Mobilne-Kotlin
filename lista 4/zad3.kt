//Karol Pichurski
//Lista 4 Zadanie 3

fun main()
{
    tailrec fun fib(i: Int): Int = if(i == 1 || i == 2) 1 else (fib(i - 1) + fib(i - 2))
    println(fib(15))
}
