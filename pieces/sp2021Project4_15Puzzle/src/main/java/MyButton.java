import javafx.scene.control.Button;

public  class MyButton extends Button{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int row;
	private int column;
	private boolean foo;
	private int player;
	
	//Main constructor.
	public MyButton(int row, int column){
		this.setRow(row);
		this.setColumn(column);
		this.setFoo(false);
		this.setPlayer(0); 
	}

	public void setOnAction(Object object) {
		// TODO Auto-generated method stub
		
	}
	
	//these are sets and gets function
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public boolean isFoo() {
		return foo;
	}

	public void setFoo(boolean foo) {
		this.foo = foo;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}
}
