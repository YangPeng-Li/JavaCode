package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Set2Map<K, V> extends HashSet<SimpleEntry<K, V>> {
	// 实现清空所有Key-Value对的方法
	public void clear() {
		  super.clear();
	}

	// 判断是否包含某个key
	public boolean containsKey(K key) {
		return super.contains(new SimpleEntry<K, V>(key, null));
	}

	boolean containsValue(Object value) {
		for (SimpleEntry<K, V> se : this) {
			if (se.getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	// 根据指定的key取出对应的value
	public V get(Object key) {
		for (SimpleEntry<K, V> se : this) {
			if (se.getKey().equals(key)) {
				return se.getValue();
			}
		}
		return null;
	}

	// 将指定的key-value 对放入集合中
	public V put(K key, V value)

	{
		add(new SimpleEntry<K, V>(key, value));
		return value;
	}

	// 将另一个Map的key-valued对放入Map中
	public void putAll(Map<? extends K, ? extends V> m) {
		for (K key : m.keySet()) {
			add(new SimpleEntry<K, V>(key, m.get(key)));
		}
	}

	/**
	 * @param key
	 * @return
	 */
	// 根据指定的key删除指定的key-value对
	public V removeEntry(Object key) {
		for (Iterator<SimpleEntry<K, V>> it = this.iterator(); it.hasNext();) {
			SimpleEntry<K, V> en = it.next();
			{
				if (en.getKey().equals(key)) {
					V v = en.getValue();
					it.remove();
					return v;
				}
			}
		}
		return null;
	}

}
