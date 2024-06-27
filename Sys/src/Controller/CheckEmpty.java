package Controller;

import java.awt.Toolkit;
import java.util.Optional;
import java.util.function.Consumer;
import javax.swing.JOptionPane;

public class CheckEmpty {

    public Optional<String> isEmptyString(final String value) {
        return Optional.ofNullable(value);
    }

    public Optional<Integer> isEmptyInt(final int value) {
        return Optional.ofNullable(value);
    }

    public Optional<Object> isEmpty(final Object value) {
        return Optional.ofNullable(value);
    }

    public String convertString(final Object value) {
        return String.valueOf(value);
    }

    public Runnable sentMessage(final String component) {
        JOptionPane.showConfirmDialog(null, "The  " + component + "is Empty");
        return null;
    }

    public Consumer doneNone() {
        return null;
    }
    
    public boolean meetConLen(final int min, final String num) {
        if (num.length() == min) {
            return true;
        } else {
            Toolkit.getDefaultToolkit().beep();
            return false;
        }
    }

    public boolean meetConNum(final int min, final int num) {
        if (num == min) {
            return true;
        } else {
            Toolkit.getDefaultToolkit().beep();
            return false;
        }
    }
}
