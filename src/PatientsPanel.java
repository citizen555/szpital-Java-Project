import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientsPanel extends JFrame{
    PreparedStatement statement=null;
    ResultSet result=null;
    private JPanel patientsPanel;
    private JScrollPane scrollPanePatients;
    private JTable tablePatients;
    private JLabel lName;
    JTextField tfName;
    JTextField tfBirthDate;
    private JLabel lBirthDate;
    private JLabel lPesel;
    JTextField tfPesel;
    JTextField tfPostCode;
    private JLabel lTelephone;
    JTextField tfTelephone;
    private JLabel lSurname;
    JTextField tfSurname;
    private JLabel lBirthPlace;
    JTextField tfBirthPlace;
    private JLabel lLivePlace;
    JTextField tfAdres;
    private JLabel lCity;
    JTextField tfCity;
    private JLabel lEmail;
    JTextField tfEmail;
    private JButton btnDelete;
    private JButton btnAdd;
    JButton btnClear;
    JButton btnBack;

    public PatientsPanel(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(patientsPanel);
        this.setResizable(false);
        this.setSize(1400,700);
        this.setLocationRelativeTo(null);
        tablePatients.setDefaultEditor(Object.class, null);
        showData();
        tablePatients.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablePatients.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);




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
                tfName.setText("");
                tfSurname.setText("");
                tfBirthDate.setText("");
                tfBirthPlace.setText("");
                tfAdres.setText("");
                tfPostCode.setText("");
                tfCity.setText("");
                tfTelephone.setText("");
                tfEmail.setText("");
            }
        });
        tablePatients.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel tempModel =(DefaultTableModel) tablePatients.getModel();
                int selectedRow=tablePatients.getSelectedRow();
                tfPesel.setText(tempModel.getValueAt(selectedRow,0).toString());
                tfName.setText(tempModel.getValueAt(selectedRow,1).toString());
                tfSurname.setText(tempModel.getValueAt(selectedRow,2).toString());
                tfBirthDate.setText(tempModel.getValueAt(selectedRow,3).toString());
                tfBirthPlace.setText(tempModel.getValueAt(selectedRow,4).toString());
                tfAdres.setText(tempModel.getValueAt(selectedRow,5).toString());
                tfPostCode.setText(tempModel.getValueAt(selectedRow,6).toString());
                tfCity.setText(tempModel.getValueAt(selectedRow,7).toString());
                tfTelephone.setText(tempModel.getValueAt(selectedRow,8).toString());
                tfEmail.setText(tempModel.getValueAt(selectedRow,9).toString());
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tempModel=(DefaultTableModel) tablePatients.getModel();
                int selectedRow=tablePatients.getSelectedRow();

                if(selectedRow==-1){
                    JOptionPane.showMessageDialog(tablePatients,"Aby usun???? dane, wybierz wiersz z tabeli");
                }else{
                    try{
                        String sql="DELETE FROM `pacjenci` WHERE `Pesel` = "+tempModel.getValueAt(selectedRow,0).toString()+";";
                        statement = DBConnection.dbConnection.prepareStatement(sql);
                        statement.executeUpdate(sql);
                        showData();
                        JOptionPane.showMessageDialog(tablePatients,"Dane usuni??to poprawnie");
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

                if(!DataCorectness.pesel(tfPesel.getText())){
                    JOptionPane.showMessageDialog(patientsPanel, "Pesel musi zawiera?? 11 cyfr");
                    return;
                }
                if(!DataCorectness.name(tfName.getText())){
                    JOptionPane.showMessageDialog(patientsPanel, "Imie musi zawiera?? wy??acznie litery");
                    return;
                }
                if(!DataCorectness.name(tfSurname.getText())){
                    JOptionPane.showMessageDialog(patientsPanel, "Nazwisko musi zawiera?? wy??acznie litery");
                    return;
                }
                if(!DataCorectness.date(tfBirthDate.getText())){
                    JOptionPane.showMessageDialog(patientsPanel, "Data musi by?? w formacie rrrr-mm-dd");
                    return;
                }
                if(!DataCorectness.postCode(tfPostCode.getText())){
                    JOptionPane.showMessageDialog(patientsPanel, "Kod pocztowy musi by?? w formacie nn-nnn");
                    return;
                }
                if(!DataCorectness.email(tfEmail.getText())){
                    JOptionPane.showMessageDialog(patientsPanel, "Email musi zawiera?? @");
                    return;
                }
                if(!DataCorectness.telephone(tfTelephone.getText())){
                    JOptionPane.showMessageDialog(patientsPanel, "Numer telefonu musi zawiera?? 9 cyfr (bez numeru kierunkowego)");
                    return;
                }
                if(!DataCorectness.containsNumberAndChars(tfCity.getText())){
                    JOptionPane.showMessageDialog(patientsPanel, "Miasto nie moze zawiera?? cyfr lub znak??w specjalnych");
                    return;
                }


                try{
                    String sql="INSERT INTO  `pacjenci` (`Pesel`,`Imie`, `Nazwisko`, `DataUrodzenia`, `MiejsceUrodzenia`,`AdresZamieszkania`,`KodPocztowy`,`Miasto`,`Telefon`,`Email`) VALUES ('"+tfPesel.getText()+"','"+tfName.getText()+"','"+tfSurname.getText()+"','"+tfBirthDate.getText()+"','"+tfBirthPlace.getText()+"','"+tfAdres.getText()+"','"+tfPostCode.getText()+"','"+tfCity.getText()+"','"+tfTelephone.getText()+"','"+tfEmail.getText()+"');";
                    statement = DBConnection.dbConnection.prepareStatement(sql);
                    statement.executeUpdate(sql);
                    showData();
                    JOptionPane.showMessageDialog(tablePatients,"Dane dodano poprawnie");
                    statement.close();
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
    }


    public void showData(){
        try{

            String sql="SELECT * From pacjenci;";
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

            tablePatients.setModel(tableModel);
            statement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}