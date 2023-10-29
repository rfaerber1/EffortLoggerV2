package application;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
 
public class FXMLController {
    @FXML private Text clockStatus;
    
    @FXML protected void stopActivity(ActionEvent event) {
        clockStatus.setText("Clock Stopped");
    }
    
    @FXML protected void startActivity(ActionEvent event) {
        clockStatus.setText("Clock Started");
    }

}