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

	// �ı��key-value��valueֵ
	@Override
	public V setValue(V value) {
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	// ����Key�Ƚ�����SimpleEntry�Ƿ����
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

	// ����Key����hashCode
	public int hashCode() {
		return key == null ? 0 : key.hashCode();
	}

	public String toString() {
		return key + "=" + value;
	}

	// �̳�HashSetʵ��һ��Map

}
