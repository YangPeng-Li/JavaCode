package io.netty.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * 通过一个独立的I/O线程创建异步时间服务客户端Handler.在实际项目中，不需要创建独立的线程创建异步连接对象，在底层都是通过JDK的系统回调实现
 * @author Lyp
 * @date 2018年12月20日
 * @version 1.0
 *
 */
public class AsyncTimeClientHandler implements Runnable {
	
	private AsynchronousSocketChannel client;
	private String host;
	private int port;
	private CountDownLatch latch;

	
	
	
	
	public AsyncTimeClientHandler(String host, int port) {
		super();
		this.host = host;
		this.port = port;
		try {
			client=AsynchronousSocketChannel.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public void run() {
		latch = new CountDownLatch(1);
		client.connect(new InetSocketAddress(host, port),this,this);
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void completed (Void result,AsyncTimeClientHandler attachment)
	{
		byte [] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
		writeBuffer.put(req);
		writeBuffer.flip();
		client.write(writeBuffer,writeBuffer,new CompletionHandler<Integer, ByteBuffer>() {

			@Override
			public void completed(Integer result, ByteBuffer buffer) {
				if(buffer.hasRemaining())
				{
					client.write(buffer,buffer,this);
				}
				else
				{
					ByteBuffer readBuffer = ByteBuffer.allocate(1024);
					client.read(
							readBuffer,
							readBuffer,
							new CompletionHandler<Integer,ByteBuffer>(){

								@Override
								public void completed(Integer result, ByteBuffer buffer) {
									buffer.flip();
									byte [] bytes = new byte[buffer.remaining()];
									buffer.get(bytes);
									String body ;
									try {
										body = new String (bytes,"UTF-8");
										System.out.println("Now is:"+body);
										latch.countDown();
									} catch (UnsupportedEncodingException e) {
										e.printStackTrace();
									}
									
								}

								@Override
								public void failed(Throwable exc, ByteBuffer attachment) {
									try {
										client.close();
										latch.countDown();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							});
					
				}
			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				exc.printStackTrace();
				try {
					client.close();
					latch.countDown();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
