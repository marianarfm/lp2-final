package lp2_final;

import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {
		AppFrame janela = new AppFrame();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    janela.setSize(600, 450);
	    janela.setResizable(false);
	    janela.setLocationRelativeTo(null);
	    janela.setVisible(true);
	}

}
