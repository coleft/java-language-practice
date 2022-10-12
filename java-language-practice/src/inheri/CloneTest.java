package inheri;

public class CloneTest {
   public static void main(String[] args) throws CloneNotSupportedException {
      Member a=new Member(10);
      Member b=a;
      System.out.println("수정전....");
      System.out.println(a.su + "," + b.su);
      a.su=100;
      System.out.println("수정후....");
      System.out.println(a.su + "," + b.su);
      b.su = 300; //얕은 복사
      System.out.println("두번째수정후....");
      System.out.println(a.su + "," + b.su);
      System.out.println("-".repeat(20));
      Member c = (Member)a.clone();
      c.su=400;
      System.out.println(a.su + "," + c.su);
   }
}