package c.obj;
import c.g.obj;
import c.g.p3;
public class world extends obj{
	public world(){
		super(null,new p3(),new p3(),new p3(),new p3());
		for(int i=0;i<2;i++){
			square square=new square(new p3(i,0,-i),new p3(),new p3(),new p3(0,0,-45f));
			chlds().add(square);
		}
	}
}
