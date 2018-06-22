abstract class Shape{
	void foreGround(){
		System.out.println("Shape FG");
	}
	void backGround(){
		System.out.println("Shape BG");
	}
	void points(){
		System.out.println("Shape Points");
	}
	abstract void draw();
//	void draw(){
//		System.out.println("Shape Draw");
//	}
}
class Circle extends Shape{
	@Override
	void draw(){
		System.out.println("Circle Draw...");
	}
	void radius(){
		System.out.println("Circle Radius");
	}
}
class Square extends Shape{
	@Override
	void draw(){
		System.out.println("Square Draw");
	}
	void allSideEquals(){
		System.out.println("Square AllSides Equal");
	}
}
class Drawing{
	void print(Shape shape){
		shape.backGround();
		shape.foreGround();
		shape.points();
		shape.draw();
		if(shape instanceof Square){
			((Square)shape).allSideEquals();
//			Square square = (Square) shape; // Downcasting
//			square.allSideEquals();
			
		}
		if(shape instanceof Circle){
			((Circle)shape).radius();
		}
		System.out.println("******************************");
	}
}
public class ShapeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	new Drawing().print(new Shape());
		
//		Drawing drawing = new Drawing();
//		Shape square = new Square();
//		drawing.print(square);
//		drawing.print(new Circle());
//		
		

	}

}





