package stringOfDEmo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1.模拟一个trim()方法，去除字符串两端的空格
 * 
 * 2.将一个字符串进行反转，将字符串中制定部分进行反转
 * 将“abcdefg”反转为“abfedcg”
 * 
 * 3.获取一个字符串在另一个字符串中出现的次数：比如获取
 * “ab”在“abkkacabkdeaavkkkasdaab”中出现的次数
 * 
 * 4.获取两个字符串中最大相同字串比如
 * Str1 = "abcwerthelloyuiodef" str2="cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的比较
 * 
 *  5.对字符串中字符进行自然顺序排序
 *  提示：
 *  	1)字符串变成字符数组
 *  	2)对数组排序，选择，冒泡，Arrays.sort()
 *  	3)将排序后的数组编程字符串
 * 
 */
public class TrainStringOfMethod {

	public static void main(String[] args) {
		String str = "  ab c   ";

		String st1 = "absdaavabdasdasdabdsadabsdaab";
		String st41 = "abcwerthelloyuiodef";
		String st42 = "cvhellobnm";
		String s = myTrim(str);
		System.out.println(s);

		String st2 = "abcdefg";
		String st3 = reverseString(st2, 2, 5);
		System.out.println("转化后的字符串：" + st3);

		String st4 = reverseString1(st2, 2, 5);
		System.out.println("转换第二种方法:" + st4);

		// 3
		int i = getTime(st1, "ab");
		System.out.println(i);

		// 4
		List<String> st5 = getMaxSubString(st41, st42);
		System.out.println(st5);

		// 5

		String st51 = "adsabfdsc";
		System.out.println("第五个提" + sortString(st51));

	}

	// 时间 、空间的复杂度 方法二 ，再考虑Stringbuffer优化
	public static String reverseString1(String str, int start, int end) {
		String str1 = str.substring(0, start); // 读取下边0-start位置的字符串
		for (int i = end; i >= start; i--) {
			char c = str.charAt(i);
			str1 += c;
		}
		str1 += str.substring(end);
		return str1;
	}

	// 1
	public static String myTrim(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start < end && str.charAt(start) == ' ') {
			start++;
		}
		while (start < end && str.charAt(end) == ' ') {
			end--;
		}

		return str.substring(start, end + 1);
	}

	// 2
	public static String reverseString(String str, int start, int end) {

		char[] c = str.toCharArray();// 字符串到---->字符数组
		return reverseArray(c, start, end);
	}

	public static String reverseArray(char[] c, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		// 字符数组---->字符串
		return new String(c);
	}

	// 3
	public static int getTime(String st1, String st2) {
		int count = 0;
		int len;
		// 比较的过程，就是想的过程
		while ((len = st1.indexOf(st2)) != -1) {
			count++;
			st1 = st1.substring(len + st2.length());
		}
		return count;
	}

	// 4
	public static List<String> getMaxSubString(String st1, String st2) {
		String maxStr = (st1.length() > st2.length()) ? st1 : st2;
		String minStr = (st1.length() < st2.length()) ? st1 : st2;
		int len = minStr.length();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			for (int x = 0, y = len - i; y <= len; x++, y++) {
				String str = minStr.substring(x, y);
				if (maxStr.contains(str)) {
					list.add(str);
				}
			}
			if (list.size() != 0) {
				return list;
			}
		}

		return null;
	}

	// 5 .对字符串进行排序自然顺序排序
	public static String sortString(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);

	}

}
