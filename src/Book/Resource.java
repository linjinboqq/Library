package Book;

public class Resource {
    //当前书本数量
    private int num = 1;
    //资源池中允许存放最大书本数目
    private int size = 3;

    public synchronized void remove() {
        if (num > 0) {
            num--;
            System.out.println("借了一本书 还有" + (num) + "本");
            notifyAll();//通知生产者生产资源
        } else {
            try {
                //如果没有资源，则消费者进入等待状态
                System.out.println("暂时没有书本可以借出");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void add() {
        if (num < size) {
            num++;
            //通知等待的消费者
            System.out.println("还了一本书 还有" + (num) + "本书");
            notifyAll();
        } else {
            System.out.println("书籍齐全 无需归还");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}




