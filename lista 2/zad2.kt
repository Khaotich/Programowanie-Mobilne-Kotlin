//Karol Pichurski
//Lista 2 Zadanie 2

fun convertFromRoman(s: String): Int
{
    var result = 0
    val numbers = mapOf(
        'M' to 1000,
        'D' to 500,
        'C' to 100,
        'L' to 50,
        'X' to 10,
        'V' to 5,
        'I' to 1
    )

    if(s.isNotEmpty())
    {
        for(i in 0..s.length - 2)
        {
            val left = numbers[s[i]] !!
            val right = numbers[s[i + 1]] !!
            if(left < right ) result -= left
            else result += left
        }
        result += numbers[s[s.length - 1]]!!
    }
    return result
}

fun main()
{
    print(convertFromRoman("MMMMMMMMMMMMCCCXLV"))
}