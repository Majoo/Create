package se.chalmers.tda367.group25.resumate;

public class RMText extends Section{

	private String text;

	public RMText(){

	}

/*Vi vill ju inte ha en setter (blir ju muterbar)
   men om man byter template vill man ha samma text 
	på den valde template:en som i den föregående.
	Annars får vi ha en konstruktor som tar in en text och att man alltid instansierar
	om alla Sections i Template Storage med de givna värdena */
	
	public void setText (String text){
		this.text = text;
	}


	public String getText(){
		return this.text;
	}

}