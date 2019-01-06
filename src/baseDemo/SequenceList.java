package baseDemo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.slf4j.LoggerFactory;


public class SequenceList <T>{
	//private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SequenceList.class);
	Logger logger = LoggerFactory.getLogger(SequenceList.class);
	private int DEFAULT_SIZE= 16;
	private int capacity;
	private Object [] elementData;
	private int size = 0;
	
	//以默认数组长度创建空顺序线性表
	public SequenceList ()
	{
		capacity = DEFAULT_SIZE;
		elementData = new Object [capacity];
	}
	
	public SequenceList(T element) 
	{
		this();
		elementData[0]  = element;
		size++;
	}
	
	/**
	 * 一直盯长度的数组来创建顺序线性表
	 * @param element  执行顺序线性表中第一个元素
	 * @param initSize 指定顺序线性表底层数字的长度
	 */
	public SequenceList (T element ,int initSize) 
	{
		capacity = 1;
		//把capacity 设为大于 initSize  的 最小2的n次方
		while (capacity <initSize)
		{
			/*	a = 8
			 *  a >>=3
			 *  0000 0100
			 *  0000 0001
			 *  a =1
			 *  表示把二进制 a 右移 b  位
			 *   
			 */
			
			capacity <<=1;
			elementData = new  Object[capacity];
			elementData [0] =element;
			size++;
			
		}
		logger.info("这是个数字"+capacity);
	}
	//获取顺序线性表的大小
	public int length()
	{
		return size;
	}
	
	//查找顺序线性表中索引为 i处的元素
	@SuppressWarnings("unchecked")
	public T get(int i)
	{
		if(i<0 || i>size-1)
		{
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		return (T)elementData[i];
	}
	//查找顺序线性表中指定元素的索引
	
	public int locate (T element)
	{
		for (int i=0;i<size;i++) 
		{
			if(elementData[i].equals(element))
			{
				return i;
			}
		}
		return -1;
	}
	
	
	//向顺序线性表指定位置插入一个元素
	public void insert (T element,int index)
	{
		if(index <0 || index >size)
		{
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		ensureCapacity( size + 1);
		//将index 处以后的所有元素往后移动一格
		System.arraycopy(elementData,index,elementData,index+1,size-index);	
		elementData[index] = element;
		size++;
	}
	//在线性表的开始添加一个元素
	public void add (T element)
	{
		insert(element,size);
	}
	
	//扩充底层数组长度，很麻烦，而且性能差
	private void ensureCapacity (int minCapacity)
	{
		//如果数组的原有长度小于目前所需的长度
		if(minCapacity > capacity)
		{
			//不断的将capacity * 2 直到capacity 大于minCapacity为止
			while (capacity < minCapacity)
			{
				capacity <<=1;
			}
			elementData = Arrays.copyOf(elementData, capacity);
		}
	}
	
	//删除顺序线性表中指定索引处的元素
	@SuppressWarnings("unchecked")
	public T delete(int index)
	{
		if(index< 0 || index >size -1)
		{
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		T oldValue = (T)elementData[index];
		int numMoved = size - index - 1;
		
		if(numMoved >0) 
		{
			System.arraycopy(elementData,index+1,elementData,index,numMoved);
		}
		//清空最后一个元素
		elementData[--size] = null;
		return oldValue;
	}
	//删除顺序线性表中最后一个元素
	public T remove ()
	{
		return delete(size -1);
	}
	//判断顺序线性表是否为空表
	public boolean Isempty ()
	{
		return size == 0;
	}
	
	//清空线性表
	
	public void  clear ()
	{
		Arrays.fill(elementData, null);
	}
	
	public String toString ()
	{
		if (size == 0)
		{
			return "[]";
		}
		else
		{
			StringBuilder sb = new StringBuilder("[");
			for (int i=0;i<size;i++)
			{
				sb.append(elementData[i].toString()+",");
			}
			
			int len  = sb.length();
			
			return sb.delete(len-2,len).append("]").toString();
			
		}
		
	}
	
}
