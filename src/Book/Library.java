package Book;

public class Library {
    public static void main(String[] args) {
        Resource resource = new Resource();
        //借书线程
        Borrow jieshu = new Borrow(resource);
//        Book.Borrow jieshu2 = new Book.Borrow(resource);
//        Book.Borrow jieshu3 = new Book.Borrow(resource);

        //还书线程
        Return huanshu = new Return(resource);
        Return huanshu2 = new Return(resource);
        Return huanshu3 = new Return(resource);
        jieshu.start();
        huanshu.start();
        huanshu2.start();
        huanshu3.start();
    }
}
