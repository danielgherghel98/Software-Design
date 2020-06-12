package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.MainView;

public class LanguageListener implements ActionListener {
	
	IObserver view;

	public LanguageListener(IObserver view) {
		super();
		this.view = view;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Limba limbaa=new Limba();
		limbaa.setLimba(view.getLimbaa().getSelectedItem().toString());
		
	}
	
	

}
