package collection;

import java.io.Serializable;
import java.util.Map;

public class SimpleEntry<K, V> implements Map.Entry<K, V>, Serializable {
	private final K key;
	private V value;

	public SimpleEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public SimpleEntry(Map.Entry<? extends K, ? extends V> entry) {
		this.key = entry.getKey();
		this.value = entry.getValue();
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	// 改变该key-value的value值
	@Override
	public V setValue(V value) {
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	// 根据Key比较两个SimpleEntry是否相等
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o.getClass() == SimpleEntry.class) {
			SimpleEntry se = (SimpleEntry) o;
			return se.getKey().equals(getKey());
		}
		return false;
	}

	// 根据Key计算hashCode
	public int hashCode() {
		return key == null ? 0 : key.hashCode();
	}

	public String toString() {
		return key + "=" + value;
	}

	// 继承HashSet实现一个Map

}
