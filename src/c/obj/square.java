package c.obj;
import c.g.obj;
import c.g.p3;
import c.g.polh;
import c.polh.sqr;
public class square extends obj{
	private static polh polh=new sqr();
	public square(final p3 pos,final p3 agl,final p3 dpos,final p3 dagl){
		super(polh,pos,agl,dpos,dagl);
		chlds.add(new triangle(new p3(),new p3(),new p3(),new p3(0,0,90.f)));
	}
}
