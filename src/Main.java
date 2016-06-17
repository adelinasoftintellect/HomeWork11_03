import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	private static boolean isCorrectExpression(String expression) {
		char match[] = { '+', '-' };
		for (int i = 0; i < expression.length() - 1; i++) {
			if (Character.isDigit(expression.charAt(i)) && Character.isDigit(expression.charAt(i + 1))) {
				System.out.println("Wrong expression");
				return false;
			}
			if ((expression.charAt(i) == '+' || expression.charAt(i) == '-')
					&& (expression.charAt(i + 1) == '+' || expression.charAt(i + 1) == '-')) {
				System.out.println("Wrong expression");
				return false;
			}
		}

		if (Character.isDigit(expression.charAt(0)) == false && Character.isDigit(expression.length() - 1) == false) {
			System.out.println("Wrong expression");
			return false;
		}
		System.out.println("Expression is: " + expression);
		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter expression");
		String expression = input.nextLine();
		Stack<Character> stack = new Stack<Character>();
		Queue<Character> queue = new LinkedList<Character>();
		if (isCorrectExpression(expression) == true) {
			for (int i = 0; i < expression.length(); i++) {
				if (Character.isDigit(expression.charAt(i))) {
					queue.offer(expression.charAt(i));
				} else {
					stack.push(expression.charAt(i));
				}

			}
			switch (stack.pop()) {
			case '+':
				queue.offer((char) ((queue.poll() - '0' + queue.poll() - '0') + '0'));
				break;
			case '-':
				queue.offer((char) ((queue.poll() - '0' - queue.poll() - '0') + '0'));
				break;
			}
		}

		input.close();
	}
}
