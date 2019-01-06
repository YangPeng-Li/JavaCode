package t4;

public class PrimitiveOverLoading {

	static void prt(String s) {
		System.out.println(s);
	}
	
	
	void f1 (char x) {prt ("f1(char)");}
	void f1 (byte x) {prt ("f1(byte)");}
	void f1 (short x) {prt ("f1(short)");}
	void f1 (int x) {prt ("f1(int)");}
	void f1 (long x) {prt ("f1(long)");}
	void f1 (float x) {prt ("f1(float)");}
	void f1 (double x) {prt ("f1(double)");}
	
	void testConstVal () {
		prt("Testing with 5");
		f1(5);
	}
	void testChar() {
		char x = 'x';
		prt("char argument:");
		f1(x);
	}
	
	void testByte(){
		byte x = 0;
		prt("byte argumnet");
		f1(x);
	}
	void testShort(){
		short x = 0;
		prt("short argumnet");
		f1(x);
	}
	
	void testInt(){
		int x = 0;
		prt("int argumnet");
		f1(x);
	}
	
	void testLong(){
		long x = 0;
		prt("long argumnet");
		f1(x);
	}
	
	void testFloat(){
		float x = 0;
		prt("float argumnet");
		f1(x);
	}
	
	void testDouble(){
		double x = 0;
		prt("double argumnet");
		f1(x);
	}
	public static void main(String[] args) {
		PrimitiveOverLoading p = new PrimitiveOverLoading();
		p.testConstVal();
		p.testChar();
		p.testByte();
		p.testShort();
		p.testInt();
		p.testLong();
		p.testFloat();
		p.testDouble();
	}
	
}




