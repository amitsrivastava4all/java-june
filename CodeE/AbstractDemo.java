abstract class Player{
	void score(){
		System.out.println("Common Score...");
	}
	void life(){
		System.out.println("Life...");
	}
	abstract void run();
}
class King extends Player{
	@Override
	void run(){
		System.out.println("King Run Fast...");
	}
}
class Robot extends Player{
	@Override
	void run(){
		System.out.println("Robot Run Very Fast...");
	}
}
public class AbstractDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		King king = new King();
		king.life();
		king.score();
		king.run();

	}

}
