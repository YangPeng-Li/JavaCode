package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestList {
	
	@Test
	public void test01() 
	{
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		//List的下标从0开始
		System.out.println(list.get(1));
		
		List<Object> linkedList = new  LinkedList<Object>();
		
		linkedList.add("");
	}
}
