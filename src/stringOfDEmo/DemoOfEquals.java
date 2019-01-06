package stringOfDEmo;



/*
 * �κ���Ĺ������У����ø���ָ���Ĺ�����
 * �κ�һ����Ĺ����������У�Ҫô��ʽ�ĵ����������ص������Ĺ�����  
 * this���β��б�ҪôĬ�ϵĵ��ø���ղι�����
 * 
 * 
 * 1.Object ��������ĸ�����
 * 2.object�����һ���ղι����� public Object()
 * 3.public booleam equals (Object obj)
 * {
 * 	return (this == obj);
 * }
 * == 
 * 1.������������:���ݻ����������͵�ֵ�ж��Ƿ���ȣ���ȷ���true,��֮����false
 * 2.�����������Ϳ��Բ�ͬ���ڲ�ͬ�������Ҳ���Է���true,
 * 3.������������:�Ƚ��������ͱ����ĵ�ֵַ�Ƿ����
 * 
 * equals()
 * �� ֻ�ܴ����������ͱ��� <�Ƚ��������ñ�����ֵ�Ƿ����>
 * �� Object �෢��equals()��Ȼ�Ƚϵ��������ñ�����ֵַ�Ƿ����
 * java.lang.object����������ĸ�����
 * 
 * >������һ���࣬ϣ���Ƚ��������������ֵ������ͬ 
 */
	public class DemoOfEquals {
	
	public static void main(String[] args) {
		Person p1 = new  Person();
		Person p2 = new  Person();
		System.out.println(p1 == p2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.equals(p2)); //�Ƚ���������������Ƿ���ͬ
		
		
		String st1 ="AA";
		String st2 ="AA";
		String st3 =new String("AA");
		
		System.out.println(st1 == st2);  //true
		System.out.println(st1.equals(st2));//true 
		System.out.println(st1 == st3);//false
		System.out.println(st1.equals(st3)); //true
		
}	
		
}
	
	class Person {
		String name;
		int age;
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
		//�Զ���һ��ʵ��Object���equals()����
//		public boolean equals (Object obj) {
//			if (this == obj) {
//				return true;
//			}
//			if(obj instanceof Person) {
//				Person p =(Person) obj;
//				return this.name == p.name && this.age == p.age;
//			}else
//			{
//				return false;
//			}
//		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)  //��ֵַ
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass()) //��
				return false;
			Person other = (Person) obj; 
			if (age != other.age) 
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
	}
