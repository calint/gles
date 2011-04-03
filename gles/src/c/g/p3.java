package c.g;
import java.io.Serializable;
public final class p3 implements Cloneable,Serializable{
	private static final long serialVersionUID=1L;
	public final static p3 axisx=new p3(1,0,0);
	public final static p3 axisy=new p3(0,1,0);
	public final static p3 axisz=new p3(0,0,1);
	public float x;
	public float y;
	public float z;
	public p3(){}
	public p3(final float s){
		x=y=z=s;
	}
	public p3(final float x0,final float y0,final float z0){
		x=x0;
		y=y0;
		z=z0;
	}
	public p3(final/*const*/p3 p){
		x=p.x;
		y=p.y;
		z=p.z;
	}
	public p3(final/*const*/p3 p1,final/*const*/p3 p2){
		x=p2.x-p1.x;
		y=p2.y-p1.y;
		z=p2.z-p1.z;
	}
	public void add(final float s){
		x+=s;
		y+=s;
		z+=s;
	}
	public p3 add(final/*const*/p3 p){
		x+=p.x;
		y+=p.y;
		z+=p.z;
		return this;
	}
	public p3 add(/*const*/final p3 p,final float dt){
		x+=p.x*dt;
		y+=p.y*dt;
		z+=p.z*dt;
		return this;
	}
	public p3 clone()/*const*/{
		return new p3(x,y,z);
	}
	public/*const*/float distance2_to(final/*const*/p3 p){
		float dx=p.x-x;
		float dy=p.y-y;
		float dz=p.z-z;
		return dx*dx+dy*dy+dz*dz;
	}
	public float dotprod(final p3 p)/*const*/{
		return p.x*x+p.y*y+p.z*z;
	}
	public boolean equals(/*const*/final p3 p)/*const*/{
		return (p.x==x)&&(p.y==y)&&(p.z==z);
	}
	public float magnitude()/*const*/{
		return (float)Math.sqrt(x*x+y*y+z*z);
	}
	public float magnitude2()/*const*/{
		return x*x+y*y+z*z;
	}
	public p3 negate(){
		x=-x;
		y=-y;
		z=-z;
		return this;
	}
	public p3 norm(){
		return normalize(1.0f);
	}
	public p3 normalize(final float length){
		float q=(float)Math.sqrt(x*x+y*y+z*z);
		if(q==0){
			zero();
			return this;
		}
		float t=length/q;
		x=t*x;
		y=t*y;
		z=t*z;
		return this;
	}
	public p3 rot_axis_x(final float a){
		float ca=(float)Math.sin(a);
		float sa=(float)Math.sin(a);
		float ny=ca*y-sa*z;
		float nz=sa*y+ca*z;
		y=ny;
		z=nz;
		return this;
	}
	public p3 rot_axis_y(final float a){
		float ca=(float)Math.cos(a);
		float sa=(float)Math.sin(a);
		float nx=ca*x+sa*z;
		float nz=-sa*x+ca*z;
		x=nx;
		z=nz;
		return this;
	}
	public p3 rot_axis_z(final float a){
		float ca=(float)Math.cos(a);
		float sa=(float)Math.sin(a);
		float nx=ca*x-sa*y;
		float ny=sa*x+ca*y;
		x=nx;
		y=ny;
		return this;
	}
	public p3 scale(final float s){
		x*=s;
		y*=s;
		z*=s;
		return this;
	}
	public p3 set(final float x0,final float y0,final float z0){
		x=x0;
		y=y0;
		z=z0;
		return this;
	}
	public p3 set(final p3 p){
		x=p.x;
		y=p.y;
		z=p.z;
		return this;
	}
	public String toString()/*const*/{
		return new String("|"+x+" "+y+" "+z+"|");
	}
	public final p3 vecto(/*const*/final p3 p){
		x=p.x-x;
		y=p.y-y;
		z=p.z-z;
		return this;
	}
	public p3 vecprod(final p3 v1,final p3 v2){
		x=v1.y*v2.z-v1.z*v2.y;
		y=v1.z*v2.x-v1.x*v2.z;
		z=v1.x*v2.y-v1.y*v2.x;
		return this;
	}
	public p3 x(final float x0){
		x=x0;
		return this;
	}
	public p3 y(final float y0){
		y=y0;
		return this;
	}
	public p3 z(final float z0){
		z=z0;
		return this;
	}
	public p3 zero(){
		x=y=z=0;
		return this;
	}
	public p3 abs(){
		if(x<0)
			x=-x;
		if(y<0)
			y=-y;
		if(z<0)
			z=-z;
		return this;
	}
	public static p3 o(){return new p3();}
	public static p3 o(final float x,final float y,final float z){return new p3(x,y,z);}
}
