

import java.io.*;

public class Bairstow {
  private double[] a;
  private double[] b;
  private double[] c;
  private int n;
  private double error;
  private double epsilon;
  private String roots;

  public Bairstow(double[] arr, int magnitude, double epsilon)
  {
    a = new double[arr.length];
    for(int i=0; i<arr.length;i++) {
    	a[i]=arr[i];
    }
    b = new double[a.length];
    c = new double[a.length];
    n=magnitude;
    this.error=1;
    this.epsilon=epsilon;
  }

  public void solve()
  {
	this.roots="Multiples of polynomial" +"\n";
	for(int i=0; i<a.length; i++) {
		this.roots+=(a[i]+" ");
	}
	this.roots+="\n"+"Real Roots"+"\n";
    int i, j;
    double r1, r2, du, dv, u, v, r, dr;
    double sq, det, nu, nv;
    while (n > 3) {
      u = 0;
      v = 0;
      c[n] = b[n] = a[n];

      while (this.error > this.epsilon) {
        b[n-1] = a[n-1] + u * b[n];
        c[n-1] = b[n-1] + u * c[n];

        for (i = n - 2; i > 0; i--) {
          b[i] = a[i] + u * b[i+1] + v * b[i+2];
          c[i] = b[i] + u * c[i+1] + v * c[i+2];
        }

        b[0] = a[0] + u * b[1] + v * b[2];

        det = (c[2] * c[2]) - c[1] * c[3];

        nu = b[0] * c[3] - b[1] * c[2];
        nv = b[1] * c[1] - b[0] * c[2];
        
        if (det == 0) {
          du = dv = 1;
        } else {
          du = nu / det;
          dv = nv / det;
        }
        
        u += du;
        v += dv;

        this.error = Math.sqrt(du * du + dv * dv);
      }
      this.roots+="1" + " " + (-1*u) +" "+(-1*v)+"\n";
      for(int t=n-2;t>=0;t--){
        this.roots+=b[t]+" "+"\n";
      }
      this.roots+="\n";
      sq = u * u + 4 * v;

      if (sq < 0) {
        r1 = u/2;
        r2 = Math.sqrt(-sq)/2;

        this.roots+="Imaginary roots"+"\n";
        this.roots+=r1 + " + " + r2 + "i"+"\n";
        this.roots+=r1 + " - " + r2 + "i"+"\n";
      } else {
        r1 = u/2 + Math.sqrt(sq)/2;
        r2 = u/2 - Math.sqrt(sq)/2;

        this.roots+=r1+"\n";
        this.roots+=r2+"\n";
      }

      n -= 2;

      for (i = 0; i < n + 1; i++)
        a[i] = b[i+2];
    }
    
    if (n == 3) {
      r = 0;
      this.error = 1;
      b[n] = a[n];

      while (this.error > this.epsilon) {
        b[2] = a[2] + r * b[3];
        b[1] = a[1] + r * b[2];
        b[0] = a[0] + r * b[1];

        double d = a[1] + (2 * a[2] * r) + (3 * a[3] * r * r);

        if (d == 0)
          dr = 1;
        else
          dr = -b[0] / d;

        r -= dr;
        this.error = Math.abs(dr);
      }

      this.roots+=r+"\n";
      n--;

      for (i = 0; i < n + 1; i++)
        a[i] = b[i + 1];
    }


    if (n == 2) {
      u = -a[1] / a[2];
      v = -a[0] / a[2];
      sq = u * u + 4 * v;

      if (sq < 0) {
        r1 = u/2;
        r2 = Math.sqrt(-sq)/2;

        this.roots+="Imaginary roots"+"\n";
        this.roots+=r1 + " + " + r2 + "i"+"\n";
        this.roots+=r1 + " - " + r2 + "i"+"\n";
      } else {
        r1 = u/2 + Math.sqrt(sq)/2;
        r2 = u/2 - Math.sqrt(sq)/2;

        this.roots+=r1;
        this.roots+=r2;
      }
    } else if (n == 1) {
      this.roots+= -a[0] / a[1]+"\n";
    }
    
    System.out.println(roots);
  }


public String getRoots() {
	return roots;
}
  
}
