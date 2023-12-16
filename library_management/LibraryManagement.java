package library_management; // এই লাইনটি বলছে যে এই কোড একটি 'library_management' নামের প্যাকেজে থাকবে।

import java.util.ArrayList; // এটি ব্যবহার করা হয়েছে যেখানে 'ArrayList' ক্লাসটি জাভার অংশ হিসেবে ইমপোর্ট করা হচ্ছে।

public class LibraryManagement {
    private ArrayList<String> books;
    private ArrayList<String> issuedBooks;
// এই দুটি লাইনে একাধিক 'ArrayList' ডেক্লেয়ার করা হয়েছে, একটি 'books' এবং একটি 'issuedBooks', 
// যেগুলি 'String' অবজেক্ট সংরক্ষণ করবে।
    
    public LibraryManagement() {
        books = new ArrayList<>();
        issuedBooks = new ArrayList<>();
// কনস্ট্রাক্টরে 'books' এবং 'issuedBooks' ভেরিয়েবলগুলির জন্য নতুন 'ArrayList' ইনিশিয়ালাইজ করা হয়েছে।
    }

    public void addBook(String bookTitle) {
        books.add(bookTitle);
// 'addBook' মেথডে নতুন বই যোগ করার জন্য 'books' অ্যারেতে 'bookTitle' যোগ করা হচ্ছে।
    }

    public void issueBook(String bookTitle) {
// issueBook' মেথডে প্রথমে চেক করা হচ্ছে যে বইটি 'books' অ্যারেতে আছে কিনা। যদি থাকে, 
// তবে সেই বইটি 'books' থেকে মুছে ফেলা হচ্ছে এবং 'issuedBooks' অ্যারেতে যোগ করা হচ্ছে। 
// এরপরে একটি মেসেজ প্রিন্ট হচ্ছে যে বইটি ইস্যু করা হয়েছে অথবা বইটি লাইব্রেরিতে নেই।
    	
        if (books.contains(bookTitle)) {
            books.remove(bookTitle);
            issuedBooks.add(bookTitle);
            System.out.println(bookTitle + " has been issued.");
        } else {
            System.out.println("Sorry, " + bookTitle + " is not available in the library.");
        }
    }

    public void returnBook(String bookTitle) {
// 'returnBook' মেথডে প্রথমে চেক করা হচ্ছে যে বইটি 'issuedBooks' অ্যারেতে আছে কিনা। যদি থাকে, 
// তবে সেই বইটি 'issuedBooks' অ্যারে থেকে মুছে ফেলা হচ্ছে এবং 'books' অ্যারেতে ফিরে যোগ করা হচ্ছে। 
// এরপরে একটি মেসেজ প্রিন্ট হচ্ছে যে বইটি ফিরে দেওয়া হয়েছে অথবা বইটি বর্তমানে ইস্যু করা হয়নি।
        if (issuedBooks.contains(bookTitle)) {
            issuedBooks.remove(bookTitle);
            books.add(bookTitle);
            System.out.println(bookTitle + " has been returned.");
        } else {
            System.out.println("Sorry, " + bookTitle + " is not currently issued.");
        }
    }

    public void displayAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Available books in the library:");
            for (String book : books) {
                System.out.println(book);
            }
        }
    }

    public void displayIssuedBooks() {
// 'displayAvailableBooks' মেথডে লাইব্রেরিতে উপলব্ধ বইগুলি প্রদর্শন করা হচ্ছে 
// যদি 'books' অ্যারেটি খালিনা হয়।
        if (issuedBooks.isEmpty()) {
            System.out.println("No books are currently issued.");
        } else {
            System.out.println("Books currently issued to library members:");
            for (String book : issuedBooks) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
// একটি LibraryManagement ক্লাসের ইনস্ট্যান্স তৈরি করা হয়েছে।লাইব্রেরিতে তিনটি বই 
// ("Book 1", "Book 2", "Book 3") যোগ করা হয়েছে।
        library.addBook("Book 1");
        library.addBook("Book 2");
        library.addBook("Book 3");

        library.displayAvailableBooks(); // লাইব্রেরিতে প্রাথমিকভাবে বইগুলি দেখানো হচ্ছে।

        library.issueBook("Book 4"); // - লাইব্রেরিতে "Book 1" (যা লাইব্রেরিতে আছে ) এবং "Book 4" (যা লাইব্রেরিতে নেই ) ইস্যু করার চেষ্টা হচ্ছে।
        library.issueBook("Book 1");
        library.issueBook("Book 4");

        library.displayAvailableBooks(); // বই ইস্যু করার পরে এভেইলেভল বইগুলি এবং ইস্যু করা বইগুলি দেখানো হচ্ছে।
        library.displayIssuedBooks();

        //(যা ইস্যু করা হয়েছিল) এবং "Book 4" (যা ইস্যু করা হয়নি) ফেরত দেওয়ার চেষ্টা হচ্ছে।
        library.returnBook("Book 1"); // 
        library.returnBook("Book 4");

      //বই ফেরত দেওয়ার পরে এভেইলেভল বইগুলি এবং ইস্যু করা বইগুলি দেখানো হচ্ছে।
        library.displayAvailableBooks(); 
        library.displayIssuedBooks();
    }
}


