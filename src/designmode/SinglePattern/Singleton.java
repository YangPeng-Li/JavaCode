package designmode.SinglePattern;

/**
 * 双检锁/双重检验锁（DCL,Double-checked locking）
 * JDK 1.5以上
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度： 较复杂
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 * @author Lyp
 * @date 2018年12月28日
 * @version 1.0
 * 
 * voliatitle https://www.cnblogs.com/dolphin0520/p/3920373.html
 * 在Java 5之后，volatile关键字才得以重获生机。
 * volatile关键字虽然从字面上理解起来比较简单，但是要用好不是一件容易的事情。
 * 由于volatile关键字是与Java的内存模型有关的，因此在讲述volatile关键之前，我们先来了解一下与内存模型相关的概念和知识，
 * 然后分析了volatile关键字的实现原理，最后给出了几个使用volatile关键字的场景。
 *
 *
 *只有简单的读取、赋值（而且必须是将数字赋值给某个变量，变量之间的相互赋值不是原子操作）才是原子操作
 */
public class Singleton {
	
	/*
	 * 　对于可见性，Java提供了volatile关键字来保证可见性。
	 * 当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，
	 * 当有其他线程需要读取时，它会去内存中读取新值。
	 * 而普通的共享变量不能保证可见性，因为普通共享变量被修改之后，
	 * 什么时候被写入主存是不确定的，当其他线程去读取时，
	 * 此时内存中可能还是原来的旧值，因此无法保证可见性。
	 * 另外，通过synchronized和Lock也能够保证可见性，
	 * synchronized和Lock能保证同一时刻只有一个线程获取锁然后执行同步代码，
	 * 并且在释放锁之前会将对变量的修改刷新到主存当中。因此可以保证可见性。
	 */
	
	private volatile static Singleton singleton ;
	private Singleton () {}
	public static Singleton getSingleton ()
	{
		/*
		 * Java内存模型只保证了基本读取和赋值是原子性操作，
		 * 如果要实现更大范围操作的原子性，可以通过synchronized和Lock来实现。
		 * 由于synchronized和Lock能够保证任一时刻只有一个线程执行该代码块，那么自然就不存在原子性问题了，从而保证了原子性。
		 * 
		 * 
		 * volatile能保证有序性吗？
		 * 在前面提到volatile关键字能禁止指令重排序，所以volatile能在一定程度上保证有序性。
		 * volatile关键字禁止指令重排序有两层意思：
		 * 1）当程序执行到volatile变量的读操作或者写操作时，在其前面的操作的更改肯定全部已经进行，
		 * 	   且结果已经对后面的操作可见；在其后面的操作肯定还没有进行；
		 * 2）在进行指令优化时，不能将在对volatile变量访问的语句放在其后面执行，也不能把volatile变量后面的语句放到其前面执行
		 * 
		 * synchronized关键字是防止多个线程同时执行一段代码，那么就会很影响程序执行效率，而volatile关键字在某些情况下性能要优于synchronized，但是要注意volatile关键字是无法替代synchronized关键字的，因为volatile关键字无法保证操作的原子性。通常来说，使用volatile必须具备以下2个条件：
		 * 1）对变量的写操作不依赖于当前值
		 * 2）该变量没有包含在具有其他变量的不变式中
		 * 实际上，这些条件表明，可以被写入 volatile 变量的这些有效值独立于任何程序的状态，包括变量的当前状态。
		 * 事实上，我的理解就是上面的2个条件需要保证操作是原子性操作，才能保证使用volatile关键字的程序在并发时能够正确执行。
		 * 
		 */
		
		if(singleton  == null)
			synchronized (Singleton.class) 
			{
				if (singleton ==null)
				{
						singleton = new Singleton();
				}
			}
		return singleton;
	}
}
