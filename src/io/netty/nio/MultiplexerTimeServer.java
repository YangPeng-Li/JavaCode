package io.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * 
 * @author Lyp
 * @date 2018��12��19��
 * @version 1.0 MultiplexerTimeServer
 * ��·�����࣬����һ���������̣߳�������ѯ��·������Selector,���Դ������ͻ��˵Ĳ������롣
 *
 */
public class MultiplexerTimeServer implements Runnable {

	private Selector selector;

	private ServerSocketChannel servChannel;

	private volatile boolean stop;

	/**
	 * ��ʼ����·���������󶨼����˿�
	 * 
	 * ������·������selector��ServerSocketChannel����Channel��TCP������������
	 * ��ServerSocketChannel����Ϊ�첽������ģʽ������backlog����Ϊ1024.
	 * ϵͳ��Դ��ʼ���ɹ��󣬽�ServerSocketChannelע�ᵽ
	 * selector,����SelectKey.OP_ACCEPT����λ(����˿ڱ�ռ��)�����˳�
	 * 
	 * @param port
	 */
	public MultiplexerTimeServer(int port) {

		try {

			selector = Selector.open();
			servChannel = ServerSocketChannel.open();
			servChannel.configureBlocking(false);
			servChannel.socket().bind(new InetSocketAddress(port), 1024);
			servChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port:" + port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void stop() {
		this.stop = true;
	}

	/**
	 * 
	 * ���̵߳�run()������whileѭ������ѭ������selector ,��������ʱ��Ϊ1s �����Ƿ��ж�д�¼�������selectorÿ��1s��������һ�Ρ�
	 * selectorҲ�ṩ��һ���޲ε�selector���������д��ھ���״̬��Channelʱ��selector�����ظ�Channel��SelectionKey�ļ��ϡ�
	 * ͨ������״̬��Channel���Ͻ��е��������Խ���������첽��д������
	 * 
	 */
	@Override
	public void run() {
		while (!stop) {
			try {
				selector.select(1000);// ��������ʱ��Ϊ1s
				Set<SelectionKey> selectKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectKeys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext()) {
					key = iterator.next();
					iterator.remove();

					try {
						handlerInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null)
								key.channel().close();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// ��·�������رպ�����ע���������Channel��Pipe����Դ���ᱻ�Զ�ע�Ტ�رգ����Բ���Ҫ�ظ��ͷ���Դ
		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handlerInput(SelectionKey key) throws IOException {
		/**
		 * ���д����½���Ŀͻ���������Ϣ�� ����SelectionKey �Ĳ��������жϼ��ɻ�֪�����¼����ͣ�
		 * ͨ��ServerSocketChannel��accpet���ܿͻ��˵��������󲢴��� SocketChannel ʵ��
		 * ��������������൱�����TCP���������֣�TCP������·��ʽ������
		 * ���´�����SocketChannel����Ϊ�첽��������ͬʱҲ���Զ�TCP�����������á�����TCP���պͷ��ͻ�������С��
		 */
		if (key.isValid()) {
			// �����½����������Ϣ
			if (key.isAcceptable()) {
				// Accept the new connection
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				// add the new connection to the selector
				sc.register(selector, SelectionKey.OP_READ);
			}

			/*
			 * ���ڶ�ȡ�ͻ��˵�������Ϣ�����ȴ���һ��ByteBuffer���������������޷���֪�ͻ��˷��͵�������С��
			 * ��Ϊ���̣����ǿ���һ��1MB�Ļ�������Ȼ�����SocketChannel��read������ȡ�������� ע�⣺
			 * �������ǽ�SocketChannel����Ϊ�첽������ģʽ���������read�Ƿ������ģ�ʹ�÷���ֵ�����жϣ�������ȡ���ֽ���������ֵ���������ֿ��ܽ��
			 * ����ֵ����0���������ֽڣ����ֽڽ��б��� 1 ��û�ж�ȡ���ֽڣ������������������� -1 ����·�Ѿ��رգ���Ҫ�ر�SocketChannel,�ͷ���Դ
			 *
			 * ����ȡ�������Ժ󣬽��н��룬���ȶ�readBuffer����flip���������������ǽ���������limit����Ϊposition,position����Ϊ0��
			 * ���ں����Ի������Ķ�ȡ������Ȼ����ݻ������ɶ����ֽڸ��������ֽ����飬
			 * ����ByteBuffer��get�����������ɶ�ȡ���ֽ����鸴�Ƶ��´������ֽ������У��������ַ����Ĺ��캯����������������Ϣ����ӡ
			 * �������ָ���ǡ�QUERY TIME ORDER��,��ѷ������ĵ�ǰʱ����뷵�ظ��ͻ��ˡ�
			 */

			if (key.isReadable()) {
				// read the data
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("The time server receive order:" + body);
					String currentTime = "QUERY TIME ORDER".equals(body)
							? new Date(System.currentTimeMillis()).toString()
							: "BAD ORDER";
					doWrite(sc, currentTime);
				} else if (readBytes < 0) {
					// �Զ���·�ر�
					key.cancel();
					sc.close();
				} else {
					;// ����0�ֽڣ�����
				}
			}
		}

	}

	/*
	 * ��Ӧ����Ϣ�첽���͸��ͻ��ˣ����Ƚ��ַ���������ֽ����飬�����ֽ��������������ByteBuffer��
	 * ����ByteBuffer��put�������ֽ����鸴�Ƶ��������У�
	 * Ȼ��Ի���������flip������������SocketChannel��write���������������е��ֽ����鷢�ͳ�ȥ����Ҫָ�����ǣ�
	 * ����SocketChannnel���첽�������ģ�
	 * ��������֤һ���ܹ�����Ҫ���͵��ֽ����鷢���꣬��ʱ����֡�д��������⡣������Ҫע��д������������ѯselector
	 * ��û�з������ByteBuffer������ϣ�
	 * Ȼ�����ͨ��ByteBuffer��HasRemain()�Ŵ��ж���Ϣ�Ƿ�����ɣ��˴������Ǹ��򵥵����ż��̳̣���û����ʾ��δ���д�����������
	 * 
	 */

	private void doWrite(SocketChannel channel, String response) throws IOException {
		if (response != null && response.trim().length() > 0) {
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);
		}
	}

}
