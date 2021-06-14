package queue;

import stack.Stack;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		q.enqueue("Jisoo");
		q.enqueue("Jennie");
		q.enqueue("Lisa");
		q.enqueue("Rose");
		q.enqueue("Bobbi");
		q.enqueue("Alizabeth");
		for (String str : q) {
			System.out.print(str + " ");
		}
		System.out.println();
		String result = q.dequeue();
		System.out.println("test dequeue()：" + result);
		System.out.println("test size(): " + q.size());
		
		System.out.println("-----------------------------");
		Queue<Integer> q2 = new Queue<>();
		q2.enqueue(2);
		q2.enqueue(58);
		q2.enqueue(17);
		q2.enqueue(230);
		q2.enqueue(89);
		q2.enqueue(103);
		q2.enqueue(47);
		for(int i : q2) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("test dequeue(): " + q2.dequeue());
		System.out.println("test dequeue(): " + q2.dequeue());
		System.out.println("test size(): " + q2.size());
	}
}
