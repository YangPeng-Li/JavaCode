package stringOfDEmo;

import org.junit.Test;

/*
 * String 方法
 * 
 * 
 * length :
 * 
 * char chartAt(int index) 返回指定索引的的字符
 * 
 * int  compareTo(String anotherString)
 * 
 * int indexOf(String s),返回s字符串首次出现的位置
 * int indexOf(String s, int startpoint)
 * 
 * int lastIndexOf(String s)返回s字符串在当前字符串出现的最后一次
 * int lastIndexOf(String s, int startpoint)返回S字符从当前字符串startpoint位置开始，首次出位置
 * 
 * boolean contains 
 * boolean StartsWith(String prefix)//判断当前字符串是否以prefix开始
 * boolean endWith(String suffix)判单当前字符串是否已suffix结束
 * boolean regionMatches(int firstStart,String other,int OtherStart, int length)
 * 
 * firstStart开始的子串与另一个字符串other从otherstart开始，lenth长度的字串是否equals
 * 
 */
public class StringOfMethod {


	@Test
	public void test1() {
		String str1 = "abccdefghijkbcc";
		String 	str2 ="bccv";
		String str3 = "jkbcc";
		System.out.println(str1.charAt(3)); //a
		
		char v1 ='a';
		char v2 = 'b';
		System.out.println(v2-v1);
		
		System.out.println(str1.compareTo(str2)+"compareTo");
		System.out.println(str1.indexOf("bcAc"));//1
		System.out.println(str1.lastIndexOf("bccc"));//12
		System.out.println(str1.indexOf("bcc",4));//从第四个位置开始
		System.out.println(str1.startsWith("bcc"));
		System.out.println(str1.endsWith(str2));
		System.out.println("contains------>"+str3.contains(str2));
		
		//判断长度是否相等
		System.out.println(str1.regionMatches(12, str3, 2, str3.length()-2));
	}
	
	/*String subString (int startpoint) //左闭右开的
	 * String subString (int start,int end) //
	 * String replace (char oldChar ,char newChar)//替换
	 * String replaceAll(String old,String new)
	 * String trim() 取出当前字符串首位的空格
	 * String concat(String str) 连接当前字符串
	 * String [] split(String regex) 
	 * 
	 * 
	 * 按照regex当前字符串拆分，拆分成多个字符串
	 * 
	 */
	@Test 
	public void tets1()
	{
		String str1 = "NJBWFEDUNJ";
		String str2 = "XABWFEDU";
		String str3 = "SHBWFEDU";
		
		//System.out.println(str2);
		String str4 = str1.substring(2,8);
		System.out.println(str4);
		String str5 =	str1.replaceAll("NJ", "BJ");
		System.out.println(str5);
		
		String str6 = "   abc  d   ";
		String str7 = str6.trim();
		System.out.println("Str7trim()---"+str7);
		String str8 = str1.concat(str2);
		System.out.println("连接当前字符"+str8);
		
		
		
		String str9 = "abc*d-e7f-ke";
		String strs[] = str9.split("-");
		for(int i= 0;i<strs.length;i++)
		{
			System.out.println(strs[i]);
		}
	}
	
	@Test
	public void test21() 
	{
		String  re = "EC:";
		
		int i = re.indexOf("IC:");
		int j = re.indexOf("EC:");
		if (i<0 || j<0 )
		{
			System.out.println("输入备注格式错误");
		}
		System.out.println("i----0"+i);
		System.out.println("j-----"+j);
		String ic =re.substring(i+3,j);
		String ec = re.substring(j+3);
		System.out.println(ic);
		System.out.println(ec);
	}
	
	
}
		