package c.gles;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
public class polh{
	private FloatBuffer vb;
	private ShortBuffer ib;
	private int nindices;
	private p3 color;
	private FloatBuffer cb;
	public void vertices(final float[]vertices){
		final ByteBuffer bb=ByteBuffer.allocateDirect(vertices.length*4);
		bb.order(ByteOrder.nativeOrder());
		vb=bb.asFloatBuffer();
		vb.put(vertices);
		vb.position(0);
	}
	public void indices(final short[]indices){
		nindices=indices.length;
		final ByteBuffer bb=ByteBuffer.allocateDirect(nindices*2);
		bb.order(ByteOrder.nativeOrder());
		ib=bb.asShortBuffer();
		ib.put(indices);
		ib.position(0);
	}
	public void color(final p3 color){
		this.color=color;
	}
	public void colors(final float[]colors){
		final ByteBuffer bb=ByteBuffer.allocateDirect(colors.length*4);
		bb.order(ByteOrder.nativeOrder());
		cb=bb.asFloatBuffer();
		cb.put(colors);
		cb.position(0);
	}
	public void draw(final GL10 gl){
		if(color!=null){
			gl.glColor4f(color.x,color.y,color.z,1f);
		}
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3,GL10.GL_FLOAT,0,vb);
		if(cb!=null){
			gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
			gl.glColorPointer(4,GL10.GL_FLOAT,0,cb);
		}
		gl.glDrawElements(GL10.GL_TRIANGLES,nindices,GL10.GL_UNSIGNED_SHORT,ib);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		if(cb!=null){
			gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		}
	}
}
