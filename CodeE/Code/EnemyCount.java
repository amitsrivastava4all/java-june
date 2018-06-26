class Enemy{
	private String name;  // Instance Variables
	private boolean weapon;
	private int attack;
	 static int counter;
	Enemy(String name, boolean weapon, int attack){
		this.name = name;
		this.weapon = weapon;
		this.attack = attack;
		counter++;
		System.out.println("Enemy Created "+counter);
	}
}
public class EnemyCount {
	static void print(){
		main(null);
	}
	public static void main(String[] args) {
		print();
		// TODO Auto-generated method stub
		for(int i = 1; i<=10; i++){
			//int w = i;
			Enemy obj = new Enemy("L"+i, true, i);
		}

	}

}
