import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DoctorsPanel extends JFrame{
    private JButton btnBack;
    private JPanel doctorsPanel;
    private JTable tableDoctors;
    private JScrollPane scrollPaneDoctors;
    private JButton button1;
    private JButton button2;


    public DoctorsPanel() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(doctorsPanel);
        //this.pack();
        this.setLocationRelativeTo(null);

        showDoctor();

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame MainMenuPanel = new MainMenuPanel(CorrectLoginData.getCorrectLogin());
                MainMenuPanel.setVisible(true);
                dispose();
            }
        });
    }

    public ArrayList<DoctorsDataTable> doctorsTable() {

        ArrayList<DoctorsDataTable>doctorsTable=new ArrayList<>();

        String query="SELECT * FROM lekarze";

        try {

            Statement statement=DBConnection.dbConnection.createStatement();
            ResultSet result=statement.executeQuery(query);
            DoctorsDataTable doctor;

            while (result.next()){

                doctor=new DoctorsDataTable(result.getInt("IDlekarza"),result.getString("Imie"),result.getString("Nazwisko"),result.getDate("DataUrodzenia"),result.getString("MiejsceUrodzenia"),result.getString("Pesel"),result.getString("AdresZamieszkania"),result.getString("KodPocztowy"),result.getString("Miasto"),result.getString("Telefon"),result.getString("Email"),result.getInt("Wynagrodzenie"));

                doctorsTable.add(doctor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return doctorsTable;
    }

    public void showDoctor(){

        ArrayList<DoctorsDataTable> list=doctorsTable();
        DefaultTableModel model=(DefaultTableModel) tableDoctors.getModel();

        Object[]row = new Object[12];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getIdDoctor();
            row[1]=list.get(i).getFirstName();
            row[2]=list.get(i).getSurname();
            row[3]=list.get(i).getBirthDate();
            row[4]=list.get(i).getBirthPlace();
            row[5]=list.get(i).getPesel();
            row[6]=list.get(i).getAdress();
            row[7]=list.get(i).getPostcode();
            row[8]=list.get(i).getCity();
            row[9]=list.get(i).getPhoneNumber();
            row[10]=list.get(i).getEmail();
            row[11]=list.get(i).getSalary();
            model.addRow(row);
        }

    }




}
