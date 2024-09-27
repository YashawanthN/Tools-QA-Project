import java.util.HashSet;
import java.util.Set;

public class hashSet {

	public static void main(String[] args) {
		
		String name = "Yashawanth";
		char[] ch = null;
		for(int i=0; i<name.length();i++)
		{
			ch = name.toCharArray();
		}
		
	 Set<Character> sts = new HashSet<Character>();
		for(char value:ch)
		{
			sts.add(value);
		}
		
		System.out.println(sts);
	}

}
