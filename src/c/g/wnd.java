package c.g;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLU;
import android.view.MotionEvent;
final public class wnd extends obj{
	private p3 bgc=p3.o();
	private int wi;
	private int hi;
	private obj wld;
	public wnd(final obj wld,final p3 pos,final p3 agl){
		super(null,pos,agl,p3.o(),p3.o());
		this.wld=wld;
	}
	public void onSurfaceCreated(final GL10 gl,final EGLConfig config){
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glClearDepthf(1.0f);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,GL10.GL_NICEST);
		gl.glFrontFace(GL10.GL_CCW);
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glCullFace(GL10.GL_BACK);
	}
	public void onSurfaceChanged(final GL10 gl,final int width,final int height){
		this.wi=width;
		this.hi=height;
		gl.glViewport(0,0,width,height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl,45.0f,(float)width/(float)height,0.1f,Float.MAX_VALUE);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
	}
	public void render(final GL10 gl){
		gl.glClearColor(bgc.x,bgc.y,bgc.z,0.0f);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glRotatef(-agl.x,1,0,0);
		gl.glRotatef(-agl.y,0,1,0);
		gl.glRotatef(-agl.z,0,0,1);
		gl.glTranslatef(-pos.x,-pos.y,-pos.z);
		wld.draw(gl);
	}
	@Override public void update(final float dt){
		super.update(dt);
	}
	public boolean dispatchTouchEvent(final MotionEvent event) {
		final float div=(wi-event.getX())/wi;
		bgc.x=div;
		final float div2=(hi-event.getY())/hi;
		bgc.y=div2;
		agl.x=div2*45-22.5f;
		agl.y=div*45-22.5f;
		return true;
	}
}
