public class Student {
   public static double average(int ... varar) {
      double total = 0.0;
      for (int i: varar)
         total += i; 

      return varar.length > 0? total/varar.length : 0.0;
   }

   public static void main(String... args) {
      System.out.println("Average " + average(2, 3, 4));
      System.out.println("Average " + average(3, 4));
      System.out.println("Average " + average());
   }
}
