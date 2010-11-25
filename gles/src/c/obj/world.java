package c.obj;
import c.gles.obj;
import c.gles.p3;
public class world extends obj{
	public world(){
		super(null,new p3(0,0,-10f),new p3());
		square square=new square(new p3(),new p3(),new p3(1f,1f,0),new p3(0,0,-45f));
		chlds.add(square);

		triangle triangle=new triangle(new p3(),new p3(),new p3(),new p3(0,0,90f));
		square.chlds().add(triangle);
	}
}
