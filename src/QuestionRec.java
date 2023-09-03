import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class QuestionRec {

    private void t() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String start = "(";
        List<String> ans = new ArrayList();
        answer(ans, start, x);
        System.out.println(ans);
    }

    private void answer(List<String> ans, String starting, int input) {
        if (starting.length() >= (input * 2)) {
            if (isValid(starting)) {
                ans.add(starting);
            }
        }
        if (starting.length() == (input * 2)) return;
        answer(ans, starting + ")", input);
        answer(ans, starting + "(", input);
    }

    private boolean isValid(String parentheses) {
        Stack<String> stack = new Stack();
        for (int i = 0; i < parentheses.length(); i++) {
            String element = String.valueOf(parentheses.charAt(i));
            if (element.equals("(")) {
                stack.push(element);
            } else if (element.equals(")")) {
                if (stack.isEmpty() || stack.pop() != "(") {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
