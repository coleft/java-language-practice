package control;

public class ForTestTeacher {
   /* 파라메터로 전달된 정수까지 1부터 출력*/
   public void test1(int su) {
      System.out.println("------------");
      for(int a=1; a<=su; a++) {
      System.out.printf("%d %n", a);
      }
   }
   
   /* 1부터 파라메터로 전달된 정수까지의 홀수의 합*/
   public void test2(int su) {
      System.out.println("------------");
      int s = 0;
      for(int a=1; a<=su; a++) {
         if(a%2==1) {
            s += a;
            
         }   
      }
      System.out.printf("%d %n", s);
   }
   
   /* 파라메터로 전달된 수에 해당하는 구구단 출력 */
   public void test3(int su) {
      System.out.println("------------");
      int r = 0;
      for(int a=1; a<10; a++) {
         r = su*a;
         System.out.println(su + "*" + a + "=" + r);
      }
   }
   
   /* 1부터 파라메터로 전달된 n까지의 합계가 1500이상이 되는 시점의 값과 합계 출력 */
   public void test4(int n) {
      System.out.println("------------");
      int hap = 0;
      int i = 0;
      for(i = 1; i<=n; i++) {
    	  hap += i;if(hap>=1500) break;
      }
      System.out.printf("i=%d, hap=%d\n", i, hap);
   }
   
   public static void main (String[] ff) {
      ForTestTeacher dd = new ForTestTeacher();
      dd.test1(24);
      dd.test2(24);
      dd.test3(6);
      dd.test4(100);
}

}