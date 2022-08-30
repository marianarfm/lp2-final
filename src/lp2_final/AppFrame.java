package lp2_final;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AppFrame extends JFrame implements ActionListener {
	private FlowLayout layout;
	private JMenuBar menuBar;
	private JMenu opcoes;
	private JMenuItem banner, reverter, relatorio;
	//imagem
	private ImageIcon imagem;
	private Image imagemTransf;
	private Image imagemNova;
	private JLabel imagemFinal;
	//itens
	private JLabel mensagem;
	private JButton botaoLoginGerente;
	private JButton botaoLoginCliente;
	
	public AppFrame() {
		super("Auto Atendimento");
		layout = new FlowLayout(FlowLayout.CENTER, 300, 10);
		setLayout(layout);
		//barra de opções
		menuBar = new JMenuBar();
		opcoes = new JMenu("Opções");
		banner = new JMenuItem("Alterar imagem");
		reverter = new JMenuItem("Reverter imagem");
		relatorio = new JMenuItem("Gerar relatório");
		banner.setToolTipText("Tamanho recomendado: 600x255");
		opcoes.add(banner);
		opcoes.add(reverter);
		opcoes.add(relatorio);
		menuBar.add(opcoes);
		setJMenuBar(menuBar);
		//imagem 1
		try {
			imagem = new ImageIcon(getClass().getResource("/img/img1.png"));
		} catch(NullPointerException exc) {
			System.err.println("Erro ao carregar caminho fonte da imagem.");
		}
		imagemTransf = imagem.getImage();
		imagem = new ImageIcon(imagemTransf);
		imagemFinal = new JLabel(imagem);	
		//itens após imagem 1
		mensagem = new JLabel("Bem-vindo(a). Selecione uma das opções:");
		botaoLoginGerente = new JButton("Fazer login como gerente");
		botaoLoginCliente = new JButton("Fazer login como cliente");
		botaoLoginGerente.setPreferredSize(new Dimension(180, 25));
		botaoLoginCliente.setPreferredSize(new Dimension(180, 25));
		
		banner.addActionListener(this);
		reverter.addActionListener(this);
		relatorio.addActionListener(this);
		botaoLoginGerente.addActionListener(this);
		botaoLoginCliente.addActionListener(this);
		
		add(imagemFinal);
		add(mensagem);
		add(botaoLoginGerente);
		add(botaoLoginCliente);
		setVisible(true);
	}
	
	public void adicionarImagem(String caminho) {
		try {
			imagem = new ImageIcon(caminho);
		} catch(NullPointerException exc) {
			System.err.println("Erro ao carregar caminho fonte da imagem.");
		}
		imagemTransf = imagem.getImage();
		imagemNova = imagemTransf.getScaledInstance(600, 255, java.awt.Image.SCALE_SMOOTH);
		imagem = new ImageIcon(imagemNova);
		imagemFinal.setIcon(imagem);
	}

	GerenteClienteFrame gerenteClienteFrame = new GerenteClienteFrame();
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == banner) {
			JFileChooser procurar = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("PNG, JPEG, JPG", "png", "jpeg", "jpg");
			procurar.setAcceptAllFileFilterUsed(false);
			procurar.addChoosableFileFilter(filtro);
			int resultado = procurar.showSaveDialog(null);
			if(resultado == JFileChooser.APPROVE_OPTION) {
				File imgEscolhida = procurar.getSelectedFile();
				String nomeImg = imgEscolhida.getAbsolutePath();
				String caminhoImagem = nomeImg;
				adicionarImagem(caminhoImagem);
			} else if(resultado == JFileChooser.CANCEL_OPTION) {
				System.out.println("Nenhum arquivo selecionado.");
			}
		}
		else if(evento.getSource() == reverter) {
			try {
				imagem = new ImageIcon(getClass().getResource("/img/img1.png"));
			} catch(NullPointerException exc) {
				System.err.println("Erro ao carregar caminho fonte da imagem.");
			}
			imagemTransf = imagem.getImage();
			imagem = new ImageIcon(imagemTransf);
			imagemFinal.setIcon(imagem);
		}
		else if(evento.getSource() == relatorio) {
			if(gerenteClienteFrame.gerarRelatorio() == true) {
				JOptionPane.showMessageDialog(this, "Relatório criado com sucesso.", "Relatório", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(evento.getSource() == botaoLoginGerente) {
			gerenteClienteFrame.GerenteFrame();
		}
		else if(evento.getSource() == botaoLoginCliente) {
			gerenteClienteFrame.ClienteFrame();
		}		
	}
}
