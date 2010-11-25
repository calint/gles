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
import c.obj.world;

public class gles extends Activity implements GLSurfaceView.Renderer{
	private world world=new world();
	private float dt;
	private float bg_red;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		GLSurfaceView view=new GLSurfaceView(this);
		setContentView(view);
		view.setRenderer(this);
	}
	//GLSurfaceView.Renderer
	public void onSurfaceCreated(GL10 gl,EGLConfig config){
//		gl.glShadeModel(GL10.GL_SMOOTH);
//		gl.glEnable(GL10.GL_DEPTH_TEST);
//		gl.glDepthFunc(GL10.GL_LEQUAL);
//		gl.glClearDepthf(1.0f);
//		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,GL10.GL_NICEST);
		gl.glFrontFace(GL10.GL_CCW);
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glCullFace(GL10.GL_BACK);
		gl.glLoadIdentity();
	}
	public void onDrawFrame(GL10 gl){
		long t0=System.currentTimeMillis();
		bg_red+=1.0f*dt;
		if(bg_red>1.0f)
			bg_red=0.0f;
		gl.glClearColor(bg_red,0.0f,0.0f,0.0f);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
		world.draw(gl);
		world.update(dt);
		long t1=System.currentTimeMillis();
		long dt_ms=t1-t0;
		dt=dt_ms/1000.0f;
		Log.d("***",""+bg_red+"   "+dt);
	}
	public void onSurfaceChanged(GL10 gl,int width,int height){
		gl.glViewport(0,0,width,height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl,45.0f,(float)width/(float)height,0.1f,Float.MAX_VALUE);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

}