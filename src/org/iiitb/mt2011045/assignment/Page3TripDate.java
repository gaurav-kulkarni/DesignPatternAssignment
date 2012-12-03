package org.iiitb.mt2011045.assignment;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class Page3TripDate extends WizardPage {
	
	Label l_agent;
	Label l_date;
	Combo agent;
	DateTime date;
	Composite compo;
	
		
	public Combo getAgent() {
		return agent;
	}

	public void setAgent(Combo agent) {
		this.agent = agent;
	}

	public String getDate() {
		return date.getYear()+"-"+(date.getMonth()+1)+"-"+date.getDay()/*+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()*/;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	protected Page3TripDate(String pageName) {
		super(pageName);
		setTitle("Trip Date");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		compo = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(2, true);
		compo.setLayout(gl);
		l_agent = new Label(compo, SWT.NONE);
		l_agent.setText("Agent");
		agent = new Combo(compo, SWT.BORDER|SWT.READ_ONLY);
		agent.add("Makemytrip");
		agent.add("Yatra");
		agent.add("Expedia");
		
		l_date = new Label(compo, SWT.NONE);
		l_date.setText("Date");
		date = new DateTime(compo, SWT.CALENDAR);
		
		agent.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				if(!agent.getText().isEmpty())
					setPageComplete(true);
				
			}
		});
		
		
		setControl(compo);
		
	}

}
