package c.obj;
import c.gles.obj;
import c.gles.p3;
import c.gles.polh;
import c.polh.polhsq;
public class square extends obj{
	static polh polh=new polhsq();
	public square(final p3 pos,final p3 agl,final p3 dpos,final p3 dagl){
		super(polh,pos,agl,dpos,dagl);
//		chlds.add(new triangle(new p3(),new p3(),new p3(),new p3(0,0,90.f)));
	}
}
