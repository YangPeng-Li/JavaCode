package collection;

public class Set2MapTest {
	
	public static void main(String[] args) {
		Set2Map <String ,Integer> scores = new Set2Map<>();	
		scores.put("YW",90);
		scores.put("SX",99);
		scores.put("EW",89);
		System.out.println(scores);
		
		scores.removeEntry("SX");
		System.out.println("删除Key 为\"数据\"的Entry之后"+scores);
		
		System.out.println("YW的成绩："+scores.get("YW"));
		
		System.out.println("是否包含\"英文\"key:"+scores.containsKey("EW"));
		
		System.out.println("是否包含82 Value:"+scores.containsValue(89));
		
		scores.clear();
		
		System.out.println("执行清空Clrear()方法：之后的集合："+scores);
	}

}
