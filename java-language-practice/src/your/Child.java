package your;

import my.PackageClass;

public class Child extends PackageClass{
	Child(){
		//a=1;	//같은 패키지 내에선 쓰지만, 다른 패키지에서는 쓸 수 없다.(접근제한자가 상당히 까다롭고...)
		b=2;
		c=3;
	}
}
