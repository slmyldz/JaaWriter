package notepad.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import notepad.methods;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.JSplitPane;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import java.awt.Panel;
import java.awt.TextField;

public class layout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -631341651969334835L;
	String text;
	JTextArea textarea;
	private JPanel contentPane;
	TextField bilgi;
	
	

	/**
	 * Launch the application.
	 */
	
    

     
		
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					layout frame = new layout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public layout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 501);
		setTitle("JaWriter");
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnA = new JButton("a\u00E7");
		menuBar.add(btnA);
		
		btnA.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			//String dosyayolu =JOptionPane.showInputDialog(null , "linki giriniz");
    			JFileChooser jfc = new JFileChooser();
    			jfc.showOpenDialog(null);
    			String dosyayolu =String.valueOf(jfc.getSelectedFile());
    			System.out.println("dosya seçme ="+String.valueOf(jfc.getSelectedFile()));
    			String yazi= methods.openfile(dosyayolu);
    			textarea.setText(yazi);
    			bilgi.setText("Dosya baþarýyla açýldý");
    		}
    	});
		
		
		
		JButton btnKaydet = new JButton("kaydet");
		menuBar.add(btnKaydet);

    	btnKaydet.addActionListener(new ActionListener()
    	{

    		public void actionPerformed(ActionEvent e)
    		{
    			//String ad =JOptionPane.showInputDialog(null , "Dosyanýn Adý");
    			JFileChooser jfc = new JFileChooser();
    			jfc.showSaveDialog(null);
    			String yol =String.valueOf(jfc.getSelectedFile());
    			//String yol =JOptionPane.showInputDialog(null , "Dosyanýn yolu");
    			String dosyayolu=(yol);
    			System.out.println(dosyayolu);
    			if(dosyayolu.equals(null)){
    				bilgi.setText("Kayýt yapýlmadý");
    			}
    			if(textarea.getText().length()==0){
    				int a = JOptionPane.showConfirmDialog(null , "Boþ olarak kaydedilsin mi?"," ",0);
    				if (a == 0){
    					methods.CreateFile(dosyayolu);
    					bilgi.setText("Kayýt yapýldý");
    				}
    			}else{
    				methods.filewrite(dosyayolu,textarea.getText());
    				bilgi.setText("Kayýt yapýldý");
    			}
    		}
    	});
		
		JPanel panel = new JPanel();
		menuBar.add(panel);
		
		JButton btnk = new JButton("\u00E7\u0131k\u0131\u015F");
		menuBar.add(btnk);
		btnk.addActionListener(new ActionListener()
    	{

    		public void actionPerformed(ActionEvent e)
    		{
    			//int a =JOptionPane.showConfirmDialog(null , "Çýkmak istediðinden emin misin?");
    			//System.out.print(a);
    			if (bilgi.getText().equals("Kayýt yapýldý") || textarea.getText().length()==0 ){
    				System.exit(0);
    			}else{
    				int a =JOptionPane.showConfirmDialog(null , "Çalýþmanýz kayýt edilmedi çýkalým mý?");
    				if(a==0){
    					System.exit(0);
    				}
    			}
    			
    			
    		}
    	});
		
	
		
		JButton btnHakknda = new JButton("hakk\u0131nda");
		menuBar.add(btnHakknda);
		btnHakknda.addActionListener(new ActionListener()
    	{

    		public void actionPerformed(ActionEvent e)
    		{
    			
    			JOptionPane.showMessageDialog(null , "Selim 2013");

    		}

    	});
		
		JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		 
		textarea = new JTextArea();
		textarea.setWrapStyleWord(true);
		textarea.setTabSize(15);
		textarea.setRows(15);
		textarea.setColumns(15);
		textarea.setLineWrap(true);
		contentPane.add(textarea, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(textarea);
		add(scrollPane, BorderLayout.CENTER);
		Panel panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		bilgi = new TextField();
		bilgi.setEditable(false);
		bilgi.setEnabled(false);
		panel_1.add(bilgi);
		bilgi.setBounds(10,20,100,40);
		bilgi.setPreferredSize(new Dimension(500, 25));
		
	
		
	

		
		
		    		
	}

	

}
