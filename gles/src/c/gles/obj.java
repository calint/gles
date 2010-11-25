package c.gles;

import javax.microedition.khronos.opengles.GL10;

public abstract class obj{
	protected polh polh;
	protected p3 pos;
	protected p3 agl;
	protected p3 dpos;
	protected p3 dagl;

	public obj(polh polh,p3 pos,p3 agl,p3 dpos,p3 dagl){
		this.polh=polh;
		this.pos=pos;
		this.agl=agl;
		this.dpos=dpos;
		this.dagl=dagl;
	}
	public abstract void draw(GL10 gl);
	public void update(float dt){
		pos.add(dpos,dt);
		agl.add(dagl,dt);
	}
}
