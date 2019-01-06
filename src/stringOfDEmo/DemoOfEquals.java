package stringOfDEmo;



/*
 * 任何类的构造器中，调用父类指定的构造器
 * 任何一个类的构造器的首行，要么显式的调用类中重载的其他的构造器  
 * this（形参列表）要么默认的调用父类空参构造器
 * 
 * 
 * 1.Object 是所有类的根父类
 * 2.object类仅有一个空参构造器 public Object()
 * 3.public booleam equals (Object obj)
 * {
 * 	return (this == obj);
 * }
 * == 
 * 1.基本数据类型:根据基本数据类型的值判断是否相等，相等返回true,反之返回false
 * 2.两端数据类型可以不同，在不同的情况下也可以返回true,
 * 3.引用数据类型:比较引用类型变量的地址值是否相等
 * 
 * equals()
 * ① 只能处理引用类型变量 <比较两个引用变量的值是否相等>
 * ② Object 类发现equals()仍然比较的两个引用变量地址值是否相等
 * java.lang.object类是所有类的根父类
 * 
 * >若定义一个类，希望比较两个对象的属性值都能相同 
 */
	public class DemoOfEquals {
	
	public static void main(String[] args) {
		Person p1 = new  Person();
		Person p2 = new  Person();
		System.out.println(p1 == p2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.equals(p2)); //比较两个对象的属性是否相同
		
		
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
		//自定义一个实现Object类的equals()方法
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
			if (this == obj)  //地址值
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass()) //类
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
