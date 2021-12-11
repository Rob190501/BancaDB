package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import eccezioni.SystemLookAndFeelException;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginFrame extends JFrame {

	private Controller controller;
	
	private JPanel pannelloPrincipale;
	private JTextField tfCodiceFiscale;
	private JButton btnAccedi;
	private JLabel lblOppure;

	public LoginFrame(Controller controller) throws Exception{
		this.controller = controller;
		
		initComponents();
		
		setVisible(true);
		
		eventHandler();
	}
	
	public void initComponents() throws Exception{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);
		
		pannelloPrincipale = new JPanel();
		pannelloPrincipale.setBackground(Color.LIGHT_GRAY);
		pannelloPrincipale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannelloPrincipale);
		
		tfCodiceFiscale = new JTextField();
		tfCodiceFiscale.setToolTipText("Codice Fiscale");
		tfCodiceFiscale.setColumns(20);
		
		JPanel pannelloBottoni = new JPanel();
		pannelloBottoni.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblCF = new JLabel("CF:");
		lblCF.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		GroupLayout gl_pannelloPrincipale = new GroupLayout(pannelloPrincipale);
		gl_pannelloPrincipale.setHorizontalGroup(
			gl_pannelloPrincipale.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pannelloPrincipale.createSequentialGroup()
					.addGroup(gl_pannelloPrincipale.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pannelloPrincipale.createSequentialGroup()
							.addGap(13)
							.addComponent(lblCF)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfCodiceFiscale, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_pannelloPrincipale.createSequentialGroup()
							.addContainerGap()
							.addComponent(pannelloBottoni, GroupLayout.PREFERRED_SIZE, 228, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_pannelloPrincipale.setVerticalGroup(
			gl_pannelloPrincipale.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pannelloPrincipale.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_pannelloPrincipale.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfCodiceFiscale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCF))
					.addGap(78)
					.addComponent(pannelloBottoni, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		
		btnAccedi = new JButton("Accedi");
		btnAccedi.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		pannelloBottoni.add(btnAccedi);
		
		lblOppure = new JLabel("Oppure");
		lblOppure.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		pannelloBottoni.add(lblOppure);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		pannelloBottoni.add(btnRegistrati);
		
		pannelloPrincipale.setLayout(gl_pannelloPrincipale);
	}
	
	
	
	public void eventHandler() throws Exception{
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(controller.ottieniCredenziali(tfCodiceFiscale.getText())) {
						controller.accessoRiuscito();
					}
					else {
						JOptionPane.showMessageDialog(pannelloPrincipale, "Login fallito.");
					}
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}
}
