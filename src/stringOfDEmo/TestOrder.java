package stringOfDEmo;

public class TestOrder {
	public static void main(String[] args) {
	}
}
class Order{
	private int orderId;
	private String orderName;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}
	public boolean  equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}else
		{
			if(obj instanceof Order)
			{
				Order o1= (Order)obj;
				return this.orderId == o1.orderId && this.orderName == o1.orderName;
			}
			else
			{
				return false;
			}
		}
	}
}