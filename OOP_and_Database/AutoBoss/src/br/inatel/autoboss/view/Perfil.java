/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.autoboss.view;

import br.inatel.autoboss.contoller.ProjetoDAO;
import br.inatel.autoboss.model.Projetos;
import br.inatel.autoboss.contoller.UsuarioGeralDAO;
import br.inatel.autoboss.model.UsuarioHasConhecimento;
import br.inatel.autoboss.contoller.UsuarioHasConhecimentoDAO;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Joao Leonardo
 */
public class Perfil extends javax.swing.JFrame {

    //id do usuario
    private int usuarioId;
    //caminho da imagem
    private String imagem;
    //ArrayList de conhecimentos
    private List<Integer> conhecimentos = new ArrayList<>();

    private List<Projetos> listaProj = new ArrayList<>();
    private String tam = "0";
    private int atual = 0;

    //objeto usuarioGeraldao
    UsuarioGeralDAO udao = new UsuarioGeralDAO();

    //Objeto projeto DAO
    ProjetoDAO projdao = new ProjetoDAO();

    public Perfil() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        jTextField1.setBackground(new Color(0, 0, 0, 200));
    }

    public Perfil(int usuario) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        jTextField1.setBackground(new Color(0, 0, 0, 200));
        usuarioId = usuario;

        jNomeText.setText(udao.retornaNome(usuarioId));
        jEmailText.setText(udao.retornaEmail(usuarioId));
        jSenhaText.setText(udao.retornaSenha(usuarioId));
        jCelularText.setText(udao.retornaTelefone(usuarioId));
        imagem = udao.retornaImagem(usuarioId);
        jLabel11.setIcon(ResizeImage(imagem));

        //objeto usuarioHasConhecimentosdao
        UsuarioHasConhecimentoDAO uhcdao = new UsuarioHasConhecimentoDAO();

        //preenche a lista
        conhecimentos = uhcdao.retornaUsuarioConhecimento(usuarioId);

        for (int i = 0; i < conhecimentos.size(); i++) {
            //Preenche Conhecimentos
            if (conhecimentos.get(i) == 1) {
                jPHP.setSelected(true);
            } else if (conhecimentos.get(i) == 2) {
                jHTML.setSelected(true);
            } else if (conhecimentos.get(i) == 3) {
                jJava.setSelected(true);
            } else if (conhecimentos.get(i) == 4) {
                jSwift.setSelected(true);
            } else if (conhecimentos.get(i) == 5) {
                jPython.setSelected(true);
            } else if (conhecimentos.get(i) == 6) {
                jJS.setSelected(true);
            } else if (conhecimentos.get(i) == 7) {
                jComunicacao.setSelected(true);
            } else if (conhecimentos.get(i) == 8) {
                jAG.setSelected(true);
            } else if (conhecimentos.get(i) == 9) {
                jSolucoes.setSelected(true);
            } else if (conhecimentos.get(i) == 10) {
                jCalculos.setSelected(true);
            } else if (conhecimentos.get(i) == 11) {
                jGestao.setSelected(true);
            } else if (conhecimentos.get(i) == 12) {
                jRedes.setSelected(true);
            }
        }

        //TABELA PORTIFÓLIO        
        //Preenchendo a lista de projetos
        listaProj = projdao.retornaProjetosPeloIdUsuario(usuarioId);

        //setando o tamanho
        tam = Integer.toString((listaProj.size()));

        //mostra o tamanho na interface
        jNProjText.setText(tam);

        //verificando se há projetos
        if (!listaProj.isEmpty()) {
            //mostra na interface
            jPortText.setText(listaProj.get(atual).getNomeProjeto());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jNomeText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jJava = new javax.swing.JCheckBox();
        jRedes = new javax.swing.JCheckBox();
        jHTML = new javax.swing.JCheckBox();
        jSwift = new javax.swing.JCheckBox();
        jPython = new javax.swing.JCheckBox();
        jJS = new javax.swing.JCheckBox();
        jPHP = new javax.swing.JCheckBox();
        jComunicacao = new javax.swing.JCheckBox();
        jAG = new javax.swing.JCheckBox();
        jSolucoes = new javax.swing.JCheckBox();
        jCalculos = new javax.swing.JCheckBox();
        jGestao = new javax.swing.JCheckBox();
        jEditarBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jEmailText = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCelularText = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPortText = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jSenhaText = new javax.swing.JPasswordField();
        jAntProjbtn = new javax.swing.JButton();
        jProxProjBtn = new javax.swing.JButton();
        jNProjText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(1080, 540));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 490, -1));

        jNomeText.setBackground(new java.awt.Color(51, 51, 51));
        jNomeText.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jNomeText.setForeground(new java.awt.Color(255, 255, 255));
        jNomeText.setBorder(null);
        jNomeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNomeTextActionPerformed(evt);
            }
        });
        jPanel2.add(jNomeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 490, 20));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("HABILIDADE:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jJava.setBackground(new java.awt.Color(51, 51, 51));
        jJava.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jJava.setForeground(new java.awt.Color(153, 153, 153));
        jJava.setText("JAVA");
        jPanel2.add(jJava, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        jRedes.setBackground(new java.awt.Color(51, 51, 51));
        jRedes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jRedes.setForeground(new java.awt.Color(153, 153, 153));
        jRedes.setText("REDES");
        jPanel2.add(jRedes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, -1, -1));

        jHTML.setBackground(new java.awt.Color(51, 51, 51));
        jHTML.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jHTML.setForeground(new java.awt.Color(153, 153, 153));
        jHTML.setText("HTML");
        jHTML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHTMLActionPerformed(evt);
            }
        });
        jPanel2.add(jHTML, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        jSwift.setBackground(new java.awt.Color(51, 51, 51));
        jSwift.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSwift.setForeground(new java.awt.Color(153, 153, 153));
        jSwift.setText("SWIFT");
        jPanel2.add(jSwift, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, -1));

        jPython.setBackground(new java.awt.Color(51, 51, 51));
        jPython.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPython.setForeground(new java.awt.Color(153, 153, 153));
        jPython.setText("PYTHON");
        jPanel2.add(jPython, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        jJS.setBackground(new java.awt.Color(51, 51, 51));
        jJS.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jJS.setForeground(new java.awt.Color(153, 153, 153));
        jJS.setText("JAVASCRIPT");
        jPanel2.add(jJS, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, -1, -1));

        jPHP.setBackground(new java.awt.Color(51, 51, 51));
        jPHP.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPHP.setForeground(new java.awt.Color(153, 153, 153));
        jPHP.setText("PHP");
        jPHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPHPActionPerformed(evt);
            }
        });
        jPanel2.add(jPHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        jComunicacao.setBackground(new java.awt.Color(51, 51, 51));
        jComunicacao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComunicacao.setForeground(new java.awt.Color(153, 153, 153));
        jComunicacao.setText("COMUNICAÇÃO");
        jPanel2.add(jComunicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        jAG.setBackground(new java.awt.Color(51, 51, 51));
        jAG.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jAG.setForeground(new java.awt.Color(153, 153, 153));
        jAG.setText("ARTES GRÁFICAS");
        jAG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAGActionPerformed(evt);
            }
        });
        jPanel2.add(jAG, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        jSolucoes.setBackground(new java.awt.Color(51, 51, 51));
        jSolucoes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSolucoes.setForeground(new java.awt.Color(153, 153, 153));
        jSolucoes.setText("SOLUÇÕES");
        jSolucoes.setToolTipText("");
        jPanel2.add(jSolucoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        jCalculos.setBackground(new java.awt.Color(51, 51, 51));
        jCalculos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCalculos.setForeground(new java.awt.Color(153, 153, 153));
        jCalculos.setText("CÁLCULOS");
        jCalculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCalculosActionPerformed(evt);
            }
        });
        jPanel2.add(jCalculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, -1));

        jGestao.setBackground(new java.awt.Color(51, 51, 51));
        jGestao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jGestao.setForeground(new java.awt.Color(153, 153, 153));
        jGestao.setText("GESTÃO");
        jPanel2.add(jGestao, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        jEditarBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        jEditarBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jEditarBtn.setForeground(new java.awt.Color(153, 153, 153));
        jEditarBtn.setText("EDITAR");
        jEditarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarBtnActionPerformed(evt);
            }
        });
        jPanel2.add(jEditarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 300, 50));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("E-MAIL:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 490, -1));

        jEmailText.setBackground(new java.awt.Color(51, 51, 51));
        jEmailText.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jEmailText.setForeground(new java.awt.Color(255, 255, 255));
        jEmailText.setBorder(null);
        jEmailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmailTextActionPerformed(evt);
            }
        });
        jPanel2.add(jEmailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 490, 20));

        jSeparator5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 180, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("CELULAR:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("SENHA:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jCelularText.setBackground(new java.awt.Color(51, 51, 51));
        jCelularText.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCelularText.setForeground(new java.awt.Color(255, 255, 255));
        jCelularText.setBorder(null);
        jCelularText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCelularTextActionPerformed(evt);
            }
        });
        jPanel2.add(jCelularText, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 180, 20));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 180, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("NOME:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel11.setBackground(new java.awt.Color(204, 0, 153));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/imagem_perfil.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 120, 170));

        jScrollPane2.setBorder(null);

        jPortText.setEditable(false);
        jPortText.setBackground(new java.awt.Color(51, 51, 51));
        jPortText.setColumns(20);
        jPortText.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPortText.setForeground(new java.awt.Color(255, 255, 255));
        jPortText.setRows(5);
        jPortText.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PORTIFÓLIO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 18), new java.awt.Color(153, 153, 153))); // NOI18N
        jScrollPane2.setViewportView(jPortText);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 300, 280));

        jButton2.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 153, 153));
        jButton2.setText("TROCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 80, -1));

        jSenhaText.setBackground(new java.awt.Color(51, 51, 51));
        jSenhaText.setForeground(new java.awt.Color(255, 255, 255));
        jSenhaText.setBorder(null);
        jPanel2.add(jSenhaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 180, 20));

        jAntProjbtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        jAntProjbtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jAntProjbtn.setForeground(new java.awt.Color(153, 153, 153));
        jAntProjbtn.setText("ANTERIOR");
        jAntProjbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAntProjbtnActionPerformed(evt);
            }
        });
        jPanel2.add(jAntProjbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 100, -1));

        jProxProjBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        jProxProjBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jProxProjBtn.setForeground(new java.awt.Color(153, 153, 153));
        jProxProjBtn.setText("PRÓXIMO");
        jProxProjBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProxProjBtnActionPerformed(evt);
            }
        });
        jPanel2.add(jProxProjBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 380, 100, -1));

        jNProjText.setEditable(false);
        jNProjText.setBackground(new java.awt.Color(51, 51, 51));
        jNProjText.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jNProjText.setForeground(new java.awt.Color(153, 153, 153));
        jNProjText.setBorder(null);
        jPanel2.add(jNProjText, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, 30, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Número de Projetos:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1070, 540));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("PERFIL");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jTextField1.setPreferredSize(new java.awt.Dimension(1082, 186));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1090, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/perfil.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1080, 184));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setBorder(null);
        jMenuBar1.setMinimumSize(new java.awt.Dimension(56, 25));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(200, 30));

        jMenu3.setBackground(new java.awt.Color(51, 51, 51));
        jMenu3.setText("PERFIL");
        jMenu3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(95, 25));
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(51, 51, 51));
        jMenu4.setBorder(null);
        jMenu4.setText("PROJETOS");
        jMenu4.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jMenu4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(95, 25));

        jMenuItem1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem1.setText("FREELANCER");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(115, 25));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenuItem2.setText("CLIENTE");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(115, 25));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu2.setBackground(new java.awt.Color(51, 51, 51));
        jMenu2.setText("CRIAR");
        jMenu2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(95, 25));
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu1.setBackground(new java.awt.Color(51, 51, 51));
        jMenu1.setText("BUSCAR");
        jMenu1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(95, 25));
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu5.setBackground(new java.awt.Color(51, 51, 51));
        jMenu5.setText("SAIR");
        jMenu5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(95, 25));
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jNomeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNomeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNomeTextActionPerformed

    private void jEmailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailTextActionPerformed

    private void jCelularTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCelularTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCelularTextActionPerformed

    private void jHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHTMLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jHTMLActionPerformed

    private void jCalculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCalculosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCalculosActionPerformed

    private void jPHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPHPActionPerformed

    private void jAGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAGActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filter the files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        //if the user click on save in Jfilechooser
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            imagem = selectedFile.getAbsolutePath();
            jLabel11.setIcon(ResizeImage(imagem));
        } //if the user click on save in Jfilechooser
        else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No File Select");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        Perfil perfil = new Perfil(usuarioId);
        perfil.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ProjetosFreela projetosFreela = new ProjetosFreela(usuarioId);
        projetosFreela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ProjetosCliente projetosCliente = new ProjetosCliente(usuarioId);
        projetosCliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        Criar criar = new Criar(usuarioId);
        criar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        Buscar buscar = new Buscar(usuarioId);
        buscar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jEditarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarBtnActionPerformed

        String nome = jNomeText.getText();
        String email = jEmailText.getText();
        String senha = String.valueOf(jSenhaText.getPassword());
        int celular = 0;
        //tratamento para celular
        try {
            celular = Integer.parseInt(jCelularText.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite apenas números para o celular!");
        }

        //objeto usuarioGeralDao
        UsuarioGeralDAO udao = new UsuarioGeralDAO();

        //coverte de volta pra string
        String cel = Integer.toString(celular);
        //método atualiza
        udao.atualizarUsuarioPeloId(usuarioId, nome, email, senha, cel, imagem);

        //Atualizando os conhecimentos
        //objeto UsuarioHasConhecimentoDao
        UsuarioHasConhecimentoDAO uhcdao = new UsuarioHasConhecimentoDAO();

        //apagando os conhecimentos preexistentes
        for (int i = 0; i < conhecimentos.size(); i++) {
            //seta o id do conhecimento que esta guardado no arrayList
            uhcdao.deleteUsuariosHasConhecimentosPeloId(usuarioId, conhecimentos.get(i));
        }

        //ArrayList novosConhecimentos
        List<Integer> novosConhecimentos = new ArrayList<>();

        //Preenchendo novosConhecimentos
        if (jPHP.isSelected()) {
            novosConhecimentos.add(1);
        }
        if (jHTML.isSelected()) {
            novosConhecimentos.add(2);
        }
        if (jJava.isSelected()) {
            novosConhecimentos.add(3);
        }
        if (jSwift.isSelected()) {
            novosConhecimentos.add(4);
        }
        if (jPython.isSelected()) {
            novosConhecimentos.add(5);
        }
        if (jJS.isSelected()) {
            novosConhecimentos.add(6);
        }
        if (jComunicacao.isSelected()) {
            novosConhecimentos.add(7);
        }
        if (jAG.isSelected()) {
            novosConhecimentos.add(8);
        }
        if (jSolucoes.isSelected()) {
            novosConhecimentos.add(9);
        }
        if (jCalculos.isSelected()) {
            novosConhecimentos.add(10);
        }
        if (jGestao.isSelected()) {
            novosConhecimentos.add(11);
        }
        if (jRedes.isSelected()) {
            novosConhecimentos.add(12);
        }

        //objteto UsuarioHasConhecimento
        UsuarioHasConhecimento uhc = new UsuarioHasConhecimento(usuarioId, 0);

        for (int i = 0; i < novosConhecimentos.size(); i++) {
            //seta o id do conhecimento que esta guardado no arrayList
            uhc.setId_conhecimento(novosConhecimentos.get(i));

            //realiza a introdução no banco de dados
            uhcdao.inserirUsuarioHasConhecimento(uhc);
        }
        if(nome==""||email==""||senha==""||celular==0||novosConhecimentos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não deixe itens sem preencher!!");
        } else {
            JOptionPane.showMessageDialog(null, "Alterações realizadas com sucesso!");
            //Recarrega a página
            Perfil perfil = new Perfil(usuarioId);
            perfil.setVisible(true);
            dispose();
        }


    }//GEN-LAST:event_jEditarBtnActionPerformed

    private void jAntProjbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAntProjbtnActionPerformed
        if (atual == 0 && !listaProj.isEmpty()) {
            //seta o contador
            atual = Integer.parseInt(tam) - 1;

            //mostra na interface
            jPortText.setText(listaProj.get(atual).getNomeProjeto());
        } else if (!listaProj.isEmpty()) {
            //soma o contador
            atual--;

            //mostra na interface
            jPortText.setText(listaProj.get(atual).getNomeProjeto());
        } else {
            JOptionPane.showMessageDialog(null, "Ainda não há projetos desenvolvidos!");
        }
    }//GEN-LAST:event_jAntProjbtnActionPerformed

    private void jProxProjBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProxProjBtnActionPerformed
        if (tam.equals(Integer.toString(atual + 1)) && !listaProj.isEmpty()) {
            //seta o contador
            atual = 0;

            //mostra na interface
            jPortText.setText(listaProj.get(atual).getNomeProjeto());
        } else if (!listaProj.isEmpty()) {
            //soma o contador
            atual++;

            //mostra na interface
            jPortText.setText(listaProj.get(atual).getNomeProjeto());
        } else {
            JOptionPane.showMessageDialog(null, "Ainda não há projetos desenvolvidos!");
        }
    }//GEN-LAST:event_jProxProjBtnActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jAG;
    private javax.swing.JButton jAntProjbtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCalculos;
    private javax.swing.JTextField jCelularText;
    private javax.swing.JCheckBox jComunicacao;
    private javax.swing.JButton jEditarBtn;
    private javax.swing.JTextField jEmailText;
    private javax.swing.JCheckBox jGestao;
    private javax.swing.JCheckBox jHTML;
    private javax.swing.JCheckBox jJS;
    private javax.swing.JCheckBox jJava;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JTextField jNProjText;
    private javax.swing.JTextField jNomeText;
    private javax.swing.JCheckBox jPHP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextArea jPortText;
    private javax.swing.JButton jProxProjBtn;
    private javax.swing.JCheckBox jPython;
    private javax.swing.JCheckBox jRedes;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPasswordField jSenhaText;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JCheckBox jSolucoes;
    private javax.swing.JCheckBox jSwift;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
