package stringOfDEmo;

import org.junit.Test;

/*
 * String ����
 * 
 * 
 * length :
 * 
 * char chartAt(int index) ����ָ�������ĵ��ַ�
 * 
 * int  compareTo(String anotherString)
 * 
 * int indexOf(String s),����s�ַ����״γ��ֵ�λ��
 * int indexOf(String s, int startpoint)
 * 
 * int lastIndexOf(String s)����s�ַ����ڵ�ǰ�ַ������ֵ����һ��
 * int lastIndexOf(String s, int startpoint)����S�ַ��ӵ�ǰ�ַ���startpointλ�ÿ�ʼ���״γ�λ��
 * 
 * boolean contains 
 * boolean StartsWith(String prefix)//�жϵ�ǰ�ַ����Ƿ���prefix��ʼ
 * boolean endWith(String suffix)�е���ǰ�ַ����Ƿ���suffix����
 * boolean regionMatches(int firstStart,String other,int OtherStart, int length)
 * 
 * firstStart��ʼ���Ӵ�����һ���ַ���other��otherstart��ʼ��lenth���ȵ��ִ��Ƿ�equals
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
		System.out.println(str1.indexOf("bcc",4));//�ӵ��ĸ�λ�ÿ�ʼ
		System.out.println(str1.startsWith("bcc"));
		System.out.println(str1.endsWith(str2));
		System.out.println("contains------>"+str3.contains(str2));
		
		//�жϳ����Ƿ����
		System.out.println(str1.regionMatches(12, str3, 2, str3.length()-2));
	}
	
	/*String subString (int startpoint) //����ҿ���
	 * String subString (int start,int end) //
	 * String replace (char oldChar ,char newChar)//�滻
	 * String replaceAll(String old,String new)
	 * String trim() ȡ����ǰ�ַ�����λ�Ŀո�
	 * String concat(String str) ���ӵ�ǰ�ַ���
	 * String [] split(String regex) 
	 * 
	 * 
	 * ����regex��ǰ�ַ�����֣���ֳɶ���ַ���
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
		System.out.println("���ӵ�ǰ�ַ�"+str8);
		
		
		
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
			System.out.println("���뱸ע��ʽ����");
		}
		System.out.println("i----0"+i);
		System.out.println("j-----"+j);
		String ic =re.substring(i+3,j);
		String ec = re.substring(j+3);
		System.out.println(ic);
		System.out.println(ec);
	}
	
	
}
		