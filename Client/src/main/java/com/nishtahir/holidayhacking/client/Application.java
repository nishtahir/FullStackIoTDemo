package com.nishtahir.holidayhacking.client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.util.List;
import java.awt.event.ActionListener;

public class Application {
    JComboBox comboBox;

	private JFrame frame;
    private JTextArea textArea;
    private JButton btnConnect;
	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 5, 5));

		JLabel lblComPort = new JLabel("COM Port:");
		panel.add(lblComPort);

		comboBox = new JComboBox();
		panel.add(comboBox);

		btnConnect = new JButton("Connect");
		frame.getContentPane().add(btnConnect, BorderLayout.SOUTH);

		textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
	}

    public JComboBox getComboBox(){
        return comboBox;
    }

    public void setClickListener(ActionListener listener){
        btnConnect.addActionListener(listener);
    }

    public void populateCombo(List<String> content){
        getComboBox().setModel(new DefaultComboBoxModel(content.toArray()));
    }

    public void appendLine(String line){
        textArea.append(line + "\n");
    }
}
