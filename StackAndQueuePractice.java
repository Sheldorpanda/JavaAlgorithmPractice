package algorithmPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueuePractice {

	public static void main(String[] args) {

		// Stack: Last In First Out
		Stack<Integer> S = new Stack<Integer>();

		// Push
		// S.top > n: overflow
		for (int i = 0; i < 10; i++) {
			S.push(i);
			System.out.println(S);
		}

		// Pop
		// Pop an empty stack: underflow
		while (!S.isEmpty()) {
			S.pop();
			System.out.println(S);
		}

		System.out.println();

		// Queue: First In First Out
		// Queue is an interface in Java, use LinkedList to instantiate
		Queue<Integer> Q = new LinkedList<Integer>();

		// Enqueue
		for (int i = 0; i < 10; i++) {
			Q.add(i);
			System.out.println(Q);
		}

		// Dequeue
		while (!Q.isEmpty()) {
			Q.poll();
			System.out.println(Q);
		}

	}

}
