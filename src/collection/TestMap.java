package collection;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.slf4j.LoggerFactory;

public class TestMap implements  Map<String ,String>{
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestMap.class);
	@Test
	public void Test01()
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("1", "one");
		map.put("2","two");
		map.put("3", "Three");
		
		
		System.out.println("map.size"+map.size());
		System.out.println(map);
		Set<String> set1 = map.keySet();
		for (String key :set1)
		{
			String value = map.get(key);
			System.out.println(key+"--------"+value);
			int hashCode = map.hashCode();
			System.out.println("hashCode--"+hashCode);
		}
		
		logger.info(String.valueOf(map.size()));
		
		//获取所有键值对对象的集合
		Set <Map.Entry<String,String>> set = map.entrySet();
		//遍历键值对对象的集合，得到每一个键值对对象
		for (Map.Entry<String, String> me : set)
		{
			String  key = me.getKey();
			String  value =  me.getValue();
			System.out.println(key+"----------"+value);
		}
	}
	

	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String put(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void putAll(Map<? extends String, ? extends String> m) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection<String> values() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<Entry<String, String>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	
}




