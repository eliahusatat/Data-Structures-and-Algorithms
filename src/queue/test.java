package queue;

public class test {

	public static void main(String[] args) throws Exception {
		queue q = new queue();
		System.out.println(q.isEmpty());
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		System.out.println(q.peek());
		System.out.println(q.isEmpty());
		int a =q.pop();
		System.out.println(a);
		System.out.println(q.peek());
		q.pop();
		q.pop();
		q.pop();
		System.out.println(q.isEmpty());
		for (int i = 0; i < 10; i++) {
			q.push(i);
		}
		while(!q.isEmpty()) {
			System.out.println(q.pop());
		}

	}

}
