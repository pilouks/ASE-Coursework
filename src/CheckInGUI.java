import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.List;

import javax.swing.*;

public class CheckInGUI {

	public enum Scene {
		CHECKIN, USERINFO, BAGCHECK, BAGS, ERROR1, ERROR2, EXIT, RETURN
	}

	static Scene scene = Scene.CHECKIN;

	int width = 300;
	int height = 300;

	JFrame frame = new JFrame("GUI");
	JButton checkIn = new JButton("Check In");
	JButton exit = new JButton("Exit");
	JButton noBags = new JButton("No Bags");
	JButton enterBagInfo = new JButton("Enter Bag Info");
	JButton enter = new JButton("Enter");
	JButton retry = new JButton("Retry");
	JTextArea error = new JTextArea();

	static JTextField surname = new JTextField();
	static JTextField reference = new JTextField();
	static String surnameText;
	static String referenceText;

	public CheckInGUI() {
	}

	/*
	 * Will generate the standard gui layout Home screen with no required input from
	 * user Just a logo or something
	 */
	public void createAndShowGUI() {

		frame.setSize(width, height);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupListener();

		checkIn.setBounds(width / 4, height / 4, width / 2, height / 5);
		exit.setBounds(width / 4, 2 * height / 4, width / 2, height / 5);
		noBags.setBounds(width / 4, height / 4, width / 2, height / 5);
		enterBagInfo.setBounds(width / 4, 2 * height / 4, width / 2, height / 5);
		surname.setBounds(width / 4, height / 5, width / 2, height / 5 - 20);
		reference.setBounds(width / 4, 2 * height / 5, width / 2, height / 5 - 20);
		enter.setBounds(width / 4, 3 * height / 5, width / 2, height / 5 - 20);
		error.setBounds(width / 8, height / 4, 3*width / 4, height / 8);
		retry.setBounds(width / 4, 2*height / 4, width / 2, height / 5);
	}

	/*
	 * Will give the user the option to check in passenger or Exit If check in
	 * passenger then request reference code and last name Pass these back (comma
	 * separated) If exit pass back "EXIT" to gen reports
	 */
	public String getUserInput() {
		paintScene();
		while (!(scene == Scene.EXIT) || !(scene == Scene.RETURN)) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (scene == Scene.EXIT) {
				return "exit";
			}
			if (scene == Scene.RETURN) {
				String info = referenceText + " , " + surnameText;
				return info;
			}
		}

		return "";
	}

	private void paintScene() {
		
		switch(scene) {
			case ERROR1:
				error.setText("Flight Reference doesnt exist.");
				frame.getContentPane().add(error);
				frame.getContentPane().add(retry);
				break;
			case ERROR2:
				error.setText("Surname and Flight reference dont match");
				frame.getContentPane().add(error);
				frame.getContentPane().add(retry);
				break;
			case CHECKIN:
				frame.getContentPane().add(checkIn);
				frame.getContentPane().add(exit);
				break;
			case USERINFO:
				frame.getContentPane().add(surname);
				frame.getContentPane().add(reference);
				frame.getContentPane().add(enter);
				break;
			case BAGCHECK:
				frame.getContentPane().add(noBags);
				frame.getContentPane().add(enterBagInfo);
				break;
			case BAGS:
				frame.getContentPane().add(noBags);
				frame.getContentPane().add(enterBagInfo);
				break;
			case RETURN:
				break;
			case EXIT:
				break;
		}
		
		
		frame.repaint();
	}

	private void setupListener() {
		ActionListener Listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if (e.getSource() == checkIn) {
					frame.getContentPane().removeAll();
					scene = Scene.USERINFO;
				}
				if (e.getSource() == exit) {
					frame.getContentPane().removeAll();
					scene = Scene.EXIT;
				}
				if (e.getSource() == enter) {
					frame.getContentPane().removeAll();
					surnameText = surname.getText();
					referenceText = reference.getText();
					scene = Scene.BAGCHECK;
				}
				if(e.getSource()==retry) {
					surname.setText("");
					reference.setText("");
					frame.getContentPane().removeAll();
					scene = Scene.USERINFO;
				}
				if(e.getSource()==noBags) {
					frame.getContentPane().removeAll();
					surname.setText("");
					reference.setText("");
					scene = Scene.USERINFO;
				}
				if(e.getSource()==enterBagInfo) {
					frame.getContentPane().removeAll();
					scene = Scene.BAGS;
				}
				
				paintScene();

			}
		};

		checkIn.addActionListener(Listener);
		exit.addActionListener(Listener);
		enter.addActionListener(Listener);
		surname.addActionListener(Listener);
		reference.addActionListener(Listener);
		retry.addActionListener(Listener);
		noBags.addActionListener(Listener);
		enterBagInfo.addActionListener(Listener);

	}

	/*
	 * Will ask user if they want to add a bag if yes then ask user for bag
	 * dimensions and weight convert x,y,z dimensions to m^3 volume pass back
	 * volume, weight if no then pass back -1
	 */
	public List<Double> getPassengerBagInfo() {
		
		
		paintScene();
		
		return new ArrayList<>();
	}

	/*
	 * Will request the user pay a fee for excess baggage return true to indicate
	 * some sort of payment procedure has been passed return false to indicate
	 * customer refusal to pay and bag should not be added
	 */
	public Boolean requestFees(double fee) {
// to do
		return true;
	}

	/*
	 * Show an error screen based on error code 0: Generic error 1: Booking code
	 * could not be found 2: Booking code and last name did not match 3: Bag
	 * dimensions unacceptable 4: Baggage fees unpaid, bag not added
	 *
	 * Possibly more to come Will return "OK" or something to indicate user wants to
	 * proceed
	 */
	public void ErrorScreen(int errorCode) {
		switch (errorCode) {
		case 1:
			scene = Scene.ERROR1;
			break;
		case 2:
			scene = Scene.ERROR2;
			break;
		}
	}
}
