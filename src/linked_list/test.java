package linked_list;

public class test {

	public static void main(String[] args) {
		linked_list ll = new linked_list();
		ll.insert_head(1);
		System.out.println(ll.toString1());
		System.out.println(ll.size);
		ll.insert_head(2);
		System.out.println(ll.toString1());
		ll.insert_head(3);
		System.out.println(ll.toString1());
		System.out.println(ll.head.getData());
		ll.insert_tail(4);
		System.out.println(ll.toString1());
		System.out.println(ll.tail.getData());
		System.out.println(ll.contain(5));
		System.out.println(ll.contain(1));
		ll.insert_index(1, 5);
		System.out.println(ll.toString1());
		ll.insert_index(1, 6);
		System.out.println(ll.toString1());
		try {
			ll.delete(6);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(ll.toString1());
		try {
			ll.delete(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ll.toString());
		
		try {
			ll.delete_head();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ll.toString());
		
		try {
			ll.delete_tail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ll.toString());
		System.out.println(ll.size);
		
		int arr [] = {1,2,3,4,5,6,7,8,9};
		linked_list ll1 = new linked_list(arr);
		System.out.println(ll1.toString());
		System.out.println(ll1.sum());

		

	}

}
