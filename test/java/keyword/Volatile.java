package test.java.keyword;

import java.util.concurrent.CountDownLatch;

/**
 * 
* @ClassName: Volatile
* @author Liqn
* @date 2016-11-20 下午10:01:52
* @Description: 
* 	volatile关键字是java中多线程并发处理同步问题的，熟悉的有synchronized同步块来实现
* 
* 要使volatile达到同步目的，必须对volatile修饰的关键字进行原子操作。
* 	Java中的原子操作包括：
		1）除long和double之外的基本类型的赋值操作
		2）所有引用reference的赋值操作
		3）java.concurrent.Atomic.* 包中所有类的一切操作.
		
		
1、java内存模型是仿照物理计算机内存模型的，
	java内存模型中的      主内存       对应的是物理计算机中的物理内存
					    工作内存 对应的是物理计算机中的 物理计算机中的 高速缓存寄存器

2、变量的访问规则
		这里的变量指的是实例字段、静态字段、构成数组对象元素。(不包括方法参数和局部变量，因为这些是线程私有的)
		
		线程不能对变量直接读写，线程的保存了变量的副本拷贝，线程对变量的所有操作都在工作内存中，
		线程之间无法直接访问对方工作内存中的变量，线程间变量值得传递都是通过主内存实现的。

3、volatile变量规则
		被volatile修饰的变量有两种特性：
			第一种：可见性。
				可见性：指的是一个线程修改了这个变量的值，新值对于其他线程来说是立即得知的。
						这个特性并不能保证线程安全，前提是保证操作的原子性
			第二种：禁止指令重排序优化。
					指令重排序：内存操作速度远慢于cpu运行速度，为了更有效的利用cpu，jvm按照自己的规则，
								将程序顺序呢打乱——即写在后面的代码可能先执行。
				 	普通变量仅能保证方法执行过程中所有依赖赋值结果的地方都能获取到正确结果。而不能保证变量赋值的
				 顺序与程序代码中执行的顺序一致。
				
		
* 并发中，尽量不要用volatile，因为现在普通变量在访问不是超级频繁情况下也能达到volatile的效果
* volatile不能保证操作的原子性。

试玩一下git
* 
 */
public class Volatile extends Thread{
	private static boolean f = false;
	
	public void test(){
		while(!f){
			
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Volatile().start();
		Thread.sleep(1000);
		f = true;
	}
	
}
