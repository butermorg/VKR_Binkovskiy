package validation;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Fields {
    public String integer_valid (String i){
       try {
          return String.valueOf(Integer.parseInt(i));
       } catch (NumberFormatException e) {
           return null;
       }

    }

    public boolean double_valid (JTextField f, KeyEvent e){
        char c = e.getKeyChar();
        if (f.getText().isEmpty() && (c == KeyEvent.VK_PERIOD)) {
            return true;
        }
        if (f.getText().indexOf('.') != -1 && (c == KeyEvent.VK_PERIOD)) {
            return true;
        }
        if (!((c >= '0') && (c <= '9') ||
                (c == KeyEvent.VK_BACK_SPACE) ||
                (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD))) {
            return true;
        }
        return false;
    }


}
