package c.obj;
import c.gles.obj;
import c.gles.p3;
import c.gles.polh;
import c.polh.polhtri;
public class triangle extends obj{
	static polh polh=new polhtri();
	public triangle(final p3 pos,final p3 agl,final p3 dpos,final p3 dagl){
		super(polh,pos,agl,dpos,dagl);
	}
}
