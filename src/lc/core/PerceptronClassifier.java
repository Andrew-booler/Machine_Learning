package lc.core;

import math.util.VectorOps;

public class PerceptronClassifier extends LinearClassifier {
	
	public PerceptronClassifier(int ninputs) {
		super(ninputs);
	}
	
	/**
	 * A PerceptronClassifier uses the perceptron learning rule
	 * (AIMA Eq. 18.7): w_i \leftarrow w_i+\alpha(y-h_w(x)) \times x_i 
	 */
	public void update(double[] x, double y, double alpha) {
	    // Must be implemented by you
		for(int i=0;i<this.weights.length;i++) {
			this.weights[i]+=alpha*(y-threshold(this.dotProduct(this.weights, x)))*x[i];
		}
	}
	
	public double dotProduct(double[] a, double[] b) {
		if(a.length!=b.length) {
			return 0.0;
		}
		double res = 0.0;
		for(int i = 0; i < a.length; i++) {
			res+=a[i]*b[i];
		}
		return res;
	}
	/**
	 * A PerceptronClassifier uses a hard 0/1 threshold.
	 */
	public double threshold(double z) {
	    // Must be implemented by you
		if(z>0) {
			return 1.0;
		}else {
			return 0.0;
		}
	}
	
}
