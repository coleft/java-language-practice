package inheri;

public class Member implements Cloneable{
   int su;
   public Member(int s) {
      this.su = s;
   }
   
   @Override
   protected Object clone() {
      Object o = null;
      try {
      o=super.clone();
   }catch(CloneNotSupportedException ex) {
      
   }
      return o;
   }
}