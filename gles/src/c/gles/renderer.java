package c.gles;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.util.Log;

public class renderer implements Renderer{
	square square=new square();
	public void onSurfaceCreated(GL10 gl,EGLConfig config){
		gl.glClearColor(1.0f,0.0f,0.0f,0.5f);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glClearDepthf(1.0f);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,GL10.GL_NICEST);
	}
	float agl_x,agl_y,agl_z;
	float pos_x,pos_y,pos_z=-4;
	public void onDrawFrame(GL10 gl){
		long t0=System.currentTimeMillis();
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(pos_x,pos_y,pos_z);
		gl.glRotatef(agl_x,1.f,0,0);
		gl.glRotatef(agl_y,0.f,1.f,0);
		square.draw(gl);
		agl_x++;
		agl_y++;
		long t1=System.currentTimeMillis();
		long dt=t1-t0;
		Log.d("***",""+dt);
	}
	public void onSurfaceChanged(GL10 gl,int width,int height){
		gl.glViewport(0,0,width,height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl,45.0f,(float)width/(float)height,0.1f,100.0f);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
}
