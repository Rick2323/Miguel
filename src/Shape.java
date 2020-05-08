
abstract class Shape {

	private Object[][] shape;
	
	public Shape(int size) {
		shape = new Object[size][size];
	}
	
	public Object[][] getShape() {
		return shape;
	}
}
