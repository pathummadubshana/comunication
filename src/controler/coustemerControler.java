package controler;

import DB.dbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class coustemerControler {
    public TextField txtCoustemer;
    public TextField txtcopy;
    public TextField txtOneprice;
    public TextField txtTotal;
    public Button btncal;
    public Button btnsave;
    public Button btnCid;
    public Label lblId;

    public  void  calcuLation(){





    }
    public void initialize(){
        setDisable(true);

    }

    public void btnCalOnAction(ActionEvent actionEvent) {
        String n= txtcopy.getText();
        String x = txtOneprice.getText();

        int a= Integer.parseInt(n)*Integer.parseInt(x);

        String tot= String.valueOf(a);

        txtTotal.setText(tot);
    }

    public void btnSaveOnaction(ActionEvent actionEvent) {
    }

    public void setDisable(boolean isDisable){
        txtCoustemer.setDisable(isDisable);
        txtcopy.setDisable(isDisable);
        txtOneprice.setDisable(isDisable);
        txtTotal.setDisable(isDisable);
        btncal.setDisable(isDisable);
        btnsave.setDisable(isDisable);

    }
    public void setVisibale(boolean visible){
        txtCoustemer.setDisable(visible);
        txtcopy.setDisable(visible);
        txtOneprice.setDisable(visible);
        txtTotal.setDisable(visible);
        btncal.setDisable(visible);
        btnsave.setDisable(visible);

    }

    public void btncidOnAction(ActionEvent actionEvent) {
        setVisibale(false);
         autoId();

    }
    public void  autoId(){
      Connection connection  =dbConnection.getInstance().getConnection();

        try {
            Statement statement =connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select cid from custemer order by cid desc limit 1");

            boolean isExit = resultSet.next();

            if(isExit){
                String uid = resultSet.getString(1);
                uid=uid.substring(1,uid.length());

                int intId = Integer.parseInt(uid);
                intId++;

                if(intId<10){
                    lblId.setText("C00"+intId);
                }else if(intId<100){
                    lblId.setText("C0"+intId);
                }else {
                    lblId.setText("C"+intId);
                }



            } else{
                lblId.setText("C001");


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
