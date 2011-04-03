package c.g;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
public class activity extends Activity implements GLSurfaceView.Renderer{
	public static String worldcls="c.obj.world";
	private obj world;
	private wnd camera;
	private int fps=24;
	private float dt=1f/fps;
	private long sleepall=(long)(1000f/fps);
	public void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		try{world=(obj)Class.forName(worldcls).newInstance();}catch(Throwable t){throw new Error(t);}
		camera=new wnd(world,p3.o(0,0,10),p3.o(10f,0,0));
		world.chlds().add(camera);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		GLSurfaceView view=new GLSurfaceView(this);
		setContentView(view);
		view.setRenderer(this);
	}
	//GLSurfaceView.Renderer
	public void onSurfaceCreated(final GL10 gl,final EGLConfig config){
		camera.onSurfaceCreated(gl,config);
	}
	public void onDrawFrame(final GL10 gl){
		final long t0=System.currentTimeMillis();
		camera.render(gl);
		world.update(dt);
		final long t1=System.currentTimeMillis();
		final long dt_ms=t1-t0;
		final long sleep=sleepall-dt_ms;
		if(sleep>0)
			try{Thread.sleep(sleep);}catch(InterruptedException ignored){}
	}
	public void onSurfaceChanged(final GL10 gl,final int width,final int height){
		camera.onSurfaceChanged(gl,width,height);
	}
	public boolean dispatchTouchEvent(final MotionEvent event){
		return camera.dispatchTouchEvent(event);
	}
}