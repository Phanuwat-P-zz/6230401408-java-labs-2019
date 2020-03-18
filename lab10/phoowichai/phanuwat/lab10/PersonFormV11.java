/**
 * 
 * Implement the program called PersonFormV11
 * which extends from PersonFormV10 in lab 8
 * 
 * Author: Phanuwat Phoowichai
 * ID: 623040140-8
 * Sec: 2
 * Date: March 8, 2020
 * 
 **/

 package phoowichai.phanuwat.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

import phoowichai.phanuwat.lab8.PersonFormV10;

public class PersonFormV11 extends PersonFormV10 {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JMenuItem customMI;
    JColorChooser colorChooser;
    JFileChooser fileChooser;

    public PersonFormV11(String msg) {
        super(msg);
    }

    public void addMenus() {
        super.addMenus();

        // new menu item and add this to menu
        customMI = new JMenuItem("Custom");
        colorMenu.add(customMI);
    }

    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);

        Object srcObj = event.getSource();

        if (srcObj == customMI) { // user selete "Custom" (MenuItem)
            Color color = JColorChooser.showDialog(this, "Choose color", Color.BLACK);
            changeTextColor(color); // set text color
        } else if (srcObj == openMI) {  // user selete "Open" (MenuItem)
            int returnVal = fileChooser.showOpenDialog(PersonFormV11.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) { // user selete "OK"
                File file = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(null, "Opening file " + file.getName(), "Message",
                        JOptionPane.INFORMATION_MESSAGE, javaIcon);
            } else { // user selete "Cancel"
                JOptionPane.showMessageDialog(null, "Open command cancelled by user.", "Message",
                        JOptionPane.INFORMATION_MESSAGE, javaIcon);
            }
        } else if (srcObj == saveMI) { // user selete "Save" (MenuItem)
            int returnVal = fileChooser.showOpenDialog(PersonFormV11.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {  // user selete "OK"
                File file = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(null, "Saving file " + file.getName(), "Message",
                        JOptionPane.INFORMATION_MESSAGE, javaIcon);
            } else { // user selete "Cancel"
                JOptionPane.showMessageDialog(null, "Save command cancelled by user.", "Message",
                        JOptionPane.INFORMATION_MESSAGE, javaIcon);
            }
        } else if (srcObj == exitMI) {  // user selete "Exit" (MenuItem)
            System.exit(0); // exit program
        }
    }

    public void addListeners() {
        super.addListeners();

        // add action listener to object
        customMI.addActionListener(this);
        openMI.addActionListener(this);
        saveMI.addActionListener(this);
        exitMI.addActionListener(this);
    }

    public void addComponents() {
        super.addComponents();

        // set new JColorChooser and JFileChooser
        colorChooser = new JColorChooser();
        fileChooser = new JFileChooser();
    }

    public static void createAndShowGUI() {
        PersonFormV11 personFormV11 = new PersonFormV11("Person Form V11");
        personFormV11.addComponents();
        personFormV11.initComponents();
        personFormV11.addMenus();
        personFormV11.addListeners();
        personFormV11.addKeys();
        personFormV11.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}