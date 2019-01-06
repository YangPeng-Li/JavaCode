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
	
	//��Ĭ�����鳤�ȴ�����˳�����Ա�
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
	 * һֱ�����ȵ�����������˳�����Ա�
	 * @param element  ִ��˳�����Ա��е�һ��Ԫ��
	 * @param initSize ָ��˳�����Ա�ײ����ֵĳ���
	 */
	public SequenceList (T element ,int initSize) 
	{
		capacity = 1;
		//��capacity ��Ϊ���� initSize  �� ��С2��n�η�
		while (capacity <initSize)
		{
			/*	a = 8
			 *  a >>=3
			 *  0000 0100
			 *  0000 0001
			 *  a =1
			 *  ��ʾ�Ѷ����� a ���� b  λ
			 *   
			 */
			
			capacity <<=1;
			elementData = new  Object[capacity];
			elementData [0] =element;
			size++;
			
		}
		logger.info("���Ǹ�����"+capacity);
	}
	//��ȡ˳�����Ա�Ĵ�С
	public int length()
	{
		return size;
	}
	
	//����˳�����Ա�������Ϊ i����Ԫ��
	@SuppressWarnings("unchecked")
	public T get(int i)
	{
		if(i<0 || i>size-1)
		{
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		return (T)elementData[i];
	}
	//����˳�����Ա���ָ��Ԫ�ص�����
	
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
	
	
	//��˳�����Ա�ָ��λ�ò���һ��Ԫ��
	public void insert (T element,int index)
	{
		if(index <0 || index >size)
		{
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		ensureCapacity( size + 1);
		//��index ���Ժ������Ԫ�������ƶ�һ��
		System.arraycopy(elementData,index,elementData,index+1,size-index);	
		elementData[index] = element;
		size++;
	}
	//�����Ա�Ŀ�ʼ���һ��Ԫ��
	public void add (T element)
	{
		insert(element,size);
	}
	
	//����ײ����鳤�ȣ����鷳���������ܲ�
	private void ensureCapacity (int minCapacity)
	{
		//��������ԭ�г���С��Ŀǰ����ĳ���
		if(minCapacity > capacity)
		{
			//���ϵĽ�capacity * 2 ֱ��capacity ����minCapacityΪֹ
			while (capacity < minCapacity)
			{
				capacity <<=1;
			}
			elementData = Arrays.copyOf(elementData, capacity);
		}
	}
	
	//ɾ��˳�����Ա���ָ����������Ԫ��
	@SuppressWarnings("unchecked")
	public T delete(int index)
	{
		if(index< 0 || index >size -1)
		{
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		T oldValue = (T)elementData[index];
		int numMoved = size - index - 1;
		
		if(numMoved >0) 
		{
			System.arraycopy(elementData,index+1,elementData,index,numMoved);
		}
		//������һ��Ԫ��
		elementData[--size] = null;
		return oldValue;
	}
	//ɾ��˳�����Ա������һ��Ԫ��
	public T remove ()
	{
		return delete(size -1);
	}
	//�ж�˳�����Ա��Ƿ�Ϊ�ձ�
	public boolean Isempty ()
	{
		return size == 0;
	}
	
	//������Ա�
	
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
