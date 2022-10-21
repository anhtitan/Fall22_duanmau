/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Duanmau.Utilies;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author AnhTiTan
 */
public class Helper {

    public boolean checkNull(JTextField field, String name) {
        if (field.getText().isEmpty()) {
            errorNull(null, name);
            return true;
        } else {
            return false;
        }
    }

    public void alert(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Thông báo", 1);
    }

    public void error(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Thông báo", 0);
    }

    public void errorNull(Component component, String name) {
        JOptionPane.showMessageDialog(component, name + " không được để trống!", "Thông báo", 0);
    }

    public boolean confirm(Component component, String message) {
        int choice = JOptionPane.showConfirmDialog(component, message, "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

}
