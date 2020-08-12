package stack;

import queue.queue;

public class test {

	public static void main(String[] args) throws Exception {
		stack s = new stack();
		System.out.println(s.isEmpty());
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		try {
			System.out.println(s.peek());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s.isEmpty());
		int a;
		try {
			a = s.pop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(s.peek());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s.pop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s.pop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.pop();
		System.out.println(s.isEmpty());
		for (int i = 0; i < 10; i++) {
			s.push(i);
		}
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}

	}

}
