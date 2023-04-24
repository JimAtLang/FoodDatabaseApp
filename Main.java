import java.io.IOException;

class Main {
  public static void main(String[] args) {
    Client c = new Client();
    try {
      Food cheddar_cheese = Client.getFoodByName("cheddar%20cheese");
      System.out.println(cheddar_cheese.toString());
    } catch (IOException e){
      System.out.println(e);
    } catch (InterruptedException e){
      System.out.println(e);
    }
  }
}