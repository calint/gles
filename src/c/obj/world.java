package c.obj;
import c.gles.obj;
import c.gles.p3;
public class world extends obj{
	public world(){
		super(null,new p3(0,0,-10f),new p3(),new p3(),new p3(0,0,10f));
		for(float k=-10f;k<=10f;k+=2f){
			square square=new square(new p3(k,0,-10f),new p3(),new p3(0f,0f,1f),new p3(0,0,-45f));
			chlds().add(square);
			triangle triangle=new triangle(new p3(),new p3(),new p3(),new p3(0,0,90f));
			square.chlds().add(triangle);
		}
	}
}
