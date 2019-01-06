package designmode.abstractfactorypattern;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		//获取形状工厂
		AbstractFactory shapeFactory = FactoryProduce.getFactory("SHAPE");
		Shape circleShape = shapeFactory.getShape("CIRCLE");
		circleShape.draw();
		
		//获取颜色工厂
		AbstractFactory colorFactory = FactoryProduce.getFactory("COLOR");
		Color redColor = colorFactory.getColor("RED");
		redColor.fill();
	}
}