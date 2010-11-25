package c.gles;

import javax.microedition.khronos.opengles.GL10;

public class world{
	p3 pos,dpos;
	p3 agl,dagl;
	polh polh;
	public world(polh polh){
		this.polh=polh;
		pos=new p3(0,0,-4.0f);
		agl=new p3();
		dpos=new p3();
		dagl=new p3(0,0,180.0f);
	}

	public void draw(GL10 gl){
		gl.glTranslatef(pos.x,pos.y,pos.z);
		gl.glRotatef(agl.x,1.0f,0.0f,0.0f);
		gl.glRotatef(agl.y,0.0f,1.0f,0.0f);
		gl.glRotatef(agl.z,0.0f,0.0f,1.0f);
		polh.draw(gl);
	}
	public void update(float dt){
		pos.add(dpos,dt);
		agl.add(dagl,dt);
	}
}
