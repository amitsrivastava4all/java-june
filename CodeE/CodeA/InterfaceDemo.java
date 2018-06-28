// What to do
interface DB{
	int MAX_CONNECTION = 100; // public static final int MAX_CONNECTION = 100
void open();  // public abstract void open();
void close();
boolean add();
void delete();
}
// How to Do
class OracleDB implements DB{
	int openConnection = 0;
	@Override
	public void open() {
		if(openConnection<MAX_CONNECTION){
			openConnection++;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
class MySQLDB implements DB{

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
public class InterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
