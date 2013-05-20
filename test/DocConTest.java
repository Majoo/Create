import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.tda367.group25.resumate.controllers.DocumentController;
import se.chalmers.tda367.group25.resumate.views.DocumentView;


public class DocConTest {

	@Test
	public void test() {
		DocumentController docCon = new DocumentController();
		DocumentView dv = new DocumentView();
		String ID = "ID";
		
		docCon.addDocView(ID, dv);

		assert(docCon.getView(ID)== dv);
	}

}
