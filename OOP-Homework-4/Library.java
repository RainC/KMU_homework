
public class Library {
    String name;
    public static String hour;
    private Book[] books;

    public Library(String lblName) {
        this.name = lblName;
        this.hour = "9 AM to 5PM";
        books = new Book[10];
        for (int i = 0; i < 10; i++) {
            this.books[i] = null;
        }

    }
    public String getName() {
        return this.name;
    }
    public boolean rentBook(String name) {
        boolean check_rent = false;
        for (int i = 0 ; i< 10 ; i++) {
            if (books[i] == null) {

            } else {
                String bookname = books[i].getTitle();
                boolean borrowed = books[i].isInPlace();
                if (bookname == name) {
                    if (borrowed == true) {
                        books[i].rent();
                        check_rent = true;
                        break;
                    } else {
                        check_rent = false;
                    }
                } else {
                    check_rent = false;
                }
            }

        }
        return check_rent;
    }

    public void handInBook(String name) {
        for (int i = 0 ; i < books.length ; i++) {
            if (books[i] == null) {

            } else {
                if (books[i].getTitle() == name) {
                    books[i].handIn();
                }
            }

        }
    }

    public void printAllRentedBooks() {
        for (int i = 0 ; i < books.length ; i++) {
            if (books[i] == null) {

            } else {
                boolean check_rented = books[i].isInPlace();
                if (check_rented == true ) {
                    System.out.println(books[i].getTitle() + " is rented in " + this.name);
                }
            }

        }
    }

    public void printAllBooks() {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {

            } else {
                System.out.println(books[i].getTitle());
                System.out.println(books[i].isInPlace());
            }

        }
    }
    public void addBook(Book book) {
        String bookTitle = book.getTitle();
        boolean getBorrowed = book.isInPlace();

        boolean checkBookAvailable = false;
        int availableBookIndex = 0;
        for (int i = 0; i < 10; i++) {
            if (books[i] == null) { // 빈 공간 검색
                availableBookIndex = i;
                checkBookAvailable = true;
                break;
            } else {
                checkBookAvailable = false;
            }
        }

        if (checkBookAvailable == false ) {
            System.out.println("책 놓을 공간이 없습니다.");
        } else {
            this.books[availableBookIndex] = book;
        }
    }



}
