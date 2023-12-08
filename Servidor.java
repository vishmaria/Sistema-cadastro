package cadastro;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Servidor extends javax.swing.JFrame {

    public Servidor() {
        initComponents();
        this.preencheCombo();
    }

    ConectaBanco cb = new ConectaBanco();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomelabel = new javax.swing.JLabel();
        cpflabel = new javax.swing.JLabel();
        cargolabel = new javax.swing.JLabel();
        setorlabel = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        cargo = new javax.swing.JComboBox<>();
        setor = new javax.swing.JComboBox<>();
        CadastroServ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomelabel.setText("Nome");

        cpflabel.setText("CPF");

        cargolabel.setText("Cargo");

        setorlabel.setText("Setor");

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Professor", "Técnico", "Coordenador", "Diretor" }));

        setor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setorActionPerformed(evt);
            }
        });

        CadastroServ.setText("Cadastrar");
        CadastroServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroServActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomelabel)
                            .addComponent(cpflabel)
                            .addComponent(cargolabel)
                            .addComponent(setorlabel))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nome)
                            .addComponent(cpf)
                            .addComponent(cargo, 0, 140, Short.MAX_VALUE)
                            .addComponent(setor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(CadastroServ)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomelabel)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpflabel)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargolabel)
                    .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setorlabel)
                    .addComponent(setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(CadastroServ)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CadastroServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroServActionPerformed
        String sql = "select setor.id from setor where setor.nome like '" + setor.getSelectedItem().toString()+"'";
        ResultSet rs = cb.buscaDados(sql);
        
        try {
            while (rs.next()) {
                int id = (rs.getInt("id"));
                
                this.fazerCadastro(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
       
    }//GEN-LAST:event_CadastroServActionPerformed

    public void fazerCadastro(int id) {
        String nom = nome.getText();
        String cp = cpf.getText();
        String carg = cargo.getSelectedItem().toString();
        int identificador = id;
        
        String sql = "insert into servidor(nome,  cpf, cargo, idsetor) values('"+nom+"', '"+cp+"', '"+carg+"',"+identificador+")";
        cb.executaSql(sql);
        
    }

    public void preencheCombo() {
        String sql = "select nome from setor";
        ResultSet rs = cb.buscaDados(sql);
        try {
            while (rs.next()) {
                setor.addItem(rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setorActionPerformed
        
    }//GEN-LAST:event_setorActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastroServ;
    private javax.swing.JComboBox<String> cargo;
    private javax.swing.JLabel cargolabel;
    private javax.swing.JTextField cpf;
    private javax.swing.JLabel cpflabel;
    private javax.swing.JTextField nome;
    private javax.swing.JLabel nomelabel;
    private javax.swing.JComboBox<String> setor;
    private javax.swing.JLabel setorlabel;
    // End of variables declaration//GEN-END:variables


    private void fazerCadastro(JTextField nome, JTextField cpf, JComboBox<String> cargo, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
