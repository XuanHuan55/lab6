/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2_lab6;

/**
 *
 * @author ASUS
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author haing
 */
public class MainFrame extends JFrame {

    private JButton btnCalculate;
    private JComboBox dayPrice;
    private JTextField nameTextField;
    private JCheckBox breakfastCheckbox, goftCheckbox, poolCheckbox;

    public MainFrame() throws HeadlessException {
        this.setTitle("This is my First Frame");
        this.setSize(400, 400);
        this.setLocation(200, 200);
        this.setLayout(new GridLayout(7, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel(new FlowLayout());

        JLabel label1 = new JLabel("Resort Price Calculate");
        label1.setVerticalTextPosition(JLabel.NORTH);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        Font myFont = new Font("a", Font.BOLD, 30);
        label1.setFont(myFont);
        panel1.add(label1);

        JPanel panel2 = new JPanel(new FlowLayout());
        JLabel label2 = new JLabel("Base price for a room is 200$");
        Font myFont2 = new Font("", Font.BOLD, 20);
        label2.setFont(myFont2);
        panel2.add(label2);

        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel label3 = new JLabel("Choose obtions that you want");
        Font myFont3 = new Font("", Font.BOLD, 20);
        label3.setFont(myFont3);
        panel3.add(label3);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);

        JPanel panel4 = new JPanel(new FlowLayout());
        JLabel label4 = new JLabel("Guest name: ");
        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(200, 20));
        panel4.add(label4);
        panel4.add(nameTextField);
        this.add(panel4);

        JPanel panel5 = new JPanel(new FlowLayout());
        breakfastCheckbox = new JCheckBox("Breakfast $20");
        goftCheckbox = new JCheckBox("Goft $50");
        poolCheckbox = new JCheckBox("Pool $15");
        panel5.add(breakfastCheckbox);
        panel5.add(goftCheckbox);
        panel5.add(poolCheckbox);
        this.add(panel5);

        JPanel panel6 = new JPanel(new FlowLayout());
        dayPrice = new JComboBox<>(new String[]{"Weekday (-10%)", "Weekend(+30%)"});
        panel6.add(dayPrice);
        btnCalculate = new JButton("Calculate");
        panel6.add(btnCalculate);
        this.add(panel6);

        JPanel panel7 = new JPanel(new FlowLayout());
        JLabel result = new JLabel("Hello your payment is: ");
        panel7.add(result);
        this.add(panel7);

        btnCalculate.addActionListener((e) -> {
            String name = nameTextField.getText();
            double totalPrice = 200;
            if (breakfastCheckbox.isSelected()) {
                totalPrice += 20;
            }
            if (goftCheckbox.isSelected()) {
                totalPrice += 50;
            }
            if (poolCheckbox.isSelected()) {
                totalPrice += 15;
            }

            if (dayPrice.getSelectedIndex() == 1) {
                totalPrice = totalPrice + 0.3 * totalPrice;
            } else {
                totalPrice = totalPrice - 0.1 * totalPrice;
            }

            result.setText(String.format("Hello %s Your payment is: $%.2f", name, totalPrice));
        });

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
