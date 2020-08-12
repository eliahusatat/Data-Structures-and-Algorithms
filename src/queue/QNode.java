package queue;


/**
 * this class represent a single node for queue for int
 * @author Eliahu Satat
 */
public class QNode implements  Comparable<QNode>{
		private int data;
		private QNode next;
		
		public QNode(int data) {
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

		public QNode getNext() {
			return next;
		}

		public void setNext(QNode next) {
			this.next = next;
		}



		@Override
		public int compareTo(QNode other) {
			// TODO Auto-generated method stub
			return this.data- other.data;
		}

	}



