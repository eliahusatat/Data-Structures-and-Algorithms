package hash_table;

/**
 * this class represent a single node for hash table
 * @author Eliahu Satat
 */
public class HNode<K,V> {
	
	 K key;
	 V value;
     HNode<K,V> next;
    
    public HNode(K k , V value){
    	this.key = k;
    	this.value = value;
    }
}
