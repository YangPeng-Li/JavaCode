package collection;

public class Set2MapTest {
	
	public static void main(String[] args) {
		Set2Map <String ,Integer> scores = new Set2Map<>();	
		scores.put("YW",90);
		scores.put("SX",99);
		scores.put("EW",89);
		System.out.println(scores);
		
		scores.removeEntry("SX");
		System.out.println("ɾ��Key Ϊ\"����\"��Entry֮��"+scores);
		
		System.out.println("YW�ĳɼ���"+scores.get("YW"));
		
		System.out.println("�Ƿ����\"Ӣ��\"key:"+scores.containsKey("EW"));
		
		System.out.println("�Ƿ����82 Value:"+scores.containsValue(89));
		
		scores.clear();
		
		System.out.println("ִ�����Clrear()������֮��ļ��ϣ�"+scores);
	}

}
