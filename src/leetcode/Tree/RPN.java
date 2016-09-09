package leetcode.Tree;

import java.util.Stack;

/**
 * 逆波兰式计算器
 */
public class RPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                stack.add(num);
            } catch (Exception e) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(get(a, b, token));
            }
        }
        return stack.pop();
    }

    private int get(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"2", "1", "+", "3", "*"};
        RPN rpn = new RPN();
        System.out.println(rpn.evalRPN(arr));
    }
}

