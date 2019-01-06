package classcleprogramme;

/**
 * 单例类
 * 
 * @author Lyp
 * @date 2018年12月27日
 * @version 1.0
 *
 */

public class Emperor {

	private static Emperor emperor = null;
	private Emperor ()
	{
		
	}
	public static Emperor getInstance ()
	{
		if (emperor ==null)
		{
			emperor = new  Emperor ();
		}
		return emperor;
	}
}
