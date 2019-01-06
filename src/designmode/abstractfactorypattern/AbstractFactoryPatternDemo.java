package designmode.abstractfactorypattern;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		//��ȡ��״����
		AbstractFactory shapeFactory = FactoryProduce.getFactory("SHAPE");
		Shape circleShape = shapeFactory.getShape("CIRCLE");
		circleShape.draw();
		
		//��ȡ��ɫ����
		AbstractFactory colorFactory = FactoryProduce.getFactory("COLOR");
		Color redColor = colorFactory.getColor("RED");
		redColor.fill();
	}
}