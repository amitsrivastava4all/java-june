import java.awt.event.MouseListener;

abstract interface Player{
	static void power(){
		System.out.println("Power.....");
	}
	int MAX_RUN = 100;  // public static final int MAX_RUN = 100;
	public abstract void run();
	default void jump(){
		System.out.println("Player Jump Logic");
	}
	//void jump();
}
interface ExtraPower{
	int MAX_RUN = 200;
	default void jump(){
		System.out.println("Extra Power Jump Logic");
	}
//	void attack();
//	void weapon();
	void run();
}
interface ComboPlayer extends Player, ExtraPower{
	@Override
	default void jump(){
		Player.super.jump();
		ExtraPower.super.jump();
	}
}
class RedPlayer implements ComboPlayer{
	@Override
	public void run(){
		System.out.println(Player.MAX_RUN);
		System.out.println(ExtraPower.MAX_RUN);
		//jump();
	}
}
//class RedPlayer implements Player, ExtraPower{
//	
//}
public class InterfaceDemo2 {

	public static void main(String[] args) {
		new RedPlayer().jump();
//		WindowAdapter ;
//		WindowListener;
//		MouseListener;
		// TODO Auto-generated method stub

	}

}
