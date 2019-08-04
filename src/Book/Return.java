package Book;

public class Return extends  Thread {
   Resource resource;

    public Return(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        //不断地还书
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.add();
        }
    }
}
