import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmissionsMoreData extends JFrame{
    PreparedStatement statement=null;
    ResultSet result=null;
    int selectedRow;
    DefaultTableModel Model;
    private JScrollPane scrollPaneAdmissionsMoreData;
    JTable tableAdmissionsMoreData;
    JButton btnBack;
    private JPanel admissionsMoreData;

    public AdmissionsMoreData(int selectedRow, DefaultTableModel Model) {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(admissionsMoreData);
    this.setSize(1100,150);
    this.setLocationRelativeTo(null);
    tableAdmissionsMoreData.setDefaultEditor(Object.class, null);
    tableAdmissionsMoreData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    tableAdmissionsMoreData.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    this.selectedRow=selectedRow;
    this.Model=Model;

    showData(selectedRow,Model);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }



    public void showData(int selectedRow,DefaultTableModel Model){
            DefaultTableModel tempModel = Model;
            System.out.println(selectedRow);
            try {
                String sql = "SELECT przyjecie.IDprzyjecia, przyjecie.PeselPacjenta, diagnozy.NazwaPrzypadlosci, diagnozy.OpisPrzypadlosci,lekarze.IDlekarza, lekarze.Imie, lekarze.Nazwisko, przyjecie.DataPrzyjecia, przyjecie.GodzinaPrzyjecia FROM przyjecie INNER JOIN diagnozy ON przyjecie.IDdiagnozy=diagnozy.IDdiagnoza JOIN lekarze ON przyjecie.IDLekarzProwadzacy=lekarze.IDlekarza WHERE diagnozy.IDdiagnoza=" + tempModel.getValueAt(selectedRow, 0).toString() + ";";
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

                tableAdmissionsMoreData.setModel(tableModel);
                statement.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

    }
}
