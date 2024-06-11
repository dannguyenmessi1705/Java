import java.util.Scanner;

class Test
{
	private static int reverse(int n) {
		int rev = 0;
		while(n > 0) {
			rev = rev * 10 + n % 10;
			n /= 10;
		}
		return rev;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int test = Integer.parseInt(sc.nextLine());
		int i = 1;
		while(test-- > 0) {
			String []op = sc.nextLine().split("\\s+");
			System.out.println(reverse(reverse(Integer.parseInt(op[0])) + reverse(Integer.parseInt(op[1]))));
		}
	}
}