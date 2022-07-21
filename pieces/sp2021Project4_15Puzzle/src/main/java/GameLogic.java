
public class GameLogic {

	 int x;
	 int y;
	int[] newcordinates;
	UserInterface head;
	
	
//	//constructor for GameLogic
	GameLogic(int x,int y){
		this.x = x;
		this.y = y;
	this.newcordinates = new int[2];

	}
	
	//main method-------------------------------------------------------------------------------
	//this method determines if its a valid move.
	public String[] isValid(int x, int y, String[] arr) {
		
	String[][] array2 = new String[4][4];
	int p = 0;
	
	//creating a 2d array by populating it with arr values.
	for (int i = 0; i < 4; i++) {
		for (int k = 0; k < 4; k++) {
			array2[k][i] = arr[p];
			p++;
		}
	}
	//testing to see if each value was stored correctly. 
	//printArr2(array2);
		
		
	//testing the left move. 
	if(((y-1) < 4 ) && ((y-1) > -1 ) && (array2[x][y-1].equals(""))){
		arr = alterArr(x, y, x,(y-1),array2);
		this.newcordinates[0] = x;
		this.newcordinates[1] = (y-1); 
		//printArr(arr);		
		return arr;
	}
	
	//testing the right move.
	else if(((y+1) < 4 ) && ((y+1) > -1 ) && (array2[x][y+1].equals(""))){
		arr = alterArr(x, y, x,(y+1),array2);
		this.newcordinates[0] = x;
		this.newcordinates[1] = (y+1); 
		//printArr(arr);		
		return arr;
	}
	
	//testing the up move.
	else if(((x-1) < 4 ) && ((x-1) > -1 ) && (array2[x-1][y].equals(""))){
		arr = alterArr(x, y, (x-1),y,array2);
		this.newcordinates[0] = (x-1);
		this.newcordinates[1] = y; 
		//printArr(arr);		
		return arr;
	}

	//testing the down move.
	else if(((x+1) < 4 ) && ((x+1) > -1 ) && (array2[x+1][y].equals(""))){
		arr = alterArr(x, y, (x+1),y,array2);
		this.newcordinates[0] = x + 1;
		this.newcordinates[1] = y;
		//printArr(arr);		
		return arr;
	}
		
	return arr;	
	}
	


	//helper method------------------------------------------------------------------------------

//this method will combine any give numeric string into one large string.
	String joined(String[] s) {
	String temp = new String();
		
		//using an array to create a string.
		for(int i = 0; i < 16; i++) {
			//this will replace the empty string with  a string that host zero.
			if(s[i].equals("")) {s[i] = "0";}
			
		//the following if else if and else will determine how to create the string properly.
	if(i == 15) {temp = temp + s[i];}
		else if (i == 0 ) {temp = s[i] + " ";}
	else {temp = temp + s[i] + " ";}
		}
	return temp;
	}


//	//this method is used to change the arr values of the arr in positon currX and currY in arr.
String[] alterArr(int currX, int currY, int nextX, int nextY, String[][] arr) {
	//rearrange array.
	String temp = arr[currX][currY];
	arr[currX][currY] = arr[nextX][nextY];
	arr[nextX][nextY] = temp;
	
	//making a single array.
	String[] array2 = new String[16];
	int p = 0;
	
	//creating an array by populating it with arr values.
	for (int i = 0; i < 4; i++) {
		for (int k = 0; k < 4; k++) {
			array2[p] = arr[i][k];
			p++;
		}
	}
	
	return array2;
}

//	//this method is only used to make sure the arr was changed properly.
void printArr(String[] arr) {
		
			for(int y = 0; y < 16; y++) {
				System.out.println(arr[y]);
			
		}
}
//this will print out the 2d array.
void printArr2(String[][] arr) {
	//prints out every value in the array. 
	for(int x = 0; x < 4; x++) {
		for(int y = 0; y < 4; y++) {
			
			if(y+1 == 4) {System.out.println(arr[x][y]+" ");}
			else {System.out.print(arr[x][y]);}
		}
	}
		
}

//this will makes a 1d array into a 2d array.
public int[][] alterSize(String[] array) {
	//used to create array2
	int[][] array2 = new int[4][4];
	
	//used though iterate though array
	int k = 0; 
	
	//used to populate array2
	for(int i = 0; i < 4; i++) {
		for(int j = 0; j < 4; j++) {
			System.out.println("hera");
			
			if(array[k].equals("")) {array2[i][j] = 0;}
			array2[i][j] = Integer.parseInt(array[k]);
			k++;
		}
	}
	return array2;
}

//this will make a 2d array into a id array.
public int[] changeback(int[][] array2) {
	//used to intillize array2
	int[] array = new int[16];
	
	//used though iterate though array
	int k = 0; 
	
	//used to populate array2
	for(int i = 0; i < 4; i++) {
		for(int j = 0; j < 4; j++) {
			array[k] = array2[i][j];
			k++;
		}
	}
	return array;
}


//	//Gets and sets--------------------------------------------------------------------------------- 
	void setX(int x) {this.x = x;}
	int getX() {return this.x;}
	void setY(int y) {this.y = y;}
	int getY() {return this.y;}
	void setCordinates(int x, int y) {this.newcordinates[0] = x; this.newcordinates[1] = y;}
	int[] getCordinates() {return this.newcordinates;}
}
