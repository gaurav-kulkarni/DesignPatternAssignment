package org.iiitb.mt2011045.assignment;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class Page2TripDetails extends WizardPage {
	Label l_from;
	Label l_to;
	Label l_via;
	Text t_from;
	Text t_to;
	Text t_via;
	Composite compo;
	
	
	public Text getT_from() {
		return t_from;
	}

	public void setT_from(Text t_from) {
		this.t_from = t_from;
	}

	public Text getT_to() {
		return t_to;
	}

	public void setT_to(Text t_to) {
		this.t_to = t_to;
	}

	public Text getT_via() {
		return t_via;
	}

	public void setT_via(Text t_via) {
		this.t_via = t_via;
	}

	protected Page2TripDetails(String pageName) {
		super(pageName);
		setTitle("Trip Details");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		compo = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(2, true);
		compo.setLayout(gl);
		l_from = new Label(compo, SWT.NONE);
		l_from.setText("From");
		t_from = new Text(compo, SWT.BORDER);
		
		l_to = new Label(compo, SWT.NONE);
		l_to.setText("To");
		t_to = new Text(compo, SWT.BORDER);
		
		l_via = new Label(compo, SWT.NONE);
		l_via.setText("Via");
		t_via = new Text(compo, SWT.BORDER);
		
		
		t_from.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(!t_from.getText().isEmpty()&&!t_to.getText().isEmpty()){
					setPageComplete(true);
				}
				else
					setPageComplete(false);
					
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		t_to.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(!t_to.getText().isEmpty()&&!t_from.getText().isEmpty()){
					setPageComplete(true);
				}
				else
					setPageComplete(false);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		setControl(compo);
		setPageComplete(false);
	}

}
