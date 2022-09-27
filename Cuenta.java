/**
 *@author Desmont
 **/
public class Cuenta {
    private int balance = 50;
    public int getBalance(){
        return balance;
    }
    public void retirar(int cantidad){
        balance = balance - cantidad;
    }
}
