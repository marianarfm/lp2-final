package lp2_final;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GerenteClienteFrame {
	AutoAtendimento atend = new AutoAtendimento();
	
	private JDialog login;
	private FlowLayout layout;
	private JLabel campo1, campo2, campo3, campo4, campo5;
	private JTextField campo1Texto, campo2Texto, campo3Texto, campo4Texto, campo5Texto;
	private JTextArea mensagemErro, mensagemAviso1, mensagemAviso2, mensagemCima1;
	private JButton botao1, botao2, botao3;
	private JDialog menu, opcao;
	private ImageIcon imagem;
	private Image imagemTransf;
	private Image imagemNova;
	private JLabel imagemFinal;
	private File relatorio = new File("src/arquivos/Relatório.txt");
	private File dados = new File("src/arquivos/Dados.txt");
	private ArrayList<String> eventos = new ArrayList<String>();
	
	public GerenteClienteFrame() {};
	
	public void GerenteFrame() {
		login = new JDialog();
		login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		login.setSize(260, 215);
		login.setResizable(false);
		login.setLocationRelativeTo(null);
		layout = new FlowLayout(FlowLayout.CENTER);
		login.setLayout(layout);
		login.setTitle("Login do Gerente");
		login.setModal(true);
		
		campo1 = new JLabel("Agência:");
		campo2 = new JLabel("Senha:");
		botao1 = new JButton("Enviar");
		campo1Texto = new JTextField(20);
		campo2Texto = new JTextField(20);
		botao1.setPreferredSize(new Dimension(135, 25));
		//mensagens de erro e avisos
		mensagemErro = new JTextArea("Número da agência e/ou senha inválido(s). Tente novamente.");
		mensagemErro.setPreferredSize(new Dimension(180, 40));
		mensagemErro.setOpaque(false);
		mensagemErro.setLineWrap(true);
		mensagemErro.setWrapStyleWord(true);
		mensagemErro.setEditable(false);
		mensagemErro.setFocusable(false);
		mensagemErro.setVisible(false);
		
		botao1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
				try {
					int numero = Integer.parseInt(campo1Texto.getText());
					int senha = Integer.parseInt(campo2Texto.getText());
					if(atend.loginGerente(numero, senha) == true) {
						eventos.add("Usuário fez login como gerente, "+java.time.LocalTime.now());
						//janela do gerente após efetuar login
						login.dispose();
						menu = new JDialog();
						menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						menu.setSize(450, 350);
						menu.setResizable(false);
						menu.setLocationRelativeTo(null);
						layout = new FlowLayout(FlowLayout.CENTER, 30, 15);
						menu.setLayout(layout);
						menu.setTitle("Menu do Gerente");
						menu.setModal(true);
						//imagem 2
						try {
							imagem = new ImageIcon(getClass().getResource("/img/img2.png"));
						} catch(NullPointerException exc) {
							System.err.println("Erro ao carregar caminho fonte da imagem.");
						}
						imagemTransf = imagem.getImage();
						imagemNova = imagemTransf.getScaledInstance(450, 191, java.awt.Image.SCALE_SMOOTH);
						imagem = new ImageIcon(imagemNova);
						imagemFinal = new JLabel(imagem);
						//itens após imagem 2
						botao1 = new JButton("Cadastrar um cliente");
						botao2 = new JButton("Excluir um cliente");
						botao3 = new JButton("Salvar dados");
						botao1.setPreferredSize(new Dimension(160, 25));
						botao2.setPreferredSize(new Dimension(160, 25));
						botao3.setPreferredSize(new Dimension(160, 25));
						
						botao1.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evento) {
								opcao = new JDialog();
								opcao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								opcao.setSize(410, 330);
								opcao.setResizable(false);
								opcao.setLocationRelativeTo(null);
								layout = new FlowLayout(FlowLayout.CENTER, 5, 10);
								opcao.setLayout(layout);
								opcao.setTitle("Cadastro");
								opcao.setModal(true);
								
								mensagemCima1 = new JTextArea("Cadastre os clientes desejados digitando seus respectivos nomes, CPFs, números, saldos e senhas de suas contas.");
								mensagemCima1.setPreferredSize(new Dimension(360, 40));
								mensagemCima1.setOpaque(false);
								mensagemCima1.setLineWrap(true);
								mensagemCima1.setWrapStyleWord(true);
								mensagemCima1.setEditable(false);
								mensagemCima1.setFocusable(false);
								mensagemAviso1 = new JTextArea("");
								campo1 = new JLabel("Nome do cliente:");
								campo2 = new JLabel("CPF do cliente:");
								campo3 = new JLabel("Número da conta:");
								campo4 = new JLabel("Saldo da conta:");
								campo5 = new JLabel("Senha da conta:");
								campo1.setPreferredSize(new Dimension(100, 10));
								campo2.setPreferredSize(new Dimension(100, 10));
								campo3.setPreferredSize(new Dimension(100, 10));
								campo4.setPreferredSize(new Dimension(100, 10));
								campo5.setPreferredSize(new Dimension(100, 10));
								campo1Texto = new JTextField(20);
								campo2Texto = new JTextField(20);
								campo3Texto = new JTextField(20);
								campo4Texto = new JTextField(20);
								campo5Texto = new JTextField(20);
								botao1 = new JButton("Enviar");
								//mensagens de erro e aviso
								mensagemErro = new JTextArea("Um ou mais campos inválidos. Certifique-se de que os valores foram digitados corretamente e tente novamente.");
								mensagemErro.setPreferredSize(new Dimension(360, 40));
								mensagemErro.setOpaque(false);
								mensagemErro.setLineWrap(true);
								mensagemErro.setWrapStyleWord(true);
								mensagemErro.setEditable(false);
								mensagemErro.setFocusable(false);
								mensagemErro.setVisible(false);
								mensagemAviso1 = new JTextArea("Cliente cadastrado com sucesso.");
								mensagemAviso1.setPreferredSize(new Dimension(360, 60));
								mensagemAviso1.setOpaque(false);
								mensagemAviso1.setLineWrap(true);
								mensagemAviso1.setWrapStyleWord(true);
								mensagemAviso1.setEditable(false);
								mensagemAviso1.setVisible(false);
								mensagemAviso2 = new JTextArea("Cliente já cadastrado. Tente novamente.");
								mensagemAviso2.setPreferredSize(new Dimension(360, 60));
								mensagemAviso2.setOpaque(false);
								mensagemAviso2.setLineWrap(true);
								mensagemAviso2.setWrapStyleWord(true);
								mensagemAviso2.setEditable(false);
								mensagemAviso2.setFocusable(false);
								mensagemAviso2.setVisible(false);
								
								botao1.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent evento) {
										try {
											String nome = campo1Texto.getText();
											long CPF = Long.parseLong(campo2Texto.getText());
											int numero = Integer.parseInt(campo3Texto.getText());
											float saldo = Float.parseFloat(campo4Texto.getText());
											int senha = Integer.parseInt(campo5Texto.getText());
											Conta conta = new Conta(numero, saldo, senha);
											Cliente cliente = new Cliente(nome, CPF, conta);
											if(atend.gerenteCadastrarCliente(cliente) == true) {
												eventos.add("Usuário cadastrou um cliente como gerente, "+java.time.LocalTime.now());
												mensagemErro.setVisible(false);
												mensagemAviso1.setVisible(true);
												mensagemAviso2.setVisible(false);
											} else {
												mensagemErro.setVisible(false);
												mensagemAviso1.setVisible(false);
												mensagemAviso2.setVisible(true);
											}
										} catch(NumberFormatException exc) {
											mensagemErro.setVisible(true);
											mensagemAviso1.setVisible(false);
											mensagemAviso2.setVisible(false);
										}
									}
								});
								opcao.add(mensagemCima1);
								opcao.add(campo1);
								opcao.add(campo1Texto);
								opcao.add(campo2);
								opcao.add(campo2Texto);
								opcao.add(campo3);
								opcao.add(campo3Texto);
								opcao.add(campo4);
								opcao.add(campo4Texto);
								opcao.add(campo5);
								opcao.add(campo5Texto);
								opcao.add(botao1);
								opcao.add(mensagemErro);
								opcao.add(mensagemAviso1);
								opcao.add(mensagemAviso2);
								opcao.setVisible(true);
							}
						});
						
						botao2.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evento) {
								opcao = new JDialog();
								opcao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								opcao.setSize(410, 240);
								opcao.setResizable(false);
								opcao.setLocationRelativeTo(null);
								layout = new FlowLayout(FlowLayout.CENTER, 5, 20);
								opcao.setLayout(layout);
								opcao.setTitle("Exclusão");
								opcao.setModal(true);
								
								mensagemCima1 = new JTextArea("Exclua os clientes desejados digitando seus respectivos CPFs e pressionando 'Excluir'.");
								mensagemCima1.setPreferredSize(new Dimension(360, 30));
								mensagemCima1.setOpaque(false);
								mensagemCima1.setLineWrap(true);
								mensagemCima1.setWrapStyleWord(true);
								mensagemCima1.setEditable(false);
								mensagemCima1.setFocusable(false);
								campo1 = new JLabel("CPF do cliente:");
								campo1Texto = new JTextField(20);
								botao1 = new JButton("Excluir");
								//mensagens de erro e aviso
								mensagemErro = new JTextArea("CPF digitado inválido/inexistente. Certifique-se de que um inteiro foi digitado no campo e tente novamente.");
								mensagemErro.setPreferredSize(new Dimension(360, 60));
								mensagemErro.setOpaque(false);
								mensagemErro.setLineWrap(true);
								mensagemErro.setWrapStyleWord(true);
								mensagemErro.setEditable(false);
								mensagemErro.setFocusable(false);
								mensagemErro.setVisible(false);
								mensagemAviso1 = new JTextArea("Cliente excluído com sucesso.");
								mensagemAviso1.setPreferredSize(new Dimension(360, 60));
								mensagemAviso1.setOpaque(false);
								mensagemAviso1.setLineWrap(true);
								mensagemAviso1.setWrapStyleWord(true);
								mensagemAviso1.setEditable(false);
								mensagemAviso1.setFocusable(false);
								mensagemAviso1.setVisible(false);
								
								botao1.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent evento) {
										try {
											long CPF = Long.parseLong(campo1Texto.getText());
											if(atend.gerenteExcluirCliente(CPF) == true) {
												eventos.add("Usuário excluiu um cliente como gerente, "+java.time.LocalTime.now());
												mensagemErro.setVisible(false);
												mensagemAviso1.setVisible(true);
											} else {
												mensagemErro.setVisible(true);
												mensagemAviso1.setVisible(false);
											}
										} catch(NumberFormatException exc) {
											mensagemErro.setVisible(true);
											mensagemAviso1.setVisible(false);
										}
									}
								});
								opcao.add(mensagemCima1);
								opcao.add(campo1);
								opcao.add(campo1Texto);
								opcao.add(botao1);
								opcao.add(mensagemErro);
								opcao.add(mensagemAviso1);
								opcao.setVisible(true);
							}
						});
						
						botao3.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evento) {
								guardarDados();
								JOptionPane.showMessageDialog(menu, "Dados dos clientes da sessão atual do Auto Atendimento armazenados.", "Salvar dados", JOptionPane.INFORMATION_MESSAGE);
							}
						});
						
						menu.add(imagemFinal);
						menu.add(botao1);
						menu.add(botao2);
						menu.add(botao3);
						menu.setVisible(true);
					} else {
						mensagemErro.setVisible(true);
					}
				} catch(NumberFormatException exc) {
					mensagemErro.setVisible(true);
				}
			}
		});
		login.add(campo1);
		login.add(campo1Texto);
		login.add(campo2);
		login.add(campo2Texto);
		login.add(botao1);
		login.add(mensagemErro);
		login.setVisible(true);
	}
	
	public void ClienteFrame() {
		login = new JDialog();
		login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		login.setSize(260, 215);
		login.setResizable(false);
		login.setLocationRelativeTo(null);
		layout = new FlowLayout(FlowLayout.CENTER);
		login.setLayout(layout);
		login.setTitle("Login do Cliente");
		login.setModal(true);
		
		campo1 = new JLabel("Conta:");
		campo2 = new JLabel("Senha:");
		botao1 = new JButton("Enviar");
		campo1Texto = new JTextField(20);
		campo2Texto = new JTextField(20);
		botao1.setPreferredSize(new Dimension(135, 25));
		//mensagens de erro e avisos
		mensagemErro = new JTextArea("Número da conta e/ou senha inválido(s). Tente novamente.");
		mensagemErro.setPreferredSize(new Dimension(180, 40));
		mensagemErro.setOpaque(false);
		mensagemErro.setLineWrap(true);
		mensagemErro.setWrapStyleWord(true);
		mensagemErro.setEditable(false);
		mensagemErro.setFocusable(false);
		mensagemErro.setVisible(false);
		
		botao1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
				try {
					int numero = Integer.parseInt(campo1Texto.getText());
					int senha = Integer.parseInt(campo2Texto.getText());
					if(atend.loginCliente(numero, senha) == true) {
						eventos.add("Usuário fez login como cliente, "+java.time.LocalTime.now());
						//janela do cliente após efetuar login
						login.dispose();
						menu = new JDialog();
						menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						menu.setSize(450, 350);
						menu.setResizable(false);
						menu.setLocationRelativeTo(null);
						layout = new FlowLayout(FlowLayout.CENTER, 10, 25);
						menu.setLayout(layout);
						menu.setTitle("Menu do Cliente");
						menu.setModal(true);
						//imagem 3
						try {
							imagem = new ImageIcon(getClass().getResource("/img/img3.png"));
						} catch(NullPointerException exc) {
							System.err.println("Erro ao carregar caminho fonte da imagem.");
						}
						imagemTransf = imagem.getImage();
						imagemNova = imagemTransf.getScaledInstance(450, 191, java.awt.Image.SCALE_SMOOTH);
						imagem = new ImageIcon(imagemNova);
						imagemFinal = new JLabel(imagem);
						//itens após imagem 3
						botao1 = new JButton("Sacar");
						botao2 = new JButton("Depositar");
						botao3 = new JButton("Verificar saldo");
						botao1.setPreferredSize(new Dimension(120, 25));
						botao2.setPreferredSize(new Dimension(120, 25));
						botao3.setPreferredSize(new Dimension(120, 25));
						
						botao1.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evento) {
								opcao = new JDialog();
								opcao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								opcao.setSize(340, 265);
								opcao.setResizable(false);
								opcao.setLocationRelativeTo(null);
								layout = new FlowLayout(FlowLayout.CENTER, 5, 15);
								opcao.setLayout(layout);
								opcao.setTitle("Saque");
								opcao.setModal(true);
								
								mensagemCima1 = new JTextArea("Digite um valor a ser retirado em reais. Seu saldo atual:");
								mensagemCima1.setPreferredSize(new Dimension(290, 35));
								mensagemCima1.setOpaque(false);
								mensagemCima1.setLineWrap(true);
								mensagemCima1.setWrapStyleWord(true);
								mensagemCima1.setEditable(false);
								mensagemCima1.setFocusable(false);
								campo1 = new JLabel("Saque:");
								campo1Texto = new JTextField(20);
								botao1 = new JButton("Sacar");
								campo2 = new JLabel("R$ "+String.format("%.2f", atend.clienteVerificarSaldo(numero, senha)));
								campo2.setPreferredSize(new Dimension(310, 15));
								campo2.setHorizontalAlignment(JLabel.CENTER);
								//mensagens de erro e avisos
								mensagemErro = new JTextArea("Valor inválido/superior ao saldo, verifique se o campo possui um número e tente novamente.");
								mensagemErro.setPreferredSize(new Dimension(290, 45));
								mensagemErro.setOpaque(false);
								mensagemErro.setLineWrap(true);
								mensagemErro.setWrapStyleWord(true);
								mensagemErro.setEditable(false);
								mensagemErro.setFocusable(false);
								mensagemErro.setVisible(false);
								mensagemAviso1 = new JTextArea("Saque efetuado com sucesso.");
								mensagemAviso1.setPreferredSize(new Dimension(290, 35));
								mensagemAviso1.setOpaque(false);
								mensagemAviso1.setLineWrap(true);
								mensagemAviso1.setWrapStyleWord(true);
								mensagemAviso1.setEditable(false);
								mensagemAviso1.setFocusable(false);
								mensagemAviso1.setVisible(false);
			
								botao1.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent evento) {
										try {
											float valor = Float.parseFloat(campo1Texto.getText());
											if(atend.clienteSacar(numero, valor, senha) == true) {
												eventos.add("Usuário fez um saque como cliente, "+java.time.LocalTime.now());
												campo2.setText("R$ "+String.format("%.2f", atend.clienteVerificarSaldo(numero, senha)));
												mensagemErro.setVisible(false);
												mensagemAviso1.setVisible(true);
											} else {
												mensagemErro.setVisible(true);
												mensagemAviso1.setVisible(false);
											}
										} catch(NumberFormatException exc) {
											mensagemErro.setVisible(true);
											mensagemAviso1.setVisible(false);
										}
									}
								});
								opcao.add(mensagemCima1);
								opcao.add(campo2);
								opcao.add(campo1);
								opcao.add(campo1Texto);
								opcao.add(botao1);
								opcao.add(mensagemErro);
								opcao.add(mensagemAviso1);
								opcao.setVisible(true);
							}
						});
						
						botao2.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evento) {
								opcao = new JDialog();
								opcao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								opcao.setSize(340, 265);
								opcao.setResizable(false);
								opcao.setLocationRelativeTo(null);
								layout = new FlowLayout(FlowLayout.CENTER, 5, 15);
								opcao.setLayout(layout);
								opcao.setTitle("Depósito");
								opcao.setModal(true);
								
								mensagemCima1 = new JTextArea("Digite um valor a ser depositado em reais. Seu saldo atual:");
								mensagemCima1.setPreferredSize(new Dimension(290, 35));
								mensagemCima1.setOpaque(false);
								mensagemCima1.setLineWrap(true);
								mensagemCima1.setWrapStyleWord(true);
								mensagemCima1.setEditable(false);
								mensagemCima1.setFocusable(false);
								campo1 = new JLabel("Depósito:");
								campo1Texto = new JTextField(20);
								botao1 = new JButton("Depositar");
								campo2 = new JLabel("R$ "+String.format("%.2f", atend.clienteVerificarSaldo(numero, senha)));
								campo2.setPreferredSize(new Dimension(310, 15));
								campo2.setHorizontalAlignment(JLabel.CENTER);
								//mensagens de erro e avisos
								mensagemErro = new JTextArea("Valor inválido, verifique se o campo possui um número e tente novamente.");
								mensagemErro.setPreferredSize(new Dimension(290, 45));
								mensagemErro.setOpaque(false);
								mensagemErro.setLineWrap(true);
								mensagemErro.setWrapStyleWord(true);
								mensagemErro.setEditable(false);
								mensagemErro.setFocusable(false);
								mensagemErro.setVisible(false);
								mensagemAviso1 = new JTextArea("Depósito efetuado com sucesso.");
								mensagemAviso1.setPreferredSize(new Dimension(290, 40));
								mensagemAviso1.setOpaque(false);
								mensagemAviso1.setLineWrap(true);
								mensagemAviso1.setWrapStyleWord(true);
								mensagemAviso1.setEditable(false);
								mensagemAviso1.setFocusable(false);
								mensagemAviso1.setVisible(false);
								
								botao1.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent evento) {
										try {
											float valor = Float.parseFloat(campo1Texto.getText());
											if(atend.clienteDepositar(numero, valor, senha) == true) {
												eventos.add("Usuário fez um depósito como cliente, "+java.time.LocalTime.now());
												campo2.setText("R$ "+String.format("%.2f", atend.clienteVerificarSaldo(numero, senha)));
												mensagemErro.setVisible(false);
												mensagemAviso1.setVisible(true);
											} else {
												mensagemErro.setVisible(true);
												mensagemAviso1.setVisible(false);
											}
										} catch(NumberFormatException exc) {
											mensagemErro.setVisible(true);
											mensagemAviso1.setVisible(false);
										}
									}
								});
								opcao.add(mensagemCima1);
								opcao.add(campo2);
								opcao.add(campo1);
								opcao.add(campo1Texto);
								opcao.add(botao1);
								opcao.add(mensagemErro);
								opcao.add(mensagemAviso1);
								opcao.setVisible(true);
							}
						});
						
						botao3.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evento) {
								eventos.add("Usuário verificou o saldo como cliente, "+java.time.LocalTime.now());
								JOptionPane.showMessageDialog(opcao, "O seu saldo atual é: R$ "+String.format("%.2f", atend.clienteVerificarSaldo(numero, senha)), "Saldo", JOptionPane.INFORMATION_MESSAGE);
							}
						});
						menu.add(imagemFinal);
						menu.add(botao1);
						menu.add(botao2);
						menu.add(botao3);
						menu.setVisible(true);
					} else {
						mensagemErro.setVisible(true);
					}
				} catch(NumberFormatException exc) {
					mensagemErro.setVisible(true);
				}
			}
		});
		login.add(campo1);
		login.add(campo1Texto);
		login.add(campo2);
		login.add(campo2Texto);
		login.add(botao1);
		login.add(mensagemErro);
		login.setVisible(true);
	}
	
	public boolean gerarRelatorio() {
		try {
			if(relatorio.createNewFile() == true) {
				try {
					FileWriter esc = new FileWriter("src/arquivos/Relatório.txt");
					for(int i = 0; i < eventos.size(); i++) {
						esc.write(eventos.get(i)+", "+java.time.LocalTime.now()+"\n");
					}
					esc.close();
				} catch(java.io.IOException exc) {
					System.err.println("Erro ao escrever no arquivo.");
				}
				return true;
			} else {
				relatorio.delete();
				if(relatorio.createNewFile() == true) {
					try {
						FileWriter esc = new FileWriter("src/arquivos/Relatório.txt");
						for(int i = 0; i < eventos.size(); i++) {
							esc.write(eventos.get(i)+"\n");
						}
						esc.close();
					} catch(java.io.IOException exc) {
						System.err.println("Erro ao escrever no arquivo.");
					}
					return true;
				}
			}
		} catch(java.io.IOException exc) {
			System.err.println("Erro ao criar arquivo do relatório.");
		}
		return false;
	}
	
	public void guardarDados() {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			//escrita dos dados
			BufferedWriter esc = new BufferedWriter(new FileWriter(dados, true));
			for(int i = 0; i < atend.banco.getClientes().size(); i++) {
				esc.newLine();
				esc.write(atend.banco.getClientes().get(i).getNome()+"; ");
				esc.write(atend.banco.getClientes().get(i).getCPF()+"; ");
				esc.write(atend.banco.getClientes().get(i).getConta().getNumero()+"; ");
				esc.write((float) atend.banco.getClientes().get(i).getConta().getSaldo()+"; ");
				esc.write(atend.banco.getClientes().get(i).getConta().getSenha()+" - ");	
				esc.write("da sessão de "+dtf.format(now));
				esc.close();
			}
		} catch (java.io.IOException exc) {
			System.err.println("Erro ao escrever no arquivo de dados.");
		}
	}
}
