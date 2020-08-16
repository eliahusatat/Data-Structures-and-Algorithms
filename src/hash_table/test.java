package hash_table;

public class test {

	public static void main(String[] args) {
		hash_table<String ,Integer> ht = new hash_table();
		String arr []= {"eliahu", "satat","eliahu", "satat", "eliahu"};

		for (String string : arr) {
			if(ht.get(string) == null) {
				ht.add(string, 1);
			}
			else {
				ht.add(string, ht.get(string)+1);
			}
		}
		System.out.println(ht.get("eliahu"));
		System.out.println(ht.get("satat"));
		ht.remove("satat");
		System.out.println(ht.get("eliahu"));
		System.out.println(ht.get("satat"));

	
	}

	}


