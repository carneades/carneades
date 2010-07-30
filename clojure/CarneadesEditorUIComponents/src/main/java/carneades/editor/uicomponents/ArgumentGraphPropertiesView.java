/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ArgumentGraphPropertiesView.java
 *
 * Created on Jul 27, 2010, 11:18:10 AM
 */

package carneades.editor.uicomponents;

/**
 *
 * @author pal
 */
public class ArgumentGraphPropertiesView extends javax.swing.JPanel {

    /** Creates new form ArgumentGraphPropertiesView */
    public ArgumentGraphPropertiesView() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(260, 152));

        jLabel1.setText("Id:");

        titleLabel.setText("Title:");

        jLabel3.setText("Main issue:");

        mainIssueTextArea.setColumns(20);
        mainIssueTextArea.setRows(5);
        mainIssueTextArea.setMinimumSize(new java.awt.Dimension(0, 50));
        mainIssueTextArea.setPreferredSize(new java.awt.Dimension(260, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(titleLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(idText, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
                    .addComponent(jLabel3)
                    .addComponent(mainIssueTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel))
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainIssueTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public final javax.swing.JTextField idText = new javax.swing.JTextField();
    public final javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel3;
    public final javax.swing.JTextArea mainIssueTextArea = new javax.swing.JTextArea();
    private javax.swing.JLabel titleLabel;
    public final javax.swing.JTextField titleText = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables

    // our modifications:
    public static ArgumentGraphPropertiesView viewInstance = new ArgumentGraphPropertiesView();

    public static synchronized ArgumentGraphPropertiesView instance()
    {
        return viewInstance;
    }

    public static synchronized void reset()
    {
        viewInstance = new ArgumentGraphPropertiesView();
    }
}
