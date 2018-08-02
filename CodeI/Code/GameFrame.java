import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstants {
	GameFrame(){
		setSize(GWIDTH, GHEIGHT);
		Board board = new Board();
		this.add(board);
		setTitle("Game-2018");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame frame = new GameFrame();

	}

}
