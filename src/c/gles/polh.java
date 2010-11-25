package c.gles;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class polh{
	private FloatBuffer vb;
	private ShortBuffer ib;
//	private int nvertices;
	private int nindices;

	public polh(){}
	public void setvertices(float[] vertices){
//		nvertices=vertices.length;
		ByteBuffer bb=ByteBuffer.allocateDirect(vertices.length*4);
		bb.order(ByteOrder.nativeOrder());
		vb=bb.asFloatBuffer();
		vb.put(vertices);
		vb.position(0);
	}
	public void setindices(short[] indices){
		nindices=indices.length;
		ByteBuffer bb=ByteBuffer.allocateDirect(indices.length*2);
		bb.order(ByteOrder.nativeOrder());
		ib=bb.asShortBuffer();
		ib.put(indices);
		ib.position(0);
	}
	public void draw(GL10 gl){
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3,GL10.GL_FLOAT,0,vb);
		gl.glDrawElements(GL10.GL_TRIANGLES,nindices,GL10.GL_UNSIGNED_SHORT,ib);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
}
