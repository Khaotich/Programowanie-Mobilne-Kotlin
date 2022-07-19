//Karol Pichurski
//Lista 2 Zadanie 1

fun convertToRoman(n: Int): String
{
    val numbers = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    for(i in numbers.keys)
    {
        if(n >= i) return numbers[i] + convertToRoman(n - i)
    }
    return ""
}

fun main()
{
    print(convertToRoman(12345))
}