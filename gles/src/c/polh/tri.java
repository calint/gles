package c.polh;
import c.gles.p3;
import c.gles.polh;
public class tri extends polh{
	private float[]vertices={0.0f,1.0f,0.0f,-1.0f,-1.0f,0.0f,1.0f,-1.0f,0.0f};
	private short[]indices={0,1,2};
	public tri(){
		vertices(vertices);
		indices(indices);
		color(new p3(1f,0,0));
	}
}
