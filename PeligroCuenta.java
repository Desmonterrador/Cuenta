/**
 *@author migue
 **/
class PeligroCuenta implements Runnable {
    private Cuenta cuenta = new Cuenta ();
    public static void main (String [] args) {
            PeligroCuenta r = new PeligroCuenta();
            Thread uno = new Thread(r);
            Thread dos = new Thread(r);
            uno.setName("Fred");
            dos.setName("Lucy");
            uno.start();
            dos.start();
    }

    public void run() {
            for (int i = 0; i < 5; i++)
            {
                    hacerRetiro(10);
                    if(cuenta.getBalance() < 0) {
                            System.out.println("La cuenta esta sobregirada!");
                    }
            }
    }

    private synchronized void hacerRetiro(int cant) {  
            if(cuenta.getBalance() >= cant) {
                    System.out.println(Thread.currentThread().getName() + " hará un retiro");
                    try {
                            Thread.sleep(500);
                    } catch(InterruptedException ex) {}
                    cuenta.retirar(cant);
                    System.out.println(Thread.currentThread().getName() + " completo el retiro." + cuenta.getBalance());
            } else {
                    System.out.println("No suficiente en cuenta para que " + Thread.currentThread().getName()
                            + " hago un retiro " + cuenta.getBalance());
            }
    }
}
