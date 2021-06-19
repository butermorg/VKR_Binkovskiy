package validation;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * The type Fields.
 */
public class Fields {
    /**
     * Integer valid boolean.
     *
     * @param e the e
     * @return the boolean
     */
    public boolean integer_valid (KeyEvent e){
        char c = e.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
                (c == KeyEvent.VK_BACK_SPACE) ||
                (c == KeyEvent.VK_DELETE))) {
            return true;
        }
            return false;
    }

    /**
     * Double valid boolean.
     *
     * @param f the f
     * @param e the e
     * @return the boolean
     */
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
