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

        jLabel5 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(260, 152));

        jLabel5.setText("Path:");

        pathText.setBackground(new java.awt.Color(222, 222, 222));
        pathText.setEditable(false);
        pathText.setDisabledTextColor(new java.awt.Color(226, 210, 196));

        titleLabel.setText("Title:");

        jLabel3.setText("Main issue:");

        mainIssueTextArea.setColumns(20);
        mainIssueTextArea.setLineWrap(true);
        mainIssueTextArea.setRows(5);
        mainIssueTextArea.setWrapStyleWord(true);
        mainIssueTextArea.setMinimumSize(new java.awt.Dimension(0, 50));
        mainIssueTextArea.setPreferredSize(new java.awt.Dimension(260, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pathText, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(mainIssueTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(titleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainIssueTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    public final javax.swing.JTextArea mainIssueTextArea = new javax.swing.JTextArea();
    public final javax.swing.JTextField pathText = new javax.swing.JTextField();
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
