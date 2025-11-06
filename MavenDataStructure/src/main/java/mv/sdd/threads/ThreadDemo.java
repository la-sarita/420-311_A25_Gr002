package mv.sdd.threads;

public class ThreadDemo {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
        Thread thread = lancerThread();
        interuptThread(thread);
//        }
    }

    public static Thread lancerThread(){
        Thread thread = new Thread(new TelechargementFichierTask());
        thread.start();

        return thread;
    }

    public static void interuptThread(Thread thread){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
    }
}
