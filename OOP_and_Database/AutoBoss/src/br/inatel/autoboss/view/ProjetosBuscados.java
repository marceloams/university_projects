/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.autoboss.view;

import br.inatel.autoboss.contoller.ProjetoDAO;
import br.inatel.autoboss.model.ProjetoHasConhecimento;
import br.inatel.autoboss.contoller.ProjetoHasConhecimentoDAO;
import br.inatel.autoboss.model.Projetos;
import br.inatel.autoboss.model.UsuarioHasConhecimento;
import br.inatel.autoboss.contoller.UsuarioHasConhecimentoDAO;
import java.awt.Color;
import static java.lang.Float.parseFloat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Joao Leonardo
 */
public class ProjetosBuscados extends javax.swing.JFrame {

    private int usuarioId;
    private String categoria;
    List<Projetos> listaProj = new ArrayList<>();
    private int atual = 0;
    private String tam = "0";
    private int idProjeto;
    
    //Objeto projetosDao
    ProjetoDAO projdao = new ProjetoDAO();
    
    public ProjetosBuscados() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        jTextField1.setBackground(new Color(0, 0, 0, 200));
    }
    
    public ProjetosBuscados(int usuario, String cat) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        jTextField1.setBackground(new Color(0, 0, 0, 200)); 
        usuarioId = usuario;
        categoria = cat;
        
        //marcando a categoria
        switch (categoria) {
            case "WebSites e Apps":
                jWebbtn.setSelected(true);
                break;
            case "Softwares e Sistemas":
                jSoftbtn.setSelected(true);
                break;
            case "Engenharia e Manufatura":
                jEngbtn.setSelected(true);
                break;
            case "Marketing e Vendas":
                jMktbtn.setSelected(true);
                break;
            case "Desing e Multimedia":
                jDmbtn.setSelected(true);
                break;
            case "Gestão e Consultoria":
                jGcbtn.setSelected(true);
                break;
            default:
                break;
        }
        
        //preenchendo a lista de projetos
        listaProj = projdao.retornaProjetosPelaCategoria(categoria);
        
        //verificando se há projetos
        if(listaProj.isEmpty())
        {
            jNumProj.setText(tam);
        }else{
            //mostrando os valores
            tam = Integer.toString((listaProj.size()));
            jNumProj.setText(tam);
            jNomePText.setText(listaProj.get(atual).getNomeProjeto());
            jPminText.setText(Float.toString(listaProj.get(atual).getPrecoMin()));
            jPmaxText.setText(Float.toString(listaProj.get(atual).getPrecoMax()));
            jDescricaoText.setText(listaProj.get(atual).getDescricaoProjeto());
            jNumAtual.setText(Integer.toString(atual+1)); 
            
            //ArrayList de ProjetoHasConhecimentos
            List<ProjetoHasConhecimento> listaConhecimentos = new ArrayList<>();
            
            //criando o objeto ProjetoHasConhecimentoDAO
            ProjetoHasConhecimentoDAO phcdao = new ProjetoHasConhecimentoDAO();
            
            //id do projeto
            idProjeto = projdao.retornaId(listaProj.get(atual).getNomeProjeto());
            
            //preenchendo a lista de conhecimentos
            listaConhecimentos = phcdao.retornaConhecimentoPeloIdProjeto(idProjeto);
            
            //mostrando os conhecimentos
            for(int i=0; i<listaConhecimentos.size();i++){
                //Preenche Conhecimentos
                switch (listaConhecimentos.get(i).getId_conhecimento()) {
                    case 1:
                        jPHP.setSelected(true);
                        break;
                    case 2:
                        jHTML.setSelected(true);
                        break;
                    case 3:
                        jJava.setSelected(true);
                        break;
                    case 4:
                        jSwift.setSelected(true);
                        break;
                    case 5:
                        jPython.setSelected(true);
                        break;
                    case 6:
                        jJS.setSelected(true);
                        break;
                    case 7:
                        jComunicacao.setSelected(true);
                        break;
                    case 8:
                        jAG.setSelected(true);
                        break;
                    case 9:
                        jSolucoes.setSelected(true);
                        break;
                    case 10:
                        jCalculos.setSelected(true);
                        break;
                    case 11:
                        jGestao.setSelected(true);
                        break;
                    case 12:
                        jRedes.setSelected(true);
                        break;
                    default:
                        break;
                }
            }
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
        jNomePText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jGcbtn = new javax.swing.JRadioButton();
        jMktbtn = new javax.swing.JRadioButton();
        jDmbtn = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jEngbtn = new javax.swing.JRadioButton();
        jSoftbtn = new javax.swing.JRadioButton();
        jWebbtn = new javax.swing.JRadioButton();
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
        jNomeText = new javax.swing.JLabel();
        jPmaxText = new javax.swing.JTextField();
        jPminText = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPropBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDescricaoText = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jNumAtual = new javax.swing.JTextField();
        jProxBtn = new javax.swing.JButton();
        jAnteriorbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jNumProj = new javax.swing.JTextField();
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

        jNomePText.setEditable(false);
        jNomePText.setBackground(new java.awt.Color(51, 51, 51));
        jNomePText.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jNomePText.setForeground(new java.awt.Color(255, 255, 255));
        jNomePText.setBorder(null);
        jPanel2.add(jNomePText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 490, 20));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Número do Projeto:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, -1, -1));

        jGcbtn.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(jGcbtn);
        jGcbtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jGcbtn.setForeground(new java.awt.Color(153, 153, 153));
        jGcbtn.setText("GESTÃO E CONSULTORIA");
        jGcbtn.setEnabled(false);
        jGcbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGcbtnActionPerformed(evt);
            }
        });
        jPanel2.add(jGcbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        jMktbtn.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(jMktbtn);
        jMktbtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jMktbtn.setForeground(new java.awt.Color(153, 153, 153));
        jMktbtn.setText("MARKETING E VENDAS");
        jMktbtn.setEnabled(false);
        jMktbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMktbtnActionPerformed(evt);
            }
        });
        jPanel2.add(jMktbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        jDmbtn.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(jDmbtn);
        jDmbtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jDmbtn.setForeground(new java.awt.Color(153, 153, 153));
        jDmbtn.setText("DESIGN E MULTIMEDIA");
        jDmbtn.setEnabled(false);
        jDmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDmbtnActionPerformed(evt);
            }
        });
        jPanel2.add(jDmbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("CATEGORIA:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jEngbtn.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(jEngbtn);
        jEngbtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jEngbtn.setForeground(new java.awt.Color(153, 153, 153));
        jEngbtn.setText("ENGENHARIA E MANUFATURA");
        jEngbtn.setEnabled(false);
        jPanel2.add(jEngbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        jSoftbtn.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(jSoftbtn);
        jSoftbtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSoftbtn.setForeground(new java.awt.Color(153, 153, 153));
        jSoftbtn.setText("SOFTWARES E SISTEMAS");
        jSoftbtn.setEnabled(false);
        jPanel2.add(jSoftbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jWebbtn.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(jWebbtn);
        jWebbtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jWebbtn.setForeground(new java.awt.Color(153, 153, 153));
        jWebbtn.setText("WEBSITES E APPS");
        jWebbtn.setEnabled(false);
        jWebbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWebbtnActionPerformed(evt);
            }
        });
        jPanel2.add(jWebbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        jJava.setBackground(new java.awt.Color(51, 51, 51));
        jJava.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jJava.setForeground(new java.awt.Color(153, 153, 153));
        jJava.setText("JAVA");
        jJava.setEnabled(false);
        jPanel2.add(jJava, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        jRedes.setBackground(new java.awt.Color(51, 51, 51));
        jRedes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jRedes.setForeground(new java.awt.Color(153, 153, 153));
        jRedes.setText("REDES");
        jRedes.setEnabled(false);
        jPanel2.add(jRedes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, -1));

        jHTML.setBackground(new java.awt.Color(51, 51, 51));
        jHTML.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jHTML.setForeground(new java.awt.Color(153, 153, 153));
        jHTML.setText("HTML");
        jHTML.setEnabled(false);
        jPanel2.add(jHTML, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, -1));

        jSwift.setBackground(new java.awt.Color(51, 51, 51));
        jSwift.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSwift.setForeground(new java.awt.Color(153, 153, 153));
        jSwift.setText("SWIFT");
        jSwift.setEnabled(false);
        jPanel2.add(jSwift, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        jPython.setBackground(new java.awt.Color(51, 51, 51));
        jPython.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPython.setForeground(new java.awt.Color(153, 153, 153));
        jPython.setText("PYTHON");
        jPython.setEnabled(false);
        jPanel2.add(jPython, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        jJS.setBackground(new java.awt.Color(51, 51, 51));
        jJS.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jJS.setForeground(new java.awt.Color(153, 153, 153));
        jJS.setText("JAVASCRIPT");
        jJS.setEnabled(false);
        jPanel2.add(jJS, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));

        jPHP.setBackground(new java.awt.Color(51, 51, 51));
        jPHP.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPHP.setForeground(new java.awt.Color(153, 153, 153));
        jPHP.setText("PHP");
        jPHP.setEnabled(false);
        jPHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPHPActionPerformed(evt);
            }
        });
        jPanel2.add(jPHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        jComunicacao.setBackground(new java.awt.Color(51, 51, 51));
        jComunicacao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComunicacao.setForeground(new java.awt.Color(153, 153, 153));
        jComunicacao.setText("COMUNICAÇÃO");
        jComunicacao.setEnabled(false);
        jComunicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComunicacaoActionPerformed(evt);
            }
        });
        jPanel2.add(jComunicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        jAG.setBackground(new java.awt.Color(51, 51, 51));
        jAG.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jAG.setForeground(new java.awt.Color(153, 153, 153));
        jAG.setText("ARTES GRÁFICAS");
        jAG.setEnabled(false);
        jPanel2.add(jAG, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, -1, -1));

        jSolucoes.setBackground(new java.awt.Color(51, 51, 51));
        jSolucoes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jSolucoes.setForeground(new java.awt.Color(153, 153, 153));
        jSolucoes.setText("SOLUÇÕES");
        jSolucoes.setEnabled(false);
        jSolucoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSolucoesActionPerformed(evt);
            }
        });
        jPanel2.add(jSolucoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

        jCalculos.setBackground(new java.awt.Color(51, 51, 51));
        jCalculos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jCalculos.setForeground(new java.awt.Color(153, 153, 153));
        jCalculos.setText("CÁLCULOS");
        jCalculos.setEnabled(false);
        jPanel2.add(jCalculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        jGestao.setBackground(new java.awt.Color(51, 51, 51));
        jGestao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jGestao.setForeground(new java.awt.Color(153, 153, 153));
        jGestao.setText("GESTÃO");
        jGestao.setEnabled(false);
        jPanel2.add(jGestao, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, -1, -1));

        jNomeText.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jNomeText.setForeground(new java.awt.Color(153, 153, 153));
        jNomeText.setText("NOME:");
        jPanel2.add(jNomeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jPmaxText.setEditable(false);
        jPmaxText.setBackground(new java.awt.Color(51, 51, 51));
        jPmaxText.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPmaxText.setForeground(new java.awt.Color(255, 255, 255));
        jPmaxText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPmaxText.setText("0.00");
        jPmaxText.setBorder(null);
        jPanel2.add(jPmaxText, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 80, 20));

        jPminText.setEditable(false);
        jPminText.setBackground(new java.awt.Color(51, 51, 51));
        jPminText.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPminText.setForeground(new java.awt.Color(255, 255, 255));
        jPminText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPminText.setText("0.00");
        jPminText.setToolTipText("");
        jPminText.setBorder(null);
        jPanel2.add(jPminText, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 70, 80, 20));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 80, -1));

        jSeparator3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, 80, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("R$");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, -1, 20));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("R$");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, -1, 20));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("MAX");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("MIN");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 70, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("ORÇAMENTO:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        jPropBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        jPropBtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jPropBtn.setForeground(new java.awt.Color(153, 153, 153));
        jPropBtn.setText("REALIZAR PROPOSTA");
        jPropBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPropBtnActionPerformed(evt);
            }
        });
        jPanel2.add(jPropBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 300, 50));

        jScrollPane2.setBorder(null);

        jDescricaoText.setEditable(false);
        jDescricaoText.setBackground(new java.awt.Color(51, 51, 51));
        jDescricaoText.setColumns(20);
        jDescricaoText.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jDescricaoText.setForeground(new java.awt.Color(255, 255, 255));
        jDescricaoText.setRows(5);
        jDescricaoText.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DESCRIÇÃO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 18), new java.awt.Color(153, 153, 153))); // NOI18N
        jScrollPane2.setViewportView(jDescricaoText);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 300, 200));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("HABILIDADE:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jNumAtual.setEditable(false);
        jNumAtual.setBackground(new java.awt.Color(51, 51, 51));
        jNumAtual.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jNumAtual.setForeground(new java.awt.Color(153, 153, 153));
        jNumAtual.setBorder(null);
        jPanel2.add(jNumAtual, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 30, 20));

        jProxBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        jProxBtn.setForeground(new java.awt.Color(153, 153, 153));
        jProxBtn.setText("PRÓXIMO");
        jProxBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProxBtnActionPerformed(evt);
            }
        });
        jPanel2.add(jProxBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, 140, 40));

        jAnteriorbtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        jAnteriorbtn.setForeground(new java.awt.Color(153, 153, 153));
        jAnteriorbtn.setText("ANTERIOR");
        jAnteriorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAnteriorbtnActionPerformed(evt);
            }
        });
        jPanel2.add(jAnteriorbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 140, 40));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Número de Projetos:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        jNumProj.setEditable(false);
        jNumProj.setBackground(new java.awt.Color(51, 51, 51));
        jNumProj.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jNumProj.setForeground(new java.awt.Color(153, 153, 153));
        jNumProj.setBorder(null);
        jPanel2.add(jNumProj, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 30, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1070, 540));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Projeto");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jTextField1.setPreferredSize(new java.awt.Dimension(1082, 186));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1090, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/criar_projetos.png"))); // NOI18N
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

    private void jGcbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGcbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jGcbtnActionPerformed

    private void jDmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDmbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDmbtnActionPerformed

    private void jMktbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMktbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMktbtnActionPerformed

    private void jWebbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWebbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jWebbtnActionPerformed

    private void jPHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPHPActionPerformed

    private void jComunicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComunicacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComunicacaoActionPerformed

    private void jSolucoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSolucoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSolucoesActionPerformed

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

    private void jPropBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPropBtnActionPerformed
        //id cliente
        int idCliente = projdao.retornaIdClientePeloIdProjeto(idProjeto);
        
        //verifica se o freelancer não é o cliente do projeto
        if(idCliente != usuarioId)
        {
            TelaProposta proposta1 = new TelaProposta(usuarioId,idProjeto);
            System.out.println("este é o projeto:"+idProjeto);
            proposta1.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Não pode realizar proposta no próprio projeto!!");
        }
    }//GEN-LAST:event_jPropBtnActionPerformed

    private void jProxBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProxBtnActionPerformed
        if(tam.equals(Integer.toString(atual+1)) && !listaProj.isEmpty()){
            //seta o contador
            atual = 0;
            
            //reseta os conhecimentos
            jPHP.setSelected(false);
            jHTML.setSelected(false);
            jJava.setSelected(false);
            jSwift.setSelected(false);
            jPython.setSelected(false);
            jJS.setSelected(false);
            jComunicacao.setSelected(false);
            jAG.setSelected(false);
            jSolucoes.setSelected(false);
            jCalculos.setSelected(false);
            jGestao.setSelected(false);
            jRedes.setSelected(false);
            
            //mostra na interface
            jNumProj.setText(tam);
            jNomePText.setText(listaProj.get(atual).getNomeProjeto());
            jPminText.setText(Float.toString(listaProj.get(atual).getPrecoMin()));
            jPmaxText.setText(Float.toString(listaProj.get(atual).getPrecoMax()));
            jDescricaoText.setText(listaProj.get(atual).getDescricaoProjeto());
            jNumAtual.setText(Integer.toString(atual+1));  
            
            //ArrayList de ProjetoHasConhecimentos
            List<ProjetoHasConhecimento> listaConhecimentos;
            
            //criando o objeto ProjetoHasConhecimento
            ProjetoHasConhecimentoDAO phcdao = new ProjetoHasConhecimentoDAO();
            
            //id do projeto
            idProjeto = projdao.retornaId(listaProj.get(atual).getNomeProjeto());
            
            //preenchendo a lista de conhecimentos
            listaConhecimentos = phcdao.retornaConhecimentoPeloIdProjeto(idProjeto);
            
            //mostrando os conhecimentos
            for(int i=0; i<listaConhecimentos.size();i++){
                //Preenche Conhecimentos
                if(listaConhecimentos.get(i).getId_conhecimento()==1)
                    jPHP.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==2)
                    jHTML.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==3)
                    jJava.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==4)
                    jSwift.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==5)
                    jPython.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==6)
                    jJS.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==7)
                    jComunicacao.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==8)
                    jAG.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==9)
                    jSolucoes.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==10)
                    jCalculos.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==11)
                    jGestao.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==12)
                    jRedes.setSelected(true);
            }
            
        }else if(!listaProj.isEmpty()){
            //soma o contador
            atual++;
            
            //reseta os conhecimentos
            jPHP.setSelected(false);
            jHTML.setSelected(false);
            jJava.setSelected(false);
            jSwift.setSelected(false);
            jPython.setSelected(false);
            jJS.setSelected(false);
            jComunicacao.setSelected(false);
            jAG.setSelected(false);
            jSolucoes.setSelected(false);
            jCalculos.setSelected(false);
            jGestao.setSelected(false);
            jRedes.setSelected(false);
            
            //mostra na interface
            jNumProj.setText(tam);
            jNomePText.setText(listaProj.get(atual).getNomeProjeto());
            jPminText.setText(Float.toString(listaProj.get(atual).getPrecoMin()));
            jPmaxText.setText(Float.toString(listaProj.get(atual).getPrecoMax()));
            jDescricaoText.setText(listaProj.get(atual).getDescricaoProjeto());
            jNumAtual.setText(Integer.toString(atual+1));  
            
            //ArrayList de ProjetoHasConhecimentos
            List<ProjetoHasConhecimento> listaConhecimentos;
            
            //criando o objeto ProjetoHasConhecimento
            ProjetoHasConhecimentoDAO phcdao = new ProjetoHasConhecimentoDAO();
            
            //id do projeto
            idProjeto = projdao.retornaId(listaProj.get(atual).getNomeProjeto());
            
            //preenchendo a lista de conhecimentos
            listaConhecimentos = phcdao.retornaConhecimentoPeloIdProjeto(idProjeto);
            
            //mostrando os conhecimentos
            for(int i=0; i<listaConhecimentos.size();i++){
                //Preenche Conhecimentos
                if(listaConhecimentos.get(i).getId_conhecimento()==1)
                    jPHP.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==2)
                    jHTML.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==3)
                    jJava.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==4)
                    jSwift.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==5)
                    jPython.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==6)
                    jJS.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==7)
                    jComunicacao.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==8)
                    jAG.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==9)
                    jSolucoes.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==10)
                    jCalculos.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==11)
                    jGestao.setSelected(true);
                else if(listaConhecimentos.get(i).getId_conhecimento()==12)
                    jRedes.setSelected(true);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Ainda não há projetos cadastrados!");
        }
    }//GEN-LAST:event_jProxBtnActionPerformed

    private void jAnteriorbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAnteriorbtnActionPerformed
        if(atual==0 && !listaProj.isEmpty()){
            //seta o contador
            atual = Integer.parseInt(tam)-1;
            
            //reseta os conhecimentos
            jPHP.setSelected(false);
            jHTML.setSelected(false);
            jJava.setSelected(false);
            jSwift.setSelected(false);
            jPython.setSelected(false);
            jJS.setSelected(false);
            jComunicacao.setSelected(false);
            jAG.setSelected(false);
            jSolucoes.setSelected(false);
            jCalculos.setSelected(false);
            jGestao.setSelected(false);
            jRedes.setSelected(false);
            
            //mostra na interface
            jNumProj.setText(tam);
            jNomePText.setText(listaProj.get(atual).getNomeProjeto());
            jPminText.setText(Float.toString(listaProj.get(atual).getPrecoMin()));
            jPmaxText.setText(Float.toString(listaProj.get(atual).getPrecoMax()));
            jDescricaoText.setText(listaProj.get(atual).getDescricaoProjeto());
            jNumAtual.setText(Integer.toString(atual+1));  
            
            //ArrayList de ProjetoHasConhecimentos
            List<ProjetoHasConhecimento> listaConhecimentos;
            
            //criando o objeto ProjetoHasConhecimento
            ProjetoHasConhecimentoDAO phcdao = new ProjetoHasConhecimentoDAO();
            
            //id do projeto
            idProjeto = projdao.retornaId(listaProj.get(atual).getNomeProjeto());
            
            //preenchendo a lista de conhecimentos
            listaConhecimentos = phcdao.retornaConhecimentoPeloIdProjeto(idProjeto);
            
            //mostrando os conhecimentos
            for(int i=0; i<listaConhecimentos.size();i++){
                //Preenche Conhecimentos
                switch (listaConhecimentos.get(i).getId_conhecimento()) {
                    case 1:
                        jPHP.setSelected(true);
                        break;
                    case 2:
                        jHTML.setSelected(true);
                        break;
                    case 3:
                        jJava.setSelected(true);
                        break;
                    case 4:
                        jSwift.setSelected(true);
                        break;
                    case 5:
                        jPython.setSelected(true);
                        break;
                    case 6:
                        jJS.setSelected(true);
                        break;
                    case 7:
                        jComunicacao.setSelected(true);
                        break;
                    case 8:
                        jAG.setSelected(true);
                        break;
                    case 9:
                        jSolucoes.setSelected(true);
                        break;
                    case 10:
                        jCalculos.setSelected(true);
                        break;
                    case 11:
                        jGestao.setSelected(true);
                        break;
                    case 12:
                        jRedes.setSelected(true);
                        break;
                    default:
                        break;
                }
            }
            
        }else if(!listaProj.isEmpty()){
            //soma o contador
            atual--;
            
            //reseta os conhecimentos
            jPHP.setSelected(false);
            jHTML.setSelected(false);
            jJava.setSelected(false);
            jSwift.setSelected(false);
            jPython.setSelected(false);
            jJS.setSelected(false);
            jComunicacao.setSelected(false);
            jAG.setSelected(false);
            jSolucoes.setSelected(false);
            jCalculos.setSelected(false);
            jGestao.setSelected(false);
            jRedes.setSelected(false);
            
            //mostra na interface
            jNumProj.setText(tam);
            jNomePText.setText(listaProj.get(atual).getNomeProjeto());
            jPminText.setText(Float.toString(listaProj.get(atual).getPrecoMin()));
            jPmaxText.setText(Float.toString(listaProj.get(atual).getPrecoMax()));
            jDescricaoText.setText(listaProj.get(atual).getDescricaoProjeto());
            jNumAtual.setText(Integer.toString(atual+1));  
            
            //ArrayList de ProjetoHasConhecimentos
            List<ProjetoHasConhecimento> listaConhecimentos;
            
            //criando o objeto ProjetoHasConhecimento
            ProjetoHasConhecimentoDAO phcdao = new ProjetoHasConhecimentoDAO();
            
            //seta o id do projeto
            idProjeto = projdao.retornaId(listaProj.get(atual).getNomeProjeto());
            
            //preenchendo a lista de conhecimentos
            listaConhecimentos = phcdao.retornaConhecimentoPeloIdProjeto(idProjeto);
            
            //mostrando os conhecimentos
            for(int i=0; i<listaConhecimentos.size();i++){
                //Preenche Conhecimentos
                switch (listaConhecimentos.get(i).getId_conhecimento()) {
                    case 1:
                        jPHP.setSelected(true);
                        break;
                    case 2:
                        jHTML.setSelected(true);
                        break;
                    case 3:
                        jJava.setSelected(true);
                        break;
                    case 4:
                        jSwift.setSelected(true);
                        break;
                    case 5:
                        jPython.setSelected(true);
                        break;
                    case 6:
                        jJS.setSelected(true);
                        break;
                    case 7:
                        jComunicacao.setSelected(true);
                        break;
                    case 8:
                        jAG.setSelected(true);
                        break;
                    case 9:
                        jSolucoes.setSelected(true);
                        break;
                    case 10:
                        jCalculos.setSelected(true);
                        break;
                    case 11:
                        jGestao.setSelected(true);
                        break;
                    case 12:
                        jRedes.setSelected(true);
                        break;
                    default:
                        break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ainda não há projetos cadastrados!");
        }
    }//GEN-LAST:event_jAnteriorbtnActionPerformed

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
            java.util.logging.Logger.getLogger(ProjetosBuscados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjetosBuscados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjetosBuscados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjetosBuscados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjetosBuscados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jAG;
    private javax.swing.JButton jAnteriorbtn;
    private javax.swing.JCheckBox jCalculos;
    private javax.swing.JCheckBox jComunicacao;
    private javax.swing.JTextArea jDescricaoText;
    private javax.swing.JRadioButton jDmbtn;
    private javax.swing.JRadioButton jEngbtn;
    private javax.swing.JRadioButton jGcbtn;
    private javax.swing.JCheckBox jGestao;
    private javax.swing.JCheckBox jHTML;
    private javax.swing.JCheckBox jJS;
    private javax.swing.JCheckBox jJava;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JRadioButton jMktbtn;
    private javax.swing.JTextField jNomePText;
    private javax.swing.JLabel jNomeText;
    private javax.swing.JTextField jNumAtual;
    private javax.swing.JTextField jNumProj;
    private javax.swing.JCheckBox jPHP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPmaxText;
    private javax.swing.JTextField jPminText;
    private javax.swing.JButton jPropBtn;
    private javax.swing.JButton jProxBtn;
    private javax.swing.JCheckBox jPython;
    private javax.swing.JCheckBox jRedes;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JRadioButton jSoftbtn;
    private javax.swing.JCheckBox jSolucoes;
    private javax.swing.JCheckBox jSwift;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton jWebbtn;
    // End of variables declaration//GEN-END:variables
}
