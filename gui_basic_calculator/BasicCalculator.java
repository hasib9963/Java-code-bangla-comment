package gui_basic_calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicCalculator  {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Calculator");
        JTextField textField = new JTextField(20);
        
// এই লাইন 4 লাইন এবং 4 কলামের একটি গ্রিড লেআউট দিয়ে একটি নতুন JPanel অবজেক্ট তৈরি করে।
//এটি ক্যালকুলেটর Button গুলো সাজিয়ে রাখবে। 
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

//এই লাইন ক্যালকুলেটর বোতামগুলির লেবেলগুলো সংরক্ষণের জন্য একটি স্ট্রিং অ্যারে ঘোষণা করে।
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        JTextField inputField = new JTextField();

//এই লাইন একটি ActionListener ইন্টারফেসের একটি Unkwon Object তৈরি করে। 
// এই Listner ক্যালকুলেটর Button গুলি ক্লিক করা হলে কী ঘটবে তা নির্ধারণ করে।
        ActionListener buttonListener = new ActionListener() {
        	
// private: এই শব্দটি নির্দেশ করে যে input ভেরিয়েবল ক্লাসের ভেতরেই ব্যবহার করা যাবে, 
//অন্য কোনো ক্লাস বা ফাংশন থেকে অ্যাক্সেস করা যাবে না।
// StringBuilder: এটি একটি ডেটা টাইপ যা একটি পরিবর্তনশীল স্ট্রিং তৈরি করতে ব্যবহৃত হয়। 
// এর মান বারবার পরিবর্তন করা যায়, যা সাধারণ String টাইপের চেয়ে বেশি কার্যকরী।
// input: এটি ভেরিয়েবলের নাম।
// new: এই শব্দটি নির্দেশ করে যে আমরা StringBuilder টাইপের একটি নতুন অবজেক্ট তৈরি করছি।
        	private StringBuilder input = new StringBuilder();
            private double num1 = 0;
            private String operator = "";

// এই লাইন actionPerformed মেথড ঘোষণা করে। যখন কোনো Button ক্লিক করা হয় তখন এই মেথডটি কল করা হয়।
            public void actionPerformed(ActionEvent e) {
            	
// এই লাইনটি ক্লিক করা বোতামের লেবেলটি command নামের একটি স্ট্রিং ভেরিয়েবলে সংরক্ষণ করে। এটি নিচের পদক্ষেপগুলো সম্পন্ন করে:
// e.getSource() : এই অংশটি ইভেন্টের উৎস (যে বোতাম ক্লিক করা হয়েছে) খুঁজে বের করে।
// (JButton): এই অংশটি উৎসটিকে একটি JButton অবজেক্টে রূপান্তর করে।
// .getText(): এই অংশটি JButton অবজেক্টের লেবেল টেক্সটটি (যেমন, 7, +, C ইত্যাদি) একটি স্ট্রিং হিসাবে ফেরত দেয়।
// String command = ...: এই অংশটি ফেরত পাওয়া লেবেল টেক্সটটি command ভেরিয়েবলে সংরক্ষণ করে।
// সহজভাবে বলতে, এই লাইনটি ক্লিক করা বোতামের লেবেলটি পড়ে এবং এটিকে command ভেরিয়েবলে সংরক্ষণ করে। পরের কোড ব্লকগুলো এই কমান্ডের উপর ভিত্তি করে বিভিন্ন কাজ করে, যেমন সংখ্যা যুক্ত করা, অপারেটর পরিবর্তন করা, বা গণনাফল দেখানো।
            	String command = ((JButton) e.getSource()).getText();

                if (command.matches("[0-9.]")) {
                    input.append(command);
                } else if (command.matches("[-+*/]")) {
                    num1 = Double.parseDouble(input.toString());
                    operator = command;
                    input.setLength(0);
                } else if (command.equals("=")) {
                    double num2 = Double.parseDouble(input.toString());
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                inputField.setText("Error");
                                return;
                            }
                            break;
                    }
                    inputField.setText(String.valueOf(result));
                    input.setLength(0);
                } else if (command.equals("C")) {
                    input.setLength(0);
                    inputField.setText("");
                }
                textField.setText(input.toString());
            }
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }

        frame.add(textField, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(inputField, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

