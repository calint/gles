package c.polh;
import c.gles.polh;
public class polhtri extends polh{
	private float vertices[]={0.0f,1.0f,0.0f,-1.0f,-1.0f,0.0f,1.0f,-1.0f,0.0f};
	private short[] indices={0,1,2};
	public polhtri(){
		vertices(vertices);
		indices(indices);
	}
}
