package leetcode.Tree;

import java.util.Stack;

/**
 * 逆波兰式计算器
 */
public class RPN2 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                stack.add(num);
            } catch (Exception e) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.add(a + b);
                    case "-":
                        stack.add(a - b);
                    case "*":
                        stack.add(a * b);
                    case "/":
                        stack.add(a / b);
                    default:
                        stack.add(0);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"3","-4","+"};
        RPN rpn = new RPN();
        System.out.println(rpn.evalRPN(arr));
    }
}
