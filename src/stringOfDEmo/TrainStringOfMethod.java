package stringOfDEmo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1.ģ��һ��trim()������ȥ���ַ������˵Ŀո�
 * 
 * 2.��һ���ַ������з�ת�����ַ������ƶ����ֽ��з�ת
 * ����abcdefg����תΪ��abfedcg��
 * 
 * 3.��ȡһ���ַ�������һ���ַ����г��ֵĴ����������ȡ
 * ��ab���ڡ�abkkacabkdeaavkkkasdaab���г��ֵĴ���
 * 
 * 4.��ȡ�����ַ����������ͬ�ִ�����
 * Str1 = "abcwerthelloyuiodef" str2="cvhellobnm"
 * ��ʾ�����̵��Ǹ������г������εݼ����Ӵ���ϳ��ıȽ�
 * 
 *  5.���ַ������ַ�������Ȼ˳������
 *  ��ʾ��
 *  	1)�ַ�������ַ�����
 *  	2)����������ѡ��ð�ݣ�Arrays.sort()
 *  	3)���������������ַ���
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
		System.out.println("ת������ַ�����" + st3);

		String st4 = reverseString1(st2, 2, 5);
		System.out.println("ת���ڶ��ַ���:" + st4);

		// 3
		int i = getTime(st1, "ab");
		System.out.println(i);

		// 4
		List<String> st5 = getMaxSubString(st41, st42);
		System.out.println(st5);

		// 5

		String st51 = "adsabfdsc";
		System.out.println("�������" + sortString(st51));

	}

	// ʱ�� ���ռ�ĸ��Ӷ� ������ ���ٿ���Stringbuffer�Ż�
	public static String reverseString1(String str, int start, int end) {
		String str1 = str.substring(0, start); // ��ȡ�±�0-startλ�õ��ַ���
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

		char[] c = str.toCharArray();// �ַ�����---->�ַ�����
		return reverseArray(c, start, end);
	}

	public static String reverseArray(char[] c, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		// �ַ�����---->�ַ���
		return new String(c);
	}

	// 3
	public static int getTime(String st1, String st2) {
		int count = 0;
		int len;
		// �ȽϵĹ��̣�������Ĺ���
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

	// 5 .���ַ�������������Ȼ˳������
	public static String sortString(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);

	}

}
