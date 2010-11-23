package c.gles;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class gles extends Activity implements GLSurfaceView.Renderer{
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		GLSurfaceView view=new GLSurfaceView(this);
		setContentView(view);
		view.setRenderer(this);
	}
	
	world square=new world();
	float clear_r=0.0f;
	
	//GLSurfaceView.Renderer
	public void onSurfaceCreated(GL10 gl,EGLConfig config){
//		gl.glShadeModel(GL10.GL_SMOOTH);
//		gl.glEnable(GL10.GL_DEPTH_TEST);
//		gl.glDepthFunc(GL10.GL_LEQUAL);
//		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,GL10.GL_NICEST);
		gl.glFrontFace(GL10.GL_CCW);
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glCullFace(GL10.GL_BACK);
		gl.glClearDepthf(1.0f);
	}
	float agl_x,agl_y,agl_z;
	float pos_x,pos_y,pos_z=-4;
	double dt=0.100f;
	public void onDrawFrame(GL10 gl){
		long t0=System.currentTimeMillis();
		gl.glClearColor(clear_r,0.0f,0.0f,0.0f);
		clear_r+=1.0f*dt;
		if(clear_r>1.0f)
			clear_r=0;
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(pos_x,pos_y,pos_z);
		gl.glRotatef(agl_x,1.0f,0.0f,0.0f);
		gl.glRotatef(agl_y,0.0f,1.0f,0.0f);
		square.draw(gl);
		agl_x+=180.0f*dt;
		agl_y+=180.0f*dt;
		long t1=System.currentTimeMillis();
		long dt_ms=t1-t0;
		dt=dt_ms/1000.0f;
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