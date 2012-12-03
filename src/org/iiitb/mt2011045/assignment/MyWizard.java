package org.iiitb.mt2011045.assignment;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

public class MyWizard extends Wizard {
	
	WizardPage page1;
	WizardPage page2;
	WizardPage page3;

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		System.out.println("In performFinish!");
		Page1TripName p1 = (Page1TripName) page1;
		Page2TripDetails p2 = (Page2TripDetails) page2;
		Page3TripDate p3 = (Page3TripDate) page3;
		
		Trip t = new Trip();
		t.setName(p1.getT_tripName().getText());
		t.setFrom(p2.getT_from().getText());
		t.setTo(p2.getT_to().getText());
		t.setVia(p2.getT_via().getText());
		t.setAgent(p3.getAgent().getText());
		t.setDate(p3.getDate());
		System.out.println(t.toString());
		System.out.println("INSERT INTO TRIP values (default, '"+t.getName()+"', '"+t.getFrom()+"', '"+t.getTo()+"','"+t.getVia()+"', '"+t.getAgent()+"', '"+t.getDate()+"');");
		String query = "INSERT INTO TRIP values (default, '"+t.getName()+"', '"+t.getFrom()+"', '"+t.getTo()+"','"+t.getVia()+"', '"+t.getAgent()+"', '"+t.getDate()+"');";
		MySQLAccess dao = new MySQLAccess();
	    try {
			dao.readDataBase(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	@Override
    public void addPages() {
            super.addPages();
            page1 = new Page1TripName("Page1");
            page2 = new Page2TripDetails("Page2");
            page3 = new Page3TripDate("Page3");
            addPage(page1);
            addPage(page2);
            addPage(page3);
    }
	
}
