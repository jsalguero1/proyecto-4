package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AdminLogInPanel extends JPanel implements ActionListener{
	//Class parameters
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JTextField textUsername;
	JPasswordField textPassword;
	FirstFrame FirstFrame;
	
	//Admin set credentials
	String adminUsername = "admin";
	String adminPassword = "admin";
	
	public AdminLogInPanel(){
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		this.setSize(500,500);    //Frame is 600x600
		this.setBounds(200, 200, 200, 200);
		
		//Subpanel to add centered elements
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		
		
		//addition of panel contents
		
		//TITLE 1
		JLabel title = new JLabel();
		title.setText("Inicio de sesión como Administrador");
		title.setFont(new Font("MV Boli",Font.BOLD,25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(600, 80));
		title.setBackground(Color.white);
		title.setOpaque(true);
		
		//WELCOME IMAGE 1
		BufferedImage backImage = null;
		try {
			backImage = ImageIO.read(new File("InterfaceFiles/Admin.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Image dimg = backImage.getScaledInstance(600, 350,
		        Image.SCALE_SMOOTH);
		
		ImageIcon dimgRe = new ImageIcon(dimg);
		
		JLabel picLabel = new JLabel(dimgRe);
		
		//SELECT AN OPTION LABEL
		
		JLabel selectText = new JLabel();
		selectText.setText("Por favor ingresa tus credenciales de inicio:");
		selectText.setFont(new Font("MV Boli",Font.PLAIN,25));
		selectText.setPreferredSize(new Dimension(600, 80));
		selectText.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Credentials text spaces

		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));

		JPanel vertical = new JPanel();
		vertical.setLayout(new BoxLayout(vertical, BoxLayout.PAGE_AXIS));
		vertical.setPreferredSize(new Dimension(400,200));
		
		JPanel horizontal = new JPanel();
		horizontal.setLayout(new BoxLayout(horizontal, BoxLayout.X_AXIS));
		horizontal.setPreferredSize(new Dimension(10,30));
		
		JPanel horizontal2 = new JPanel();
		horizontal2.setLayout(new BoxLayout(horizontal2, BoxLayout.X_AXIS));
		horizontal2.setPreferredSize(new Dimension(10,30));
		
		button1 = new JButton(); //Iniciar sesion
		button2 = new JButton(); //Retroceder
		button3 = new JButton(); //Salir de la app
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		
		//TEXT BOXES
		JLabel username = new JLabel();
		JLabel password = new JLabel();
		
		username.setText("Usuario:   ");
		password.setText("Clave:   ");
		
		textUsername = new JTextField();
		textUsername.setMaximumSize(new Dimension(200,35));
		textUsername.setPreferredSize(new Dimension(200,35));
		
		textPassword = new JPasswordField();
		textPassword.setEchoChar('*');
		textPassword.setPreferredSize(new Dimension(200,35));
		textPassword.setMaximumSize(new Dimension(200,35));
		
		horizontal.add(username);
		horizontal.add(textUsername);
		
		horizontal2.add(password);
		horizontal2.add(textPassword);
		
		//alignments
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Set text
		button1.setText("Iniciar sesión");
		button2.setText("Retroceder");
		button3.setText("Salir de la aplicación");
		
		//Set size
		button1.setMaximumSize(new Dimension(200,30));
		button2.setMaximumSize(new Dimension(200,30));
		button3.setMaximumSize(new Dimension(200,30));

		button1.setPreferredSize(new Dimension(100, 30));
		button2.setPreferredSize(new Dimension(50, 30));
		button3.setPreferredSize(new Dimension(50, 30));
	
		
		options.add(horizontal); //Addition of X BoxLayout to Y BoxLayout
		options.add(Box.createRigidArea(new Dimension(0,10)));
		
		options.add(horizontal2);
		options.add(Box.createRigidArea(new Dimension(0,30)));

		vertical.add(button1);
		vertical.add(Box.createRigidArea(new Dimension(0,10)));

		vertical.add(button2);
		vertical.add(Box.createRigidArea(new Dimension(0,10)));

		vertical.add(button3);
		vertical.add(Box.createRigidArea(new Dimension(0,10)));
		
		options.add(vertical);
		

		
		
		//addition to main panel
		centerPanel.add(title, BorderLayout.NORTH);
		centerPanel.add(selectText, BorderLayout.CENTER);
		centerPanel.add(options, BorderLayout.SOUTH);
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(picLabel, BorderLayout.NORTH);
		
		this.setVisible(true);
	}

	//Actions performed in this Panel
	@Override
	public void actionPerformed(ActionEvent e) {
        
    }

}
