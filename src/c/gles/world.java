package c.gles;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class world{
	private float vertices[]={-1.0f,1.0f,0.0f,-1.0f,-1.0f,0.0f,1.0f,-1.0f,0.0f,1.0f,1.0f,0.0f,};
	private short[] indices={0,1,2,0,2,3};
	private FloatBuffer vertexBuffer;
	private ShortBuffer indexBuffer;

	float agl_x,agl_y,agl_z;
	float pos_x,pos_y,pos_z=-4;

	public world(){
		ByteBuffer vbb=ByteBuffer.allocateDirect(vertices.length*4);
		vbb.order(ByteOrder.nativeOrder());
		vertexBuffer=vbb.asFloatBuffer();
		vertexBuffer.put(vertices);
		vertexBuffer.position(0);
		ByteBuffer ibb=ByteBuffer.allocateDirect(indices.length*2);
		ibb.order(ByteOrder.nativeOrder());
		indexBuffer=ibb.asShortBuffer();
		indexBuffer.put(indices);
		indexBuffer.position(0);
	}

	public void draw(GL10 gl){
		gl.glPushMatrix();
		gl.glTranslatef(pos_x,pos_y,pos_z);
		gl.glRotatef(agl_x,1.0f,0.0f,0.0f);
		gl.glRotatef(agl_y,0.0f,1.0f,0.0f);
		gl.glRotatef(agl_z,0.0f,0.0f,1.0f);

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3,GL10.GL_FLOAT,0,vertexBuffer);
		gl.glDrawElements(GL10.GL_TRIANGLES,indices.length,GL10.GL_UNSIGNED_SHORT,indexBuffer);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		gl.glPopMatrix();
	}
	public void update(float dt){
//		agl_x+=180.0f*dt;
//		agl_y+=180.0f*dt;
		agl_z+=180.0f*dt;
	}
}
