package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JFormattedTextField;

public class HomeFrame extends JFrame {

	private Controller controller;
	
	private JPanel pannelloPrincipale;
	private JTable tableConti;
	
	public HomeFrame(Controller controller) throws Exception{
		this.controller = controller;
		
		initComponents();
		
		setVisible(true);
		
		eventHandler();
	}
	
	public void initComponents() throws Exception{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		setTitle("Benvenuto/a " + controller.getCorrentistaLoggato().getNome() + "!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		setLocationRelativeTo(null);
		
		pannelloPrincipale = new JPanel();
		pannelloPrincipale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannelloPrincipale);
		pannelloPrincipale.setLayout(null);
		
		tableConti = new JTable();
		tableConti.setBackground(Color.WHITE);
		tableConti.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tableConti.setBounds(27, 31, 334, 226);
		pannelloPrincipale.add(tableConti);
		
		tableConti.setModel( controller.convertiRSTabella ( controller.getContoCorrenteDAO().getContoCorrenteBYCFProprietario(controller.getCorrentistaLoggato().getCF() ) ) );
	}
	
	public void eventHandler() {
		
	}
}
