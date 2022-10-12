package inheri;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTokenizerEx {
		public void test() {
		String source = "a/b///////d/e/f-asdfa,agadsf,/asdf,,,,,/32-----";
		StringTokenizer st = new StringTokenizer(source, "/-,");
		System.out.println("token size : " + st.countTokens());
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			System.out.println(s);
		}
		System.out.println("-".repeat(25));
		String[] array = source.split("/|-|,");
		System.out.println(Arrays.toString(array));
	}
	public static void main(String[] args) {
		StringTokenizerEx ex = new StringTokenizerEx();
		ex.test();
	}
}
