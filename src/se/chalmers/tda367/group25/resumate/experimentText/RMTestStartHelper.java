package se.chalmers.tda367.group25.resumate.experimentText;

public class RMTestStartHelper {
	
	TemplatePanelTest tP;
	TextController tc;
	
	public RMTestStartHelper(){
	tP = new TemplatePanelTest();
	tc = new TextController();
	tP.addObserver(tc);
	}
	
	public TemplatePanelTest getTP(){
		return tP;
	}
	
	public RMText getRMText(){
		return tc.getRMText();
	}

}
