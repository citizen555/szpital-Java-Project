import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmissionsPanel extends JFrame{
    PreparedStatement statement=null;
    ResultSet result=null;
    private JPanel admissionsPanel;
    private JButton btnBack;
    private JScrollPane scrollPaneAdmissions;
    private JTable tableAdmissions;
    private JButton btnDelete;
    private JButton btnAdd;
    private JButton btnClear;
    private JTextField tfPesel;
    private JLabel lPesel;
    private JLabel ldiagnosis;
    private JLabel lDoctor;
    private JLabel lDate;
    private JLabel lHour;
    private JTextField tfDiagnosis;
    private JTextField tfDoctor;
    private JTextField tfDate;
    private JTextField tfHour;

    public AdmissionsPanel() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(admissionsPanel);
        this.setSize(800,850);
        this.setLocationRelativeTo(null);
        tableAdmissions.setDefaultEditor(Object.class, null);
        showData();
        tableAdmissions.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableAdmissions.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame MainMenuPanel = new MainMenuPanel(CorrectLoginData.getCorrectLogin());
                MainMenuPanel.setVisible(true);
                dispose();
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfPesel.setText("");
                tfDiagnosis.setText("");
                tfDoctor.setText("");
                tfDate.setText("");
                tfHour.setText("");
            }
        });
        tableAdmissions.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel tempModel =(DefaultTableModel) tableAdmissions.getModel();
                int selectedRow=tableAdmissions.getSelectedRow();
                tfPesel.setText(tempModel.getValueAt(selectedRow,1).toString());
                tfDiagnosis.setText(tempModel.getValueAt(selectedRow,2).toString());
                tfDoctor.setText(tempModel.getValueAt(selectedRow,3).toString());
                tfDate.setText(tempModel.getValueAt(selectedRow,4).toString());
                tfHour.setText(tempModel.getValueAt(selectedRow,5).toString());
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tempModel=(DefaultTableModel) tableAdmissions.getModel();
                int selectedRow=tableAdmissions.getSelectedRow();

                if(selectedRow==-1){
                    JOptionPane.showMessageDialog(tableAdmissions,"Aby usunąć dane, wybierz wiersz z tabeli");
                }else{
                    try{
                        String sql="DELETE FROM `przyjecie` WHERE `IDprzyjecia` = "+tempModel.getValueAt(selectedRow,0).toString()+";";
                        statement = DBConnection.dbConnection.prepareStatement(sql);
                        statement.executeUpdate(sql);
                        showData();
                        JOptionPane.showMessageDialog(tableAdmissions,"Dane usunięto poprawnie");
                        statement.close();
                    }catch (SQLException ex){
                        ex.printStackTrace();
                    }

                }
                showData();
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String sql="INSERT INTO  `przyjecie` (`PeselPacjenta`,`IDdiagnozy`, `IDLekarzProwadzacy`, `DataPrzyjecia`, `GodzinaPrzyjecia`) VALUES ('"+tfPesel.getText()+"','"+tfDiagnosis.getText()+"','"+tfDoctor.getText()+"','"+tfDate.getText()+"','"+tfHour.getText()+"');";
                    statement = DBConnection.dbConnection.prepareStatement(sql);
                    statement.executeUpdate(sql);
                    showData();
                    JOptionPane.showMessageDialog(tableAdmissions,"Dane dodano poprawnie");
                    statement.close();
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public void showData(){
        try{

            String sql="SELECT * From przyjecie;";
            statement = DBConnection.dbConnection.prepareStatement(sql);
            result = statement.executeQuery();

            int numberOfColumns = result.getMetaData().getColumnCount();
            DefaultTableModel tableModel = new DefaultTableModel();

            for (int i=1;i<=numberOfColumns;i++){
                tableModel.addColumn(result.getMetaData().getColumnName(i));
            }
            while(result.next()){
                Object[] row = new Object[numberOfColumns];
                for(int i=1;i<=numberOfColumns;i++){
                    row[i-1]=result.getObject(i);
                }
                tableModel.addRow(row);
            }

            tableAdmissions.setModel(tableModel);
            statement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
