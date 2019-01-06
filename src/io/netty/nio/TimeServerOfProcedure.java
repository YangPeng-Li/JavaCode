package io.netty.nio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * 
 * @author Lyp
 * @date 2018��12��19��
 * @version 1.0
 * 
 * ���
 * NIO���ٷ���֮ΪNew I/O��� Ŀ������java ֧�ַ�����I/O,�����˳�֮Ϊ������(Non-block I/O)
 * BIO��(Block IO)
 * 
 * Socket���ServerSocket ���Ӧ NIO �ṩ��SocketChannel ��ServerSocketChannel ���ֲ�ͬ���׽���ͨ��ʵ��
 * �������������׽��־�֧�������ͷ���������ģʽ
 * ���ڵ͸��أ��Ͳ�����Ӧ�ó������ѡ��ͬ������I/O
 * ���ڸ߲������߸��ص�����Ӧ����Ҫʹ��NIO�ķ�����ģʽ���п���
 * 
 * �ڱ�׼Java �������ṩ�˸��ٵ�������I/O ,ͨ������������ݵ��࣬�Լ�ͨ�������ʽ������Щ���ݣ�NIO ����ʹ�ñ��ش���Ϳ������õͼ��Ż���
 *
 * 
 */

public class TimeServerOfProcedure {
	
	public static void main(String[] args) {
	/*	int port = 8080;
		//����һ��		��ServerSocketChannel ���ڼ����ͻ��˵����ӣ��������пͻ������ӵĸ��ܵ�
		ServerSocketChannel acceptorSvr = ServerSocketChannel.open();
		//�������		�󶨼����˿ڣ���������Ϊ������ģʽ��
		acceptorSvr.socket().bind(new InetSocketAddress (InetAddress.getByName("IP"),port));
		acceptorSvr.configureBlocking(false);
		//��������		����Reactor�̣߳�������·���ò������߳�
		Selector selector = Selector.open();
		new Thread(new ReactorTask()).start();;
		//�����ģ�		��serverSocketChannerlע�ᵽReactor�̵߳Ķ�·��������Selector�ϣ�����Accept�¼�
		acceptorSvr.register(selector, SelectionKey.OP_ACCEPT,ioHandler);
		//������ ��		��·���������߳�run����������ѭ������ ��ѯ׼��������Key,
		int num = 	selector.select();
		Set selectedKeys= selector.selectedKeys();
		Iterator iterator  =selectedKeys.iterator();
		while (iterator.hasNext())
		{
			SelectionKey next = (SelectionKey) iterator.next();
		}
		//	������	��·�����������������¿ͻ��˽��룬�����¿ͻ��˽�����������TCP�������֣�����������·
		SocketChannel channel = svrchannel.accept();
		
		
		
		//������:		���ÿͻ��˵���·Ϊ������ģʽ
		channel.configureBlocking(false);
		channel.socket().setReuseAddress(true);
		//����� :		���½��뵽�Ŀͻ�����ע�ᵽReador�̵߳Ķ�·�������ϣ���������������ȡ�ͻ��˷��͵�������Ϣ
		SelectionKey key = channel.register(selector, SelectionKey.OP_ACCEPT, ioHandler);
		//����ţ�		 �첽��ȡ�ͻ���������Ϣ��������
		int  readNumber=  channel.read(receivedBuffer);
		//����ʮ��		  ��ByteBuffer���б��룬��������Ϣָ��reset,������ȡ�������ģ�������ɹ�����Ϣ��װ��task��Ͷ�ݵ�ҵ���̳߳��ϣ�����ҵ���߼�����
		Object message = null;
		while (buffer.hasReman())
		{
			byteBuffer.mark();
			Object message = decode(byteBuffer);
			if (message == null)
			{
				byteBuffer.reset();
				break;
			}
			messageList.add(message);
		}
		if(!byteBuffer.hasRemain())
		byteBuffer.clear();
		else
			byteBuffer.compact();
		if(messageList !=null && messageList.isEmpty())
		{
			for(Object messageE: messageList)
			{
				handlerTask(messageE);
			}
		}
		//����ʮһ		��Pojo����encode��ByteBuffer,����SocketChannel���첽write�ӿڽ���Ϣ���͸��ͻ���
		socketChannel.write(buffer);
		*/
		
	}
	
	

}
