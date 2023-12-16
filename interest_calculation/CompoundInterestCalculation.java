package interest_calculation;

import javax.swing.*; // Swing লাইব্রেরি থেকে প্রয়োজনীয় ক্লাসগুলো ইমপোর্ট করে।
import java.awt.*; // AWT লাইব্রেরি থেকে ইন্টারফেস এবং ইউজার ইন্টারফেসের কম্পোনেন্টগুলি ইমপোর্ট করে।
import java.awt.event.*;// AWT ইভেন্ট হ্যান্ডলিংয়ের জন্য প্রয়োজনীয় ক্লাসগুলো ইমপোর্ট করে

public class CompoundInterestCalculation {
    public static void main(String[] args) {
    	
    	// এটি Jframe এর একটি অবজেক্ট তৈরি করে যা উইন্ডোর মতো কাজ করে।
        JFrame frame= new JFrame(); 
        
     // এটি ফ্রেম বন্ধ করা হলে প্রোগ্রামও বন্ধ করে দেয়।
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(450,450); //ফ্রেমের আকার সেট করে। 

        // লেভেল তৈরি করে 
        JLabel l1=new JLabel("Capital: ");
        JLabel l2 =new JLabel("Rate of Profit per Year: ");
        JLabel l3=new JLabel("Number of Year: ");
        JLabel l4=new JLabel("Compound Profit: ");
     
 //টেক্সট ফিল্ড তৈরি করে যেখানে ব্যবহারকারী মান লিখতে পারবে।
        JTextField t1=new JTextField(10);
        JTextField t2=new JTextField(10);
        JTextField t3=new JTextField(10);
        JTextField t4=new JTextField(10);
// প্যানেল তৈরি করে। প্যানেল লেভেল, টেক্সটফিল, বাটন এর কনটেইনার বা ধারক হিসেবে কাজ করে। 
        JPanel p1=new JPanel(); // p1 নামে Jpanel একটা constructor তৈরি করা হয়েছে।
        
      //প্যানেলের লেআউট সেট করে ফ্লো লেআউটে (একপাশে লেবেল ও টেক্সট ফিল্ড পাশাপাশি থাকবে)।
        p1.setLayout(new FlowLayout()); 
        
        //প্যানেল p1 এ লেবেল l1  এবং টেক্সট ফিল্ড t1যুক্ত করা হয়েছে। 
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

     // একটি "Calculate" নামে Button তৈরি করা হয়েছে। 
        JButton b=new JButton("Calculate"); 
        JPanel p5=new JPanel();
        p5.setLayout(new FlowLayout());
        p5.add(b);
        
        frame.setLayout(new GridLayout(6,1)); 
// মূল ফ্রেম (frame) এর লেআউটকে GridLayout হিসেবে সেট করে, যাতে ৬টি সারি এবং ১টি কলাম থাকে।
// এর মানে হলো, ফ্রেমে যুক্ত করা সব কম্পোনেন্ট (লেবেল, টেক্সট ফিল্ড, বোতাম ইত্যাদি) ৬টি উল্লম্ব সারিতে সাজানো হবে, 
// প্রতি সারিতে ১টি কম্পোনেন্ট।
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p5);
        frame.add(p4);

// addActionListener: এটি একটি মেথড যা বোতামে একটি (Listener) যুক্ত করে।
// এই Listner, Button এ ক্লিক করা হলে একটি ইভেন্ট তৈরি করে।  
// new ActionListener(): এটি একটি নতুন ActionListener ইন্টারফেসের একটি বেনামী বস্তু তৈরি করে। 
// ActionListener ইন্টারফেসটি একটি অবশ্যম্ভাবী মেথড actionPerformed ঘোষণা করে, যা ইভেন্ট ঘটলে কল হয়।
// actionPerformed মেথডটি ActionListener ইন্টারফেসের অংশ। 
// যখন বোতাম b ক্লিক করা হয়, তখন এই মেথডটি কল হয়।
// ActionEvent e: এটি একটি প্যারামিটার যা ইভেন্ট সম্পর্কে তথ্য ধারণ করে, যেমন কোন বোতামে ক্লিক করা হয়েছে।
        
        b.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==b){
//  এটি একটি কোড ব্লক যা actionPerformed মেথডের কার্যকারিতা নির্ধারণ করে। 
//  এই ব্লকটি নির্দেশ করে যে বোতাম ক্লিক করা হলে কী করা উচিত।
                    double p=Double.parseDouble(t1.getText());
                    double r=Double.parseDouble(t2.getText());
                    double n=Double.parseDouble(t3.getText());

                    double s=Math.pow((1+(r/100)), n);    //or, double res=(p*Math.pow(((1+(r/100)), n))));
                    double res=p*s;
                    double interest = res-p;
                    t4.setText(String.format("%.2f",interest));  //or, t4.setText(String.valueOf(res));
                }
            }
        });
        
        frame.setVisible(true);// ফ্রেম দৃশ্যমান করে।   
    }   
}