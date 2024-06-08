
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3_lab6;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author haing
 */
public class MainFrame extends JFrame {

    private JTextField idTextField, titleTextField, priceTextField, yearTextField;
    private JComboBox collection;
    private JRadioButton VCDrbtn, CDrbtn;
    private JButton btnAdd, btnClear, btnShowAll;
    private ButtonGroup rbtn;

    private CD_management CDs = new CD_management();

    public CD_management getCDs() {
        return CDs;
    }

    public void setCDs(CD_management CDs) {
        this.CDs = CDs;
    }

    public MainFrame() throws HeadlessException {
        this.setTitle("Xuan Huan_CDStore");
        this.setSize(400, 400);
        this.setLocation(200, 200);
        this.setLayout(new GridLayout(7, 1));

        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("CD ID");
        idTextField = new JTextField();
        idTextField.setPreferredSize(new Dimension(250, 20));
        panel1.add(label1);
        panel1.add(idTextField);
        this.add(panel1);

        JPanel panel2 = new JPanel(new FlowLayout());
        JLabel label2 = new JLabel("CD Title");
        titleTextField = new JTextField();
        titleTextField.setPreferredSize(new Dimension(250, 20));
        panel2.add(label2);
        panel2.add(titleTextField);
        this.add(panel2);
        rbtn = new ButtonGroup();
        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel label3 = new JLabel("CD Collection");
        collection = new JComboBox<>(new String[]{"movie", "game", "music"});
        JLabel label4 = new JLabel("CD Type");
        VCDrbtn = new JRadioButton("VCD");
        CDrbtn = new JRadioButton("CD");

        rbtn.add(VCDrbtn);
        rbtn.add(CDrbtn);
        panel3.add(label3);
        panel3.add(collection);
        panel3.add(label4);
        panel3.add(VCDrbtn);
        panel3.add(CDrbtn);
        this.add(panel3);

        JPanel panel4 = new JPanel(new FlowLayout());
        JLabel label5 = new JLabel("CD Price");
        priceTextField = new JTextField();
        priceTextField.setPreferredSize(new Dimension(250, 20));
        panel4.add(label5);
        panel4.add(priceTextField);
        this.add(panel4);

        JPanel panel5 = new JPanel(new FlowLayout());
        JLabel label6 = new JLabel("CD Year of Release");
        panel5.add(label6);
        this.add(panel5);

        JPanel panel6 = new JPanel(new FlowLayout());
        yearTextField = new JTextField();
        yearTextField.setPreferredSize(new Dimension(250, 20));
        btnAdd = new JButton("Add");
        btnAdd.addActionListener((e) -> {
            AddaCD();
        });
        panel6.add(yearTextField);
        panel6.add(btnAdd);
        this.add(panel6);

        JPanel panel7 = new JPanel(new FlowLayout());
        btnClear = new JButton("Clear");
        btnClear.addActionListener((e) -> {
            clear();
        });
        btnShowAll = new JButton("Show All");
        panel7.add(btnClear);
        panel7.add(btnShowAll);
        this.add(panel7);

    }

    private void AddaCD() {
        String title = titleTextField.getText();
        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill title", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String collectionCD = collection.getSelectedItem().toString();
        String typeCD;
        if (VCDrbtn.isSelected()) {
            typeCD = "VCD";
        } else {
            typeCD = "CD";
        }
        if (typeCD.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please choose type of CD", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String idCD = idTextField.getText();
        String priceCD = priceTextField.getText();
        String yearReleaseCD = yearTextField.getText();
        try {
            long id = Long.parseLong(idCD);
            double price = Double.parseDouble(priceCD);
            int yearRelease = Integer.parseInt(yearReleaseCD);
            CDs.getListCD().add(new CD(id, title, collectionCD, typeCD, price, yearRelease));
            JOptionPane.showMessageDialog(null, "Succesful", "Success", JOptionPane.INFORMATION_MESSAGE);
            clear();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID, price, year must be numbers, please try again", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void clear() {
        idTextField.setText("");
        titleTextField.setText("");
        collection.setSelectedIndex(0);
        rbtn.clearSelection();
        priceTextField.setText("");
        yearTextField.setText("");
    }

    public MainFrame(GraphicsConfiguration gc) {
        super(gc);
    }

    public MainFrame(String title) throws HeadlessException {
        super(title);
    }

    public MainFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

}
