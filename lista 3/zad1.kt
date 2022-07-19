//Karol Pichurski
//Lista 3 Zadanie 1

import java.io.File
import kotlin.random.Random
import kotlin.system.exitProcess

fun getWord(): String
{
    val words = File("slowa.txt").readLines()
    return words[Random.nextInt(0, words.size + 1)]
}

fun getText(string: String, word: String,char: Char): String
{
    var result = ""
    for(i in 0..word.length-1)
    {
        if(word[i] == char) result += char
        else result += string[i]
    }
    return result
}

fun display(int: Int, string: String, array: MutableList<Char>, index: Int)
{
    val a = array.joinToString("")

    val szub = arrayOf(
        "      +---+\n" +
                "          |\n" +
                "          |\n" +
                "          |\n" +
                "         ===",
        "      +---+\n" +
                "      O   |\n" +
                "          |\n" +
                "          |\n" +
                "         ===",
        "      +---+\n" +
                "      O   |\n" +
                "      |   |\n" +
                "          |\n" +
                "         ===",
        "      +---+\n" +
                "      O   |\n" +
                "      |   |\n" +
                "          |\n" +
                "         ===",
        "      +---+\n" +
                "      O   |\n" +
                "     /|   |\n" +
                "          |\n" +
                "         ===",
        "      +---+\n" +
                "      O   |\n" +
                "     /|\\  |\n" +
                "          |\n" +
                "         ===",
        "      +---+\n" +
                "      O   |\n" +
                "     /|\\  |\n" +
                "     /    |\n" +
                "         ===",
        "      +---+\n" +
                "      O   |\n" +
                "     /|\\  |\n" +
                "     / \\  |\n" +
                "         ===")

    print(szub[index] + "\n")
    println("Życia: " + int)
    println("Hasło:" + string)
    print("Wykorzyatane litery: ")
    for(i in a) print(i + " ")
    print("\n")
}

fun check_(char: Char, string: String): Boolean
{
    return char in string
}

fun main()
{
    val word = getWord()
    var play = true
    var lifes = word.length
    var text = ""
    var index = 0
    for(i in 0..word.length-1) text += "_"
    var letters : MutableList<Char> = ArrayList()

    while(play)
    {
        display(lifes, text, letters, index)
        print("Podaj literę: ")
        val letter = readLine()!!.toCharArray()[0]
        val st = check_(letter, word)
        if(letter in letters || !letter.isLetter())
        {
            println("Wykorzystałeś już tą literę lub wprowadziłeś zły znak!")
            continue
        }
        letters.add(letter)

        if(st)
        {
            text = getText(text, word, letter)
        }
        else
        {
            lifes--
            if(index < 7) index++
        }

        if(lifes == 0 || text == word) break
    }

    display(lifes, word, letters, index)
    if(lifes == 0) println("Przegrałeś")
    else
    {
        println("Wygrałeś")
        exitProcess(0)
    }
}