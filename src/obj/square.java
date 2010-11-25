package obj;

import javax.microedition.khronos.opengles.GL10;
import polh.polhsq;
import c.gles.obj;
import c.gles.p3;
import c.gles.polh;

public class square extends obj{
	static polh polh=new polhsq();
	public square(){
		super(polh,new p3(0,0,-4.0f),new p3(),new p3(),new p3(0,0,180.0f));
	}
	public void draw(GL10 gl){
		gl.glTranslatef(pos.x,pos.y,pos.z);
		gl.glRotatef(agl.x,1.0f,0.0f,0.0f);
		gl.glRotatef(agl.y,0.0f,1.0f,0.0f);
		gl.glRotatef(agl.z,0.0f,0.0f,1.0f);
		polh.draw(gl);
	}
}
