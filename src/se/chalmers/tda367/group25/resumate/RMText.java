package se.chalmers.tda367.group25.resumate;



public class RMText extends Section{



	private String text;



	public RMText(){

	}


/*Vi vill ju inte ha en setter men om man byter template vill man ha samma text 
	p� den valde template:en som i den f�reg�ende.*/
	public void setText (String t){

		text = t;

	}



	public String getText(){

		return text;



	}



}