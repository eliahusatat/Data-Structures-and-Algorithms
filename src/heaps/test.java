package heaps;

public class test {

	public static void main(String[] args) {
		min_heap mh = new min_heap();
		mh.add(7);
		mh.add(8);
		mh.add(2);
		mh.add(5);
		mh.add(3);
		mh.printArr();
		System.out.println(mh.peek());
		System.out.println(mh.pull());
		mh.printArr();

	}

}
