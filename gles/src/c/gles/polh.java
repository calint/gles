package c.gles;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class polh{
	private FloatBuffer vb;
	private ShortBuffer ib;
	private float vertices[]={-1.0f,1.0f,0.0f,-1.0f,-1.0f,0.0f,1.0f,-1.0f,0.0f,1.0f,1.0f,0.0f,};
	private short[] indices={0,1,2,0,2,3};

	public polh(){
		ByteBuffer bb=ByteBuffer.allocateDirect(vertices.length*4);
		bb.order(ByteOrder.nativeOrder());
		vb=bb.asFloatBuffer();
		vb.put(vertices);
		vb.position(0);
		bb=ByteBuffer.allocateDirect(indices.length*2);
		bb.order(ByteOrder.nativeOrder());
		ib=bb.asShortBuffer();
		ib.put(indices);
		ib.position(0);
	}
	public void draw(GL10 gl){
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3,GL10.GL_FLOAT,0,vb);
		gl.glDrawElements(GL10.GL_TRIANGLES,indices.length,GL10.GL_UNSIGNED_SHORT,ib);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
}
