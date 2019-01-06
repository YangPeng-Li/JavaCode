package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Set2Map<K, V> extends HashSet<SimpleEntry<K, V>> {
	// ʵ���������Key-Value�Եķ���
	public void clear() {
		  super.clear();
	}

	// �ж��Ƿ����ĳ��key
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

	// ����ָ����keyȡ����Ӧ��value
	public V get(Object key) {
		for (SimpleEntry<K, V> se : this) {
			if (se.getKey().equals(key)) {
				return se.getValue();
			}
		}
		return null;
	}

	// ��ָ����key-value �Է��뼯����
	public V put(K key, V value)

	{
		add(new SimpleEntry<K, V>(key, value));
		return value;
	}

	// ����һ��Map��key-valued�Է���Map��
	public void putAll(Map<? extends K, ? extends V> m) {
		for (K key : m.keySet()) {
			add(new SimpleEntry<K, V>(key, m.get(key)));
		}
	}

	/**
	 * @param key
	 * @return
	 */
	// ����ָ����keyɾ��ָ����key-value��
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
