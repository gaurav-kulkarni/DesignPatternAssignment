package org.iiitb.mt2011045.assignment;



import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class Page1TripName extends WizardPage {
	Label l_tripName;
	Text t_tripName;
	Composite compo;
	
	
	public Label getL_tripName() {
		return l_tripName;
	}

	public void setL_tripName(Label l_tripName) {
		this.l_tripName = l_tripName;
	}

	public Text getT_tripName() {
		return t_tripName;
	}

	public void setT_tripName(Text t_tripName) {
		this.t_tripName = t_tripName;
	}

	protected Page1TripName(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
		setTitle("Trip Name");
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		compo = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(2, true);
		compo.setLayout(gl);
		l_tripName = new Label(compo, SWT.NONE);
		l_tripName.setText("Trip Name");
		t_tripName = new Text(compo, SWT.BORDER);
		t_tripName.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(!t_tripName.getText().isEmpty()){
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
