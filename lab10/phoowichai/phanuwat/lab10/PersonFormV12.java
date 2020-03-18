/**
 * 
 * Author: Phanuwat Phoowichai
 * ID: 623040140-8
 * Sec: 2
 * Date: March 10, 2020
 * 
 **/

package phoowichai.phanuwat.lab10;

import java.awt.event.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import javax.swing.*;

public class PersonFormV12 extends PersonFormV11 {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected JMenu dataMenu;
    protected JMenuItem displayMI, sortMI, searchMI, removeMI;
    protected ArrayList<Person> personList;
    protected JFileChooser FileChooser;
    protected Person person;

    public PersonFormV12(String msg) {
        super(msg);
    }

    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        Object src = event.getSource();
        if (src == displayMI) {
            handleDisplayMI();
        } else if (src == sortMI) {
            handleSortMI();
        } else if (src == searchMI) {
            handleSearchMI();
        } else if (src == removeMI) {
            handleRemoveMI();
        }
    }

    protected void handleDisplayMI() {
        String list = "";
        Integer nLoop = 0;
        for (Person person : personList) {
            if (nLoop > 0) {
                list += ", " + person + "\n";
                nLoop++;
            } else {
                list += "[";
                list += person + "\n";
                nLoop++;
            }
            if (personList.size() == nLoop) {
                list += "]";
            }
        }

        JOptionPane.showMessageDialog(this, list, "Person List", JOptionPane.INFORMATION_MESSAGE, javaIcon);
    }

    protected void handleSortMI() {
        Collections.sort(personList);
        handleDisplayMI();
    }

    protected void handleSearchMI() {
        String name = JOptionPane.showInputDialog("Please enter a person name to search : ");
        Person person = searchName(name);

        if (person != null) {
            JOptionPane.showMessageDialog(this, person + " is found.", "Message", JOptionPane.INFORMATION_MESSAGE,
                    javaIcon);
        } else {
            JOptionPane.showMessageDialog(this, name + " is not found.", "Message", JOptionPane.INFORMATION_MESSAGE,
                    javaIcon);
        }
    }

    protected void handleRemoveMI() {
        String name = JOptionPane.showInputDialog("Please enter a person name to remove : ");
        Person person = searchName(name);

        if (person != null) {
            personList.remove(person);
            JOptionPane.showMessageDialog(this, person + " is remove.", "Message", JOptionPane.INFORMATION_MESSAGE,
                    javaIcon);
        } else {
            JOptionPane.showMessageDialog(this, name + " is not found.", "Message", JOptionPane.INFORMATION_MESSAGE,
                    javaIcon);
        }
    }

    protected Person searchName(String name) {
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    protected void handleOkButton() {
        createPerson();
        personList.add(person);
        String msg = getOkButtonInfo();
        msg += "\n\nAdding this person into the list : " + person;
        JOptionPane.showMessageDialog(this, msg, "Person Information", JOptionPane.INFORMATION_MESSAGE, javaIcon);
    }

    protected void createPerson() {
        String name = tfName.getText();
        double height = Double.parseDouble(tfHeight.getText());
        double weight = Double.parseDouble(tfWeight.getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dob = LocalDate.parse(tfDoB.getText(), formatter);
        person = new Person(name, weight, height, dob);
    }

    // ------------------------------ //

    public void addListeners() {
        super.addListeners();

        displayMI.addActionListener(this);
        sortMI.addActionListener(this);
        searchMI.addActionListener(this);
        removeMI.addActionListener(this);
    }

    public void addComponents() {
        super.addComponents();

        personList = new ArrayList<Person>();
    }

    public void addMenus() {
        super.addMenus();

        dataMenu = new JMenu("Data");
        displayMI = new JMenuItem("Display");
        sortMI = new JMenuItem("Sort");
        searchMI = new JMenuItem("Search");
        removeMI = new JMenuItem("Remove");

        dataMenu.add(displayMI);
        dataMenu.add(sortMI);
        dataMenu.add(searchMI);
        dataMenu.add(removeMI);

        menuBar.add(dataMenu);
    }

    public static void createAndShowGUI() {
        PersonFormV12 personFormV12 = new PersonFormV12("Person Form V12");
        personFormV12.addComponents();
        personFormV12.initComponents();
        personFormV12.addMenus();
        personFormV12.addListeners();
        personFormV12.addKeys();
        personFormV12.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}