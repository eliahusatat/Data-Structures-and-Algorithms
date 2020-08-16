package hash_table;

import java.util.ArrayList;

public class hash_table<K, V> {

	ArrayList<HNode<K,V>>  bucket ;
	int size;
	int numBuckets; 

	public hash_table() {
		numBuckets = 10;
		size = 0;
		bucket = new ArrayList<HNode<K,V>>();
		for (int i = 0; i < numBuckets; i++) {
			bucket.add(null);
		}
	}
	
	/**
	 * @return the size of the hash table
	 */
	public int getSize() {
		return this.size;
	}
	/**
	 * @return if the hash table is empty
	 */
	public boolean isEmpty() 
	{
		return this.size == 0;
	}
	
	
	/**
	 * return the index in the array according to the hash function (using java hashCode and modulo)
	 * @param key
	 * @return the index
	 */
	private int getBucketIndex(K key) {
		int hashCod = Math.abs(key.hashCode());
		return hashCod % this.numBuckets;
	}
	
	/**
	 * @param key
	 * @return the value associate to this key
	 */
	public V get(K key) {
		int index = getBucketIndex(key);
		HNode<K, V> head = bucket.get(index);
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head= head.next;
		}
		return null;
	}
	
	/**
	 * remove the value associate to this key
	 * @param key
	 * @return return this value
	 */
    public V remove(K key) 
    { 
        // Apply hash function to find index for given key 
        int bucketIndex = getBucketIndex(key); 
  
        // Get head of chain 
        HNode<K, V> head = bucket.get(bucketIndex); 
  
        // Search for key in its chain 
        HNode<K, V> prev = null; 
        while (head != null) 
        { 
            // If Key found 
            if (head.key.equals(key)) 
                break; 
  
            // Else keep moving in chain 
            prev = head; 
            head = head.next; 
        } 
  
        // If key was not there 
        if (head == null) 
            return null; 
  
        // Reduce size 
        size--; 
  
        // Remove key 
        if (prev != null) 
            prev.next = head.next; 
        else
            bucket.set(bucketIndex, head.next); 
  
        return head.value; 
    } 
	
    /**
     * adding new tuple to the hash table
     * @param key
     * @param value
     */
	public void add(K key , V value) {
		int index = getBucketIndex(key);
		HNode<K, V> head = bucket.get(index);
		
	       while (head != null)  // search in the list
	        { 
	            if (head.key.equals(key)) // if the key is already in the hash
	            { 
	                head.value = value; // convert to the new value
	                return; 
	            } 
	            head = head.next; 
	        } 
	        size++; 
	        //insert the new node the be the first in his list
	        head = bucket.get(index); 
	        HNode<K, V> newNode = new HNode<K, V>(key, value); 
	        newNode.next = head; 
	        bucket.set(index, newNode); // the first of this list
	        
	        // to avoid situation that all the keys go the the same list 
	        // if the size gets to 70% of the capacity - we double the capacity
	        // and than add all the node again because - the location of the keys in the hash mapping depends on 
	        // the size of the capacity - so if we change the capacity we need to fix the locations
	        
	        if ((1.0*size)/numBuckets >= 0.7) // if the size gets to 70% of the capacity
	        { 
	            ArrayList<HNode<K, V>> temp = bucket; 
	            bucket = new ArrayList<>(); 
	            numBuckets = 2 * numBuckets;  
	            size = 0; 
	            for (int i = 0; i < numBuckets; i++) //  // double hash table size  
	                bucket.add(null); 
	  
	            for (HNode<K, V> headNode : temp) // go over all the hash table
	            { 
	                while (headNode != null) // go over all the list 
	                { 
	                    add(headNode.key, headNode.value); 
	                    headNode = headNode.next; 
	                } 
	            } 
	        } 
	        
	       
	       
		
	}

}
