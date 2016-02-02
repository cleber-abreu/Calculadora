import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


@SuppressWarnings("serial")
public class Calculadora extends JFrame
						implements ActionListener, KeyListener {

	private JFrame frmCalculadora;
	private static JTextField textField_Texto;
	private JPanel panel_Funcoes;
	private JButton button_0;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_Mais;
	private JButton button_Menos;
	private JButton button_Mult;
	private JButton button_Div;
	private JButton button_Ponto;
	private JButton button_Igual;
	private JButton button_Limpa;
	private JButton button_Corrige;
	private JButton button_Poten;
	private JButton button_Raiz;
	private JButton button_Raiz2;
	private JButton button_Log;
	private JButton button_Quad;
	private JButton button_Fatorial;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.frmCalculadora.setVisible(true);
				} catch (Exception e) {
						e.printStackTrace();
					}
			}

		});
		
		// Selecionando o tema Nimbus
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    
		}
	}

	/**
	 * Create the application.
	 */
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.setFont(new Font("Dialog", Font.BOLD, 12));
		frmCalculadora.setIconImage(Toolkit.getDefaultToolkit().getImage(Calculadora.class.getResource("/icone/calculadora.png")));
		frmCalculadora.setResizable(false);
		frmCalculadora.setBounds(new Rectangle(0, 0, 360, 480));
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.setBounds(100, 100, 360, 480);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadora.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.BLACK);
		frmCalculadora.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField_Texto = new JTextField();
		textField_Texto.setEditable(false);
		textField_Texto.setHorizontalAlignment(SwingConstants.RIGHT);
		try {
			InputStream ttf = Calculadora.class.getResourceAsStream("/fonte/DS-DIGIB.TTF");
			Font fonte = Font.createFont(Font.TRUETYPE_FONT, ttf);
			textField_Texto.setFont(fonte.deriveFont(Font.BOLD, 36));
		} catch (Exception e) {
			System.out.println("Erro: Não foi possível carregar fonte.\n" + e.getMessage());
		}
		textField_Texto.setText("0");
		textField_Texto.setBackground(new Color(245, 255, 250));
		textField_Texto.setBounds(6, 6, 342, 42);
		textField_Texto.addKeyListener(this);
		panel.add(textField_Texto);
		textField_Texto.setColumns(10);
		
		panel_Funcoes = new JPanel();
		panel_Funcoes.setBackground(new Color(0, 0, 0));
		panel_Funcoes.setBounds(6, 77, 342, 58);
		panel.add(panel_Funcoes);
		
		button_Quad = new JButton("x\u00B2");
		button_Quad.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_Quad.setForeground(SystemColor.info);
		button_Quad.setBackground(new Color(47, 79, 79));
		button_Quad.addActionListener(this);
		button_Quad.addKeyListener(this);
		panel_Funcoes.setLayout(new GridLayout(2, 4, 0, 0));
		panel_Funcoes.add(button_Quad);
		
		button_Raiz2 = new JButton("\u221Ax");
		button_Raiz2.setFont(new Font("Tahoma",Font.BOLD, 14));
		button_Raiz2.setForeground(SystemColor.info);
		button_Raiz2.setBackground(new Color(47, 79, 79));
		button_Raiz2.addActionListener(this);
		button_Raiz2.addKeyListener(this);
		panel_Funcoes.add(button_Raiz2);;
		
		button_Log = new JButton("Log");
		button_Log.setFont(new Font("Tahoma",Font.BOLD, 14));
		button_Log.setForeground(SystemColor.info);
		button_Log.setBackground(new Color(47, 79, 79));
		button_Log.addActionListener(this);
		button_Log.addKeyListener(this);
		panel_Funcoes.add(button_Log);
		
		button_Corrige = new JButton("<-");
		button_Corrige.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_Corrige.setForeground(new Color(255, 255, 255));
		button_Corrige.setBackground(new Color(85, 107, 47));
		button_Corrige.addActionListener(this);
		panel_Funcoes.add(button_Corrige);
		
		button_Poten = new JButton("x^y");
		button_Poten.setFont(new Font("Tahoma",Font.BOLD, 14));
		button_Poten.setForeground(SystemColor.info);
		button_Poten.setBackground(new Color(47, 79, 79));
		button_Poten.addActionListener(this);
		button_Poten.addKeyListener(this);
		panel_Funcoes.add(button_Poten);
		
		button_Raiz = new JButton("x\u00B9/y");
		button_Raiz.setFont(new Font("Tahoma",Font.BOLD, 14));
		button_Raiz.setForeground(SystemColor.info);
		button_Raiz.setBackground(new Color(47, 79, 79));
		button_Raiz.addActionListener(this);
		button_Raiz.addKeyListener(this);
		panel_Funcoes.add(button_Raiz);
		
		button_Fatorial = new JButton("!");
		button_Fatorial.setFont(new Font("Tahoma",Font.BOLD, 14));
		button_Fatorial.setForeground(SystemColor.info);
		button_Fatorial.setBackground(new Color(47, 79, 79));
		button_Fatorial.addActionListener(this);
		button_Fatorial.addKeyListener(this);
		panel_Funcoes.add(button_Fatorial);
		
		button_Limpa = new JButton("Limpa");
		button_Limpa.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_Limpa.setForeground(new Color(255, 255, 255));
		button_Limpa.setBackground(new Color(85, 107, 47));
		button_Limpa.addActionListener(this);
		button_Limpa.addKeyListener(this);
		panel_Funcoes.add(button_Limpa);
		
		
		JPanel panel_Teclado = new JPanel();
		panel_Teclado.setForeground(Color.BLACK);
		panel_Teclado.setBackground(Color.BLACK);
		panel_Teclado.setBounds(6, 136, 342, 309);
		panel.add(panel_Teclado);
		panel_Teclado.setLayout(new GridLayout(4, 4, 0, 0));
		
		button_7 = new JButton("7");
		button_7.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_7.setBackground(Color.BLACK);
		button_7.setForeground(Color.WHITE);
		button_7.addActionListener(this);
		button_7.addKeyListener(this);;
		
		button_8 = new JButton("8");
		button_8.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_8.setBackground(Color.BLACK);
		button_8.setForeground(Color.WHITE);
		button_8.addActionListener(this);
		button_8.addKeyListener(this);
		
		button_9 = new JButton("9");
		button_9.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_9.setBackground(Color.BLACK);
		button_9.setForeground(Color.WHITE);
		button_9.addActionListener(this);
		button_9.addKeyListener(this);
		
		button_Div = new JButton("/");
		button_Div.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_Div.setBackground(Color.DARK_GRAY);
		button_Div.setForeground(Color.WHITE);
		button_Div.addActionListener(this);
		
		button_4 = new JButton("4");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_4.setBackground(Color.BLACK);
		button_4.setForeground(Color.WHITE);
		button_4.addActionListener(this);
		button_4.addKeyListener(this);
		
		
		button_5 = new JButton("5");
		button_5.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_5.setBackground(Color.BLACK);
		button_5.setForeground(Color.WHITE);
		button_5.addActionListener(this);
		button_5.addKeyListener(this);
		
		button_6 = new JButton("6");
		button_6.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_6.setBackground(Color.BLACK);
		button_6.setForeground(Color.WHITE);
		button_6.addActionListener(this);
		button_6.addKeyListener(this);
		
		button_Mult = new JButton("x");
		button_Mult.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_Mult.setBackground(Color.DARK_GRAY);
		button_Mult.setForeground(new Color(255, 255, 255));
		button_Mult.addActionListener(this);
		button_Mult.addKeyListener(this);
		
		button_1 = new JButton("1");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_1.setBackground(Color.BLACK);
		button_1.setForeground(Color.WHITE);
		button_1.addActionListener(this);
		button_1.addKeyListener(this);
		
		button_2 = new JButton("2");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_2.setBackground(Color.BLACK);
		button_2.setForeground(Color.WHITE);
		button_2.addActionListener(this);
		button_2.addKeyListener(this);;
		
		button_3 = new JButton("3");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_3.setBackground(Color.BLACK);
		button_3.setForeground(Color.WHITE);
		button_3.addActionListener(this);
		button_3.addKeyListener(this);;
		
		button_Menos = new JButton("-");
		button_Menos.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_Menos.setBackground(Color.DARK_GRAY);
		button_Menos.setForeground(Color.WHITE);
		button_Menos.addActionListener(this);
		button_Menos.addKeyListener(this);
		
		button_Ponto = new JButton(".");
		button_Ponto.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_Ponto.setBackground(Color.BLACK);
		button_Ponto.setForeground(Color.WHITE);
		button_Ponto.addActionListener(this);
		button_Ponto.addKeyListener(this);;
		
		button_0 = new JButton("0");
		button_0.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_0.setBackground(Color.BLACK);
		button_0.setForeground(Color.WHITE);
		button_0.addActionListener(this);
		button_0.addKeyListener(this);
		
		button_Igual = new JButton("=");
		button_Igual.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_Igual.setBackground(new Color(165, 42, 42));
		button_Igual.setForeground(Color.WHITE);
		button_Igual.addActionListener(this);
		button_Igual.addKeyListener(this);
		
		
		button_Mais = new JButton("+");
		button_Mais.setFont(new Font("Tahoma", Font.BOLD, 36));
		button_Mais.setBackground(Color.DARK_GRAY);
		button_Mais.setForeground(Color.WHITE);
		button_Mais.addActionListener(this);
		button_Mais.addKeyListener(this);
		
		panel_Teclado.add(button_7);
		panel_Teclado.add(button_8);
		panel_Teclado.add(button_9);
		panel_Teclado.add(button_Div);
		panel_Teclado.add(button_4);
		panel_Teclado.add(button_5);
		panel_Teclado.add(button_6);
		panel_Teclado.add(button_Mult);
		panel_Teclado.add(button_1);
		panel_Teclado.add(button_2);
		panel_Teclado.add(button_3);
		panel_Teclado.add(button_Menos);
		panel_Teclado.add(button_Ponto);
		panel_Teclado.add(button_0);
		panel_Teclado.add(button_Igual);
		panel_Teclado.add(button_Mais);
		
	}
	
	private void tratamentoTeclado(String key) {
		switch( key )
	    {
	    	case "Limpa":
	    		textField_Texto.setText("0");
	    		ControleCalculadora.limpa();
	    		break;
	    		
	    	case ".":
	    		textField_Texto.setText(
	    				ControleCalculadora.adicionaPonto(textField_Texto.getText()));
	    		break;
	    		
	    	case "x^y": 
	    		key = "^";
	    		textField_Texto.setText(
	        			ControleCalculadora.adicionaOperador(textField_Texto.getText(), key));
	        	break;
	        	
	    	case "x\u00B2":
	    		key = "^2";
	    		textField_Texto.setText(
	        			ControleCalculadora.adicionaOperador(textField_Texto.getText(), key));
	        	break;
	        
	    	case "\u221Ax":
	    		key = "^1/2";
	    		textField_Texto.setText(
	        			ControleCalculadora.adicionaOperador(textField_Texto.getText(), key));
	        	break;
	    	
	    	case "x\u00B9/y":
	    		key = "^1/";
	    		textField_Texto.setText(
	        			ControleCalculadora.adicionaOperador(textField_Texto.getText(), key));
	        	break;
	        	
	    	case "x": 
	    		key = "*";
	    	case "*":
	    		textField_Texto.setText(
	        			ControleCalculadora.adicionaOperador(textField_Texto.getText(), key));
	        	break;
	    	case "+":
	        case "-":		
	        case "/":
	        case "=":
	        case "!":
	        case "Log":
	        case "<-":
	        	textField_Texto.setText(
	        			ControleCalculadora.adicionaOperador(textField_Texto.getText(), key));
	        	break;
	        	
	    	case "0": 
	        case "1": 
	        case "2": 
	        case "3": 
	        case "4": 
	        case "5": 
	        case "6": 
	        case "7": 
	        case "8": 
	        case "9": 
	        	textField_Texto.setText(
	        			ControleCalculadora.adicionaDigito(textField_Texto.getText(), key));
	        	break;
	        default:
	        	break;
	    }
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
			tratamentoTeclado("=");
		
		else if(e.getKeyCode() == KeyEvent.VK_DELETE)
			tratamentoTeclado("Limpa");
		
		else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
			tratamentoTeclado("<-");
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		String key = String.valueOf(e.getKeyChar());
		tratamentoTeclado(key);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = ((JButton)e.getSource()).getText();
		tratamentoTeclado(key);
	}
}
