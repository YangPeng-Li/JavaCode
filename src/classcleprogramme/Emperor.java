package classcleprogramme;

/**
 * ������
 * 
 * @author Lyp
 * @date 2018��12��27��
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
