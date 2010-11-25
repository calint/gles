package c.obj;
import c.gles.obj;
import c.gles.p3;
import c.gles.polh;
import c.polh.tri;
public class triangle extends obj{
	private static polh polh=new tri();
	public triangle(final p3 pos,final p3 agl,final p3 dpos,final p3 dagl){
		super(polh,pos,agl,dpos,dagl);
	}
}
