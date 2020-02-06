/**
 * 
 * Implement the program called PersonFormV5 which extends from PersonFormV4
 * In this program, you will set the font and color of components
 * such that the program output is as shown in Figure 14.
 * 
 * Author: Phanuwat Phoowichai
 * ID: 623040140-8 Sec: 2
 * Date: February 3, 2020
 * 
 **/

package phoowichai.phanuwat.lab6;

import java.awt.*;
import javax.swing.*;

public class PersonFormV5 extends PersonFormV4 {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PersonFormV5(String msg) {
        super(msg);
    }

    protected void initComponents() {
        // super.initComponents();
        setFonts();
        setColors();
        setValues();
    }

    private void setValues() {
        // set values
        tfName.setText("Manee");
        tfHeight.setText("160");
        tfWeight.setText("55");
        tfDoB.setText("02-02-2000");
        radioStd.setSelected(true);
        sportBox.setSelectedItem("Swimming");
        hobbiesList.setSelectedIndices(new int[] { 0, 3 });
    }

    private void setColors() {
        // set foreground color of button
        cancelButton.setForeground(Color.RED);
        okButton.setForeground(Color.BLUE);
    }

    private void setFonts() {
        // set font of label
        labelName.setFont(new Font("Serif", Font.PLAIN, 14));
        labelHeight.setFont(new Font("Serif", Font.PLAIN, 14));
        labelWeight.setFont(new Font("Serif", Font.PLAIN, 14));
        labelDoB.setFont(new Font("Serif", Font.PLAIN, 14));
        labelType.setFont(new Font("Serif", Font.PLAIN, 14));
        labelSport.setFont(new Font("Serif", Font.PLAIN, 14));
        labelHobbies.setFont(new Font("Serif", Font.PLAIN, 14));
        labelNote.setFont(new Font("Serif", Font.PLAIN, 14));

        // set font of text field
        tfName.setFont(new Font("Serif", Font.BOLD, 14));
        tfHeight.setFont(new Font("Serif", Font.BOLD, 14));
        tfWeight.setFont(new Font("Serif", Font.BOLD, 14));
        tfDoB.setFont(new Font("Serif", Font.BOLD, 14));
        
        // set font of text area
        noteArea.setFont(new Font("Serif", Font.BOLD, 14));
    }

    public static void createAndShowGUI() {
        PersonFormV5 personFormV5 = new PersonFormV5("Person Form V5");
        personFormV5.addComponents();
        personFormV5.initComponents();
        personFormV5.addMenus();
        personFormV5.setFrameFeatures();
    }

    protected void setFrameFeatures() {
        super.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
