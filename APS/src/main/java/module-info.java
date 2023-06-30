module br.unip.aps {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens br.unip.aps to javafx.fxml;
    exports br.unip.aps;
}