package stringOfDEmo;


/*
 * toString()����
 * java.lang.Object ���toString
 *    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
 * String ��д��Object��toString�ķ���
 * 
 * 1.�����Ǵ�ӡһ�����������ʱ��ʵ����Ĭ�ϵ��õľ�����������toString()����
 * 2.�����Ǵ�ӡ�Ķ������ڵ���û����дObject��toString()����ʱ����ô���þ���Object�ж����toString
 * 	���ش˶�����༰��Ӧ�ĶԿռ����ʵ����׵�ֵַ
 * 3.�����Ǵ�ӡ�Ķ�����������д��toString()����ʱ�����õľ��������Լ���д��toString()���� 
 * 	����������д���������������Ϣ���ء�
 * 4.�� String�ࡢ��װ�ࡢFile�ࡢ Date�࣬�Ѿ�ʵ����Object���е�toString()��������д
 */
public class DemoOfToString {
	public static void main(String[] args) {
		Person2 p1 = new Person2("AA",11);
		System.out.println(p1.toString());
		System.out.println(p1);//��û����дtoString��ӡ���ǵ�ֵַ
	}
	
}
class Person2 {
	private String name;
	private int age;
	public Person2(String name, int age ) {
		this.name =name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Person2 [name=" + name + ", age=" + age + "]";
	}
	
	
}