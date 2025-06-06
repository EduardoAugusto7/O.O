/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import Classes.GerenciadorDePessoas;
import Classes.Pessoa;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class FrCadPessoa extends javax.swing.JFrame {
    private String nomeAntigo;
    private boolean editando;
    private GerenciadorDePessoas gerente;
    public FrCadPessoa() {
        initComponents();
        
        this.editando = false;
        this.nomeAntigo = " ";
        this.gerente = new GerenciadorDePessoas();
        this.HabilitarCampos(false);
        this.LimparCampos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        LblCadPessoas = new javax.swing.JLabel();
        PanBotoes = new javax.swing.JPanel();
        BtnNovo = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnCanecelar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        BtnSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        LblNome = new javax.swing.JLabel();
        LblCPF = new javax.swing.JLabel();
        LblIdade = new javax.swing.JLabel();
        LblSexo = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        edtCPF = new javax.swing.JTextField();
        edtIdade = new javax.swing.JTextField();
        edtSexo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtListagem = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LblCadPessoas.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        LblCadPessoas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblCadPessoas.setText("Cadastro De Pessoas");

        BtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/novo_32x32.png"))); // NOI18N
        BtnNovo.setText("Novo");
        BtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNovoActionPerformed(evt);
            }
        });
        PanBotoes.add(BtnNovo);

        BtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit3_32x32.png"))); // NOI18N
        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });
        PanBotoes.add(BtnEditar);

        BtnCanecelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel_32x32.png"))); // NOI18N
        BtnCanecelar.setText("Cancelar");
        BtnCanecelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCanecelarActionPerformed(evt);
            }
        });
        PanBotoes.add(BtnCanecelar);

        BtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/del_32x32.png"))); // NOI18N
        BtnExcluir.setText("Excluir");
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });
        PanBotoes.add(BtnExcluir);

        BtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save_32x32.png"))); // NOI18N
        BtnSalvar.setText("Salvar");
        BtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalvarActionPerformed(evt);
            }
        });
        PanBotoes.add(BtnSalvar);

        LblNome.setText("Nome :");

        LblCPF.setText("CPF :");

        LblIdade.setText("Idade :");

        LblSexo.setText("Sexo :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(LblIdade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                .addComponent(LblCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(LblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNome, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(edtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblIdade, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblSexo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(edtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        edtListagem.setColumns(20);
        edtListagem.setRows(5);
        jScrollPane1.setViewportView(edtListagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(LblCadPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 89, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblCadPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNovoActionPerformed
        this.HabilitarCampos(true);
        this.LimparCampos();
        this.editando = false;
    }//GEN-LAST:event_BtnNovoActionPerformed

    private void BtnCanecelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCanecelarActionPerformed
        this.LimparCampos();
        this.HabilitarCampos(false);
        this.editando = false;
    }//GEN-LAST:event_BtnCanecelarActionPerformed

    public Pessoa camposParaObjeto(){
        Pessoa p = new Pessoa();
        p.setNome(edtNome.getText());
        p.setSexo(edtSexo.getText());
        p.setCpf(edtCPF.getText());
        p.setIdade(edtIdade.getText());
    return p;   
}
    
    private void BtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarActionPerformed

        Pessoa novaPessoa = this.camposParaObjeto();
    if(this.editando == true)
         this.gerente.atualizarPessoas(this.nomeAntigo, novaPessoa);
     else     
     this.gerente.adicionar(novaPessoa);
     this.LimparCampos();
     this.HabilitarCampos(false);
     this.editando = false;
     
     String Listagem = gerente.toString();
     edtListagem.setText(Listagem);
    }//GEN-LAST:event_BtnSalvarActionPerformed

    public void objetoParaCampos(Pessoa pessoa){
        edtNome.setText(pessoa.getNome());
        edtIdade.setText(pessoa.getIdade());
        edtCPF.setText(pessoa.getCpf());
        edtSexo.setText(pessoa.getSexo());
    }
    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
      
      this.nomeAntigo = JOptionPane.showInputDialog("informe o nome da pessoa.");
      Pessoa pessoaEditando = this.gerente.buscarPessoas(nomeAntigo);
      
      if(pessoaEditando != null){
          this.editando = true;
          this.LimparCampos();
          this.HabilitarCampos(true);
          this.objetoParaCampos(pessoaEditando);
          
      }else{
          System.out.println("pessoa inexistente.");
          JOptionPane.showMessageDialog(this, "pessoa inexistente");
      }
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
         this.nomeAntigo = JOptionPane.showInputDialog("informe o nome da pessoa.");
         
         Pessoa pessoa = this.gerente.buscarPessoas(nomeAntigo);
         if(pessoa == null){
               JOptionPane.showMessageDialog(this, "pessoa inexistente");
         }else{
             this.gerente.remover(nomeAntigo);
               JOptionPane.showMessageDialog(this, "Exclusao feita com sucesso!");
         }
         String Listagem = this.gerente.toString();
         edtListagem.setText(Listagem);
    }//GEN-LAST:event_BtnExcluirActionPerformed

    
    public void HabilitarCampos(boolean flag){
        edtNome.setEnabled(flag);
        edtSexo.setEnabled(flag);
        edtCPF.setEnabled(flag);
        edtIdade.setEnabled(flag);
    }
    
    public void LimparCampos(){
    edtNome.setText( " ");
    edtSexo.setText(" ");
    edtCPF.setText(" ");
    edtIdade.setText(" ");
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCanecelar;
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnNovo;
    private javax.swing.JButton BtnSalvar;
    private javax.swing.JLabel LblCPF;
    private javax.swing.JLabel LblCadPessoas;
    private javax.swing.JLabel LblIdade;
    private javax.swing.JLabel LblNome;
    private javax.swing.JLabel LblSexo;
    private javax.swing.JPanel PanBotoes;
    private javax.swing.JTextField edtCPF;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextArea edtListagem;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
