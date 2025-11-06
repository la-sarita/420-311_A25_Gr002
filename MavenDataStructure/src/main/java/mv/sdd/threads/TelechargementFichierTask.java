package mv.sdd.threads;

public class TelechargementFichierTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Téléhargement commencé du fichier : "
                + Thread.currentThread().getName());
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if(Thread.currentThread().isInterrupted()) return;
            System.out.println("Téléchargement de l'octet : " + i);
        }

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("Téléchargement terminé du fichier : "
                        + Thread.currentThread().getName());
    }
}
