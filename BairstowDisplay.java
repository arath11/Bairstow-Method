import java.awt.BorderLayout;

import javax.swing.JFrame;

public class BairstowDisplay extends JFrame {
	
	public BairstowDisplay() {
		super("Mi primer ventana en Java");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Cierra la ventana y detiene el programa
		myPanelBairstow pd=new myPanelBairstow();
		this.add(pd);
		this.pack();
		//Se ajusta del tamaño de los componentes que contiene
		this.setVisible(true);
		//Hace que la ventana sea visible
	}
	
	public static void main(String[] args) {
		BairstowDisplay window = new BairstowDisplay();
		
	}
}

