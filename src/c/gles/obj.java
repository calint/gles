package c.gles;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;
public abstract class obj{
	private polh polh;
	private p3 pos;
	private p3 agl;
	private p3 dpos;
	private p3 dagl;
	private List<obj>chlds=new ArrayList<obj>();
	public obj(final polh polh,final p3 pos,final p3 agl,final p3 dpos,final p3 dagl){
		this.polh=polh;
		this.pos=pos;
		this.agl=agl;
		this.dpos=dpos;
		this.dagl=dagl;
	}
	public void draw(final GL10 gl){
		gl.glPushMatrix();
		gl.glTranslatef(pos.x,pos.y,pos.z);
		gl.glRotatef(agl.x,1.0f,0.0f,0.0f);
		gl.glRotatef(agl.y,0.0f,1.0f,0.0f);
		gl.glRotatef(agl.z,0.0f,0.0f,1.0f);
		gldraw(gl);
		for(obj o:chlds)
			o.draw(gl);
		gl.glPopMatrix();
	}
	public void gldraw(final GL10 gl){
		if(polh==null)
			return;
		polh.draw(gl);
	}
	public void update(final float dt){
		pos.add(dpos,dt);
		agl.add(dagl,dt);
		for(obj o:chlds)
			o.update(dt);
	}
	public List<obj>chlds(){
		return chlds;
	}
}
