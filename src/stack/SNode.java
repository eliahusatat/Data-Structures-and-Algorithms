package stack;

/**
 * this class represent a single node for stack of int
 * @author Eliahu Satat
 */
public class SNode implements  Comparable<SNode>{

		private int data;
		private SNode next;
		
		public SNode(int data) {
			this.data = data;
			this.next = null;
		}

		/**
		 * getters and setters
		 */
		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public SNode getNext() {
			return next;
		}

		public void setNext(SNode next) {
			this.next = next;
		}



		@Override
		public int compareTo(SNode other) {
			// TODO Auto-generated method stub
			return this.data- other.data;
		}

	}
