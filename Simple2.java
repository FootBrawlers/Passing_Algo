import java.util.*;
import java.lang.*;
class Simple2
{
	public static void main(String args[])
	{
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Scanner sc = new Scanner(System.in);
        	Integer a=sc.nextInt();
        	Integer b=sc.nextInt();
   	     	ArrayList<Integer> temp = new ArrayList<Integer>();
        	temp.add(a);
        	temp.add(a);
        	list.add(temp);
		System.out.println(list);

	}
}