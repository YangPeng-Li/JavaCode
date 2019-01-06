package io.netty.aio;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandle
		implements CompletionHandler<AsynchronousSocketChannel, ? super AsyncTimeServerHandler> {
	
	@Override
	public void completed (AsynchronousSocketChannel result,AsyncTimeServerHandler attachment)
	{
		attachment.asynchronousServerSocketChannel.accept(attachment,this);
		ByteBuffer buffer =  ByteBuffer.allocate (1024);
		result.read(buffer,buffer,new ReadCompletionHandler(result));
	}
	
	
	@Override
	public void faild (Throwable exc,AsyncTimeServerHandler attachment)
	{
		exc.printStackTrace();
		attachment.latch.countDown();
	}
}
