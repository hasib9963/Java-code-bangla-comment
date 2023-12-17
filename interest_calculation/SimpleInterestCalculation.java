// কম্পাউন্ড ইন্টারেস্ট এর অনুরুপ। 
package interest_calculation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleInterestCalculation {
    public static void main(String[] args) {
        JFrame frame= new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,450);
        JLabel l1=new JLabel("Capital: ");
        JLabel l2 =new JLabel("Rate of Profit per Year: ");
        JLabel l3=new JLabel("Number of Year: ");
        JLabel l4=new JLabel("Profit: ");
        JTextField t1=new JTextField(10);
        JTextField t2=new JTextField(10);
        JTextField t3=new JTextField(10);
        JTextField t4=new JTextField(10);

        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(l1);
        p1.add(t1);
        
        JPanel p2=new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(l2);
        p2.add(t2);

        JPanel p3=new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(l3);
        p3.add(t3);

        JPanel p4=new JPanel();
        p4.setLayout(new FlowLayout());
        p4.add(l4);
        p4.add(t4);

        JButton b=new JButton("Calculate");
        JPanel p5=new JPanel();
        p5.setLayout(new FlowLayout());
        p5.add(b);
        frame.setLayout(new GridLayout(6,1));
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p5);
        frame.add(p4);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==b){
                    double p=Double.parseDouble(t1.getText());
                    double r=Double.parseDouble(t2.getText());
                    double n=Double.parseDouble(t3.getText());

                    double interest=((p*r*n)/100);    //or, double res=(p*Math.pow(((1+(r/100)), n))));
                    
                    t4.setText(String.format("%.2f",interest));  //or, t4.setText(String.valueOf(res));
                }
            }
        });
        
        frame.setVisible(true);    
    }   
}

