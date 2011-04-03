package c.polh;
import c.g.polh;
public class sqr extends polh{
	private float[]vertices={-1.0f,1.0f,0.0f,-1.0f,-1.0f,0.0f,1.0f,-1.0f,0.0f,1.0f,1.0f,0.0f,};
	private short[]indices={0,1,2,0,2,3};
	private float[]colors={1f,0f,0f,1f,0f,1f,0f,1f,0f,0f,1f,1f,1f,0f,1f,1f,};
	public sqr(){
		vertices(vertices);
		indices(indices);
		colors(colors);
	}
}
