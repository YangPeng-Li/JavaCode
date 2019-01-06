package io.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClientOfProcedure {
	
	public static void main(String[] args) throws IOException {
		
		/*		Selector selector;
		int port = 8080;
		int BUFFER_SIZE = 1024;
		Socket socket ;
		//����һ	 ��SocketChannel���󶨿ͻ��˱��ص�ַ
		SocketChannel clientChannel = SocketChannel.open();
		
		//�����	����SocketChannelΪ������ģʽ��ͬʱ���ÿͻ������ӵ�TCP������
			
		
			clientChannel.configureBlocking(false);
			socket.setReuseAddress(true);
			socket.setReceiveBufferSize(BUFFER_SIZE);
			socket.setSendBufferSize(BUFFER_SIZE);
			//������		 �첽���ӷ����
			boolean connection  =   clientChannel.connect(new InetSocketAddress("ip",port));
			
			//������	�ж��Ƿ����ӳɹ���������ӳɹ���ֱ��ע���״̬����·�������У������ǰû�����ӳɹ�
			//		(�첽���ӣ�����false ,˵���ͻ����Ѿ�����sync���������û�з���ack����������·û�н���)
			if(connection)
			{
				clientChannel.register(selector, SelectionKey.OP_READ, ioHandler);
			}
			else
			{
				clientChannel.register(selector, SelectionKey.OP_CONNECT, ioHandler);
			}
			//������:		 ��Reactor�̵߳Ķ�·������ע��OP_CONNECT״̬λ����������˵�TCP ACKӦ��
			clientChannel.register(selector, SelectionKey.OP_CONNECT, ioHandler);
			//��������		����Reactor�̣߳�������·�������������߳�
			Selector selector2 = Selector.open();
			new Thread(new ReactorTask()).start();
			//������ �� ��·���������߳�run ����������ѭ��������ѯ׼��������key 
			int num = selector2.select();
			Set<SelectionKey> selectedKeys = selector2.selectedKeys();
			 Iterator<SelectionKey> iterator = selectedKeys.iterator();
			 while (iterator.hasNext())
			 {
				 SelectionKey next = iterator.next();
			 }
			//����ˣ� 		����connectʱ�䴦��
			 if(key.isConnectable())
			 {
//				 handleConnect();
			 }
			 
			 //����ţ�	�ж����ӽ����������ӳɹ���ע����¼�����·������
			 if (channel.finishConnect())
				 registerRead();
			 
			 //����ʮ��	ע���¼�����·��������
			 clientChannel.register(sel, ops, att);
			 
			 //����ʮһ���첽��ȡ�ͻ������󵽻�����
			  int readNum =channel.read(receiveBuffer);
			  //����ʮ����		��byteBuffer���б��룬����а����Ϣ���ջ�����Reset,������ȡ�����ı���
			  //			������ɹ�����Ϣ��װ��Task,Ͷ�ݵ��̳߳��н���ҵ���߼�����
			 Object message = null;
			 while (buffer.hasRemain())
			 {
				 byteBuffer.mark();
				 Object message = decode(byteBuffer);
				 if(message == null)
				 {
					 byteBuffer.reset();
					 break;
					 
					 messageList.add(message);
				 }
			 }
			 if (!byteBuffer.hasRemain())
				 byteBuffer.clear();
			 else
				 byteBuffer.compact();
			 
			 if (messageList !=null && messageList.isEmpty())
			 {
				 for (Object messageE :messageList)
					 handlerTask(messageE);
			 }
			 
			 //����ʮ����		��Pojo����encode��ByteBuffer,����SocketChannel���첽write�ӿڽ���Ϣ���͸��ͻ���
				socketChannel.write(buffer);*/
			 
			 
	}
	

	private static void selectedKeys() {
		// TODO Auto-generated method stub
		
	}


	private static void connect(InetSocketAddress inetSocketAddress) {
		// TODO Auto-generated method stub
		
	}

	
}
