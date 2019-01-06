package io.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * 
 * @author Lyp
 * @date 2018��12��20��
 * @version 1.0
 */
public class TimeClientHandle implements Runnable {
	
	private String host;
	private int port;
	private Selector selector;
	private SocketChannel  socketChannel;
	private volatile boolean stop;

	/**
	 * 
	 * �ٹ��캯�����ڳ�ʼ��NIO �Ķ�·��������SocketChannel������ע�����
	 * ����SocketChannel֮����Ҫ��������Ϊ�첽������ģʽ������SocketChannerl��TCP���������պͷ��͵�TCP��������С
	 * 
	 * 
	 * @param host
	 * @param port
	 */
	public TimeClientHandle (String host,int port)
	{
		this.host = host == null ? "127.0.0.1" : host;
		this.port = port;
		
		try {
			selector=Selector.open();
			socketChannel=SocketChannel.open();
			socketChannel.configureBlocking(false);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	@Override
	public void run() 
	{
		/*
		 * �����ڷ�������������Ϊʾ���������ǳɹ��ģ����Բ���Ҫ����������
			��˽���ŵ�ѭ��֮ǰ��
		 */
		try {
			doConnect();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		 * ����ѭ��������ѯ��·������selector ���о�����Channelʱ��ִ�� handleInput(key)����
		 */
		
		while (!stop)
		{
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectedKeys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext())
				{
					key = iterator.next();
					iterator.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if(key !=null)
						{
							key.cancel();
							if(key.channel() !=null)
							{
								key.channel().close();
							}
						}
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		/*
		 * ��·�������ر�֮������ע���������Channel��Pipe����Դ���ᱻ�Զ��رղ���Ҫ�ظ��ͷ�
		 * ��·����������Դ�ͷţ����ڶ�·��·�������Ͽ���ע���ǧ�����Channel����pipe
		 * ���һһ����Щ��Դ�ͷ���Ȼ�����ʵģ�JDK�ײ���Զ��ͷ����и��˶�·��������������Դ	
		 */
		if(selector !=null)
		{
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * �����ȶ�SelectionKey�����жϣ���������ʲô״̬�������������״̬��˵��������Ѿ�����ACKӦ����Ϣ����ʱ��Ҫ�����ӽ�������ж�
	 * ����Socketchannel��finishConnect()�������������true ,˵���ͻ������ӳɹ�����false����ֱ���׳�IOEXception������ʧ��
	 * ��SocketChannelע�ᵽ��·�������ϣ�ע��SelectionKey.OP_READ����λ���������������Ȼ����������Ϣ �������
	 * 
	 * 
	 * 	
	 * @param key
	 * @throws IOException
	 */
	private void handleInput(SelectionKey key) throws IOException {
		if (key.isValid())
		{
			SocketChannel sc = (SocketChannel) key.channel();
			if(key.isConnectable())
			{
				if(sc.finishConnect())
				{
					sc.register(selector, SelectionKey.OP_READ);
					doWrite(sc);
				}
				else
				System.exit(1);//����ʧ�� ,�����˳�
			}
			/*
			 * �� ���������ͻ�������ζ�ȡʱ�������Ӧ����Ϣ������ͻ����յ������Ӧ����Ϣ����SocketChannel�ǿɶ�,����ʵ���޷��ж�Ӧ�������Ĵ�С
			 * ���Ƿ���1MB�Ľ��ջ��������ڶ�ȡӦ����Ϣ������SocketChannel��read()���������첽��ȡ�������������첽���������Ա���Զ�ȡ�Ľ�������ж�
			 * ��ȡ������Ϣ�������Ϣ���н��룬����ӡ�����ִ�����stop��Ϊtrue,�߳��˳�ѭ��
			 * 
			 */
			
			if(key.isReadable())
			{
				ByteBuffer readBuffer =  ByteBuffer.allocate(1024);
				int readBytes =  sc.read(readBuffer);
				if(readBytes >0)
				{
					readBuffer.flip();
					byte [] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new  String (bytes,"UTF-8");
					System.out.println("Now is"+body);
					this.stop = true;
				}
				else if(readBytes < 0)
				{
					// �Զ���·�ر�
					key.cancel();
					sc.close();
				}
				else
					;//����0�ֽڣ�����
			}
		}
	}

	/**
	 * 
	 * 	��������ӳɹ�����SocketChannelע�ᵽ��·������Selector�ϣ�ע��Selection.OP_READ�����û�����ӳɹ�����˵�������û�з���
 	 *	TCP����Ӧ����Ϣ�����ⲻ��������ʧ�ܣ�������Ҫ��SocketChannelע����·������Selector�ϣ�ע��SelectionKey.OP_CONNECT
	 *	������������syn-ack��Ϣ��selector����ѯ�����SocketChannel���ھ���״̬
	 *	����������Ϣ����Ӧ
	 * @throws IOException
	 */
	private void doConnect() throws IOException {

		if(socketChannel.connect(new InetSocketAddress(host, port)))
		{
			socketChannel.register(selector, SelectionKey.OP_READ);
			doWrite(socketChannel);
		}
		else
			socketChannel.register(selector,SelectionKey.OP_CONNECT);
	}	
	
	
	/**
	 * ���ǹ���������Ϣ�壬Ȼ�������룬д�뵽���ͻ������У�������SocketChannel��write�������з��͡����ڷ������첽��
	 * ���Դ��ڡ����д�����⣬[�޴���]�����ͨ��hasRemaining()�����Է��ͽ�������жϣ�����������е���Ϣȫ��������ɴ�ӡ��Send order 2 server��
	 * 
	 * @param sc
	 * @throws IOException
	 */
	private void doWrite(SocketChannel sc) throws IOException {
		byte req [] = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
		writeBuffer.put(req);
		writeBuffer.flip();
		sc.write(writeBuffer);
		if(!writeBuffer.hasRemaining())
		{
			System.out.println("Send oreder 2 server succeed");
		}
	}

}
