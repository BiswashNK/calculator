import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[12];
	
	JButton addButton, subButton, multButton, divButton;
	
	JButton decButton, eqlsButton, deltButton, clrButton, negButton;
	
	JButton sqrtButton, expButton, factButton;
	
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	
	double num1 = 0;
	double num2 = 0;
	
	double result = 0;
	
	char operator;
	Calculator(){
		frame = new JFrame("Calculator");
		//frame.getContentPane().setBackground(Color.black);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(420, 700);
		
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 75);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		multButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		eqlsButton = new JButton("=");
		deltButton = new JButton("Del");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		sqrtButton = new JButton("√");
		expButton = new JButton("^");
		factButton = new JButton("!");
		
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = multButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = eqlsButton;
		functionButtons[6] = deltButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		functionButtons[9] = sqrtButton;
		functionButtons[10] = expButton;
		functionButtons[11] = factButton;
		
		
		for (int i = 0; i < 12 ; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		for (int i = 0; i < 10; i++) {
				numberButtons[i] = new JButton(String.valueOf(i));
				numberButtons[i].addActionListener(this);
				numberButtons[i].setFont(myFont);
				numberButtons[i].setFocusable(false);
				
		}
		negButton.setBounds(50,525,100,50);
		deltButton.setBounds(150, 525,100,50);
		clrButton.setBounds(250, 525,100,50);
		
		sqrtButton.setBounds(50,125,100,50);
		expButton.setBounds(150, 125,100,50);
		factButton.setBounds(250,125,100,50);
		
		
		panel = new JPanel();
		//panel.setBackground(Color);
		
		panel.setBounds(50,200,300,300);
		
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(divButton);
		panel.add(eqlsButton);
		
		frame.add(panel);
		frame.add(negButton);
		
		frame.add(deltButton);
		frame.add(clrButton);
		
		frame.add(expButton);
		frame.add(factButton);
		frame.add(sqrtButton);
		
		frame.add(textfield);
		frame.setVisible(true);
	}
  public static void main(String[] args) {
	  Calculator calc = new Calculator();
  }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	for (int i = 0; i < 10; i++) {
		if (e.getSource()== numberButtons[i]) {
			textfield.setText(textfield.getText().concat(String.valueOf(i)));
		}
	}
	
	if (e.getSource() == decButton) {
		textfield.setText(textfield.getText().concat("."));
		
	}
	if (e.getSource() == addButton) {
		num1 = Double.parseDouble(textfield.getText());
		operator = '+';
		textfield.setText("");
		
	}
	if (e.getSource() == subButton) {
		num1 = Double.parseDouble(textfield.getText());
		operator = '-';
		textfield.setText("");
		
	}
	if (e.getSource() == multButton) {
		num1 = Double.parseDouble(textfield.getText());
		operator = '*';
		textfield.setText("");
		
	}
	if (e.getSource() == divButton) {
		num1 = Double.parseDouble(textfield.getText());
		operator = '/';
		textfield.setText("");
		
	}
	if (e.getSource() == expButton) {
		num1 = Double.parseDouble(textfield.getText());
		operator = '^';
		textfield.setText("");
		
	}
	
	if(e.getSource() == eqlsButton) {
		num2 = Double.parseDouble(textfield.getText());
		
		switch (operator) {
		case'+':
			result = num1+num2;
			break;
		case'-':
			result = num1-num2;
			break;
		case'*':
			result = num1*num2;
			break;
		case'/':
			result = num1/num2;
			break;
		case'^':
			result = Double.parseDouble(String.format("%.2f",Math.pow(num1, num2)));
			break;
		
		}
		textfield.setText(String.valueOf(result));
		num1 =  result;
		
		
	}
	if (e.getSource() == clrButton) {
		
		textfield.setText("");
		
	}
if (e.getSource() == deltButton) {
		String string = textfield.getText();
		
		textfield.setText("");
		
		for (int i = 0; i < string.length()-1; i++) {
			textfield.setText(textfield.getText() + string.charAt(i));
		}
		
	}
if (e.getSource() == negButton) {
	double temp = Double.parseDouble(textfield.getText());
	temp *= -1;
	
	textfield.setText(String.valueOf(temp));
	
}
if (e.getSource() == sqrtButton) {
	double temp = Double.parseDouble(textfield.getText());
	temp = Math.sqrt(temp);
	String squareRoot = String.format("%.2f", temp);
	
	textfield.setText(squareRoot);
	
}
if (e.getSource() == factButton) {
	int temp = Integer.parseInt(textfield.getText());
	
	int fact = 1;
	for (int i = temp; i > 0; i--) {
		fact *= i;
	}
	
	textfield.setText(String.valueOf(fact));
	
}

	
}
  
 
}