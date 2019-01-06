package stringOfDEmo;


/*
 * toString()方法
 * java.lang.Object 类的toString
 *    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
 * String 重写了Object的toString的方法
 * 
 * 1.当我们打印一个对象的引用时，实际上默认调用的就是这个对象的toString()方法
 * 2.当我们打印的对象所在的类没有重写Object中toString()方法时，那么调用就是Object中定义的toString
 * 	返回此对象的类及对应的对空间对象实体的首地址值
 * 3.当我们打印的对象所在类重写了toString()方法时，调用的就是我们自己重写的toString()方法 
 * 	常常这样重写，将对象的属性信息返回。
 * 4.像 String类、包装类、File类、 Date类，已经实现了Object类中的toString()方法的重写
 */
public class DemoOfToString {
	public static void main(String[] args) {
		Person2 p1 = new Person2("AA",11);
		System.out.println(p1.toString());
		System.out.println(p1);//在没有重写toString打印的是地址值
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