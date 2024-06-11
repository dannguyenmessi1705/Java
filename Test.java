import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int test = Integer.parseInt(sc.nextLine());
		while(test-- > 0) {
			String op[] = sc.nextLine().split("\\s+");
			System.out.println(Math.pow(Double.parseDouble(op[0]), Double.parseDouble(op[1])));
		}
	}
}