import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PlaceholderTextField extends JTextField {
    private String placeholder;
    private boolean placeholderActive = true;
    private Color placeholderForeground = UIManager.getColor("TextField.inactiveForeground");
    private Color foreground = getForeground();

    public PlaceholderTextField(String placeholder) {
        this();
        this.placeholder = placeholder;
        setTextSuper(placeholder);
    }

    public PlaceholderTextField() {
        this.placeholder = "";
        addLiteners();
        setForeground(placeholderForeground);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        focusLost();
    }

    private void addLiteners () {
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if(placeholderActive) {
                    setForeground(foreground);
                    setTextSuper("");
                    placeholderActive = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(getText().isEmpty()){
                    placeholderActive = true;
                    setTextSuper(placeholder);
                    setForeground(placeholderForeground);
                }
            }
        });
    }

    private void setTextSuper(String text) {
        super.setText(text);
    }

    @Override
    public void setText(String t) {
        super.setText(t);
        focusLost();
    }

    @Override
    public String getText() {
        if(placeholderActive)
            return "";
        return super.getText();
    }

    private void focusLost() {
        if(getText().isEmpty()){
            placeholderActive = true;
            setTextSuper(placeholder);
            setForeground(placeholderForeground);
        }
    }
}