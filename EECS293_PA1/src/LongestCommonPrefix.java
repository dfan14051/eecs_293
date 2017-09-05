import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.*;

public class LongestCommonPrefix {
	
	static <T> List<T> longestPrefix(List<T> a, List<T> b, Comparator<? super T> cmp){
		
		List<T> prefix = new LinkedList<T>();
		
		Iterator<T> it_a = a.iterator();
		Iterator<T> it_b = b.iterator();
		T a_temp, b_temp;
		
		while(it_a.hasNext() && it_b.hasNext()){
			a_temp = it_a.next();
			b_temp = it_b.next();
			if(cmp.compare(a_temp, b_temp) == 0){
			prefix.add(a_temp);
			}
		}
		return prefix;
	}

	public static void main(String[] args) {
		if(args.length == 2){
			String string1 = args[0];
			String string2 = args[1];
			List<String> list1 = new LinkedList<String>();
			for(char c : string1.toCharArray()){
				list1.add("" + c);
			}
			List<String> list2 = new LinkedList<String>();
			for(char c : string2.toCharArray()){
				list2.add("" + c);
			}
			List<String> prefix = longestPrefix(list1, list2, String.CASE_INSENSITIVE_ORDER);
			System.out.println(String.join("", prefix));
		}
		else{
			System.err.println("Please enter two input strings");
		}

	}

}
