import java.util.*
import kotlin.random.Random


class Recursion {


    fun takeInput(){
        val scanner = Scanner(System.`in`)
        val x = scanner.nextInt()
        val start = "("
        val ans = mutableListOf<String>()
        answer(ans, start, x)
        println(ans)
    }

    private fun answer(ans: MutableList<String>, starting: String, input: Int) {
        if(starting.length >= (input * 2)) {
            if(isValid(starting)) {
                ans.add(starting)
            }
        }
        if(starting.length == (input * 2)) return
        answer(ans, "$starting)", input)
        answer(ans, "$starting(", input)
    }

    private fun isValid(parentheses: String): Boolean {
        val stack = Stack<Char>()
        for (element in parentheses) {
            if (element == '(') {
                stack.push(element)
            } else if (element == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}