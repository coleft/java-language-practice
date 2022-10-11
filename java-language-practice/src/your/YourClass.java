package your;

import my.PackageClass;//같은 패키지에 없기때문에 import해야 한다.

public class YourClass {
	YourClass(){
		PackageClass c = new PackageClass();
		c.b = 100;
		//c.a = 200;	//같은 패키지에서 가능하나 다른 패키지에서는 불가능하다.
		//c.c = 1; //protected...
	}
}
