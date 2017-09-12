package model;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Color
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int r;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int g;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int b;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int a;

	private int rgba;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Color(int r, int g, int b, int a){
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void setRed(int r) {
		if(r > 255) {
			r = 255;
		} else if(r < 0) {
			r = 0;
		}
		this.r = r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void setBlue(int b) {
		if(b > 255) {
			b = 255;
		} else if(b < 0) {
			b = 0;
		}
		this.b = b;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void setGreen(int g) {
		if(g > 255) {
			g = 255;
		} else if(g < 0) {
			g = 0;
		}
		this.g = g;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void setRGBA(int rgba) {
		this.rgba = rgba;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int getRed() {
		return r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int getGreen() {
		return g;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int getBlue() {
		return b;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int getAlpha() {
		return a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int getRGBA() {
		return rgba;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String toString() {
		// TODO implement me
		return "red:" + r + ", green:" + g + ", blue:" + b + ", alpha:" + a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public boolean equals(Color color) {
		return this.toString().equals(color.toString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Color brighter() {
		int r = getRed();
		int g = getGreen();
		int b = getBlue();

		double factor = 0.7;

		int i = (int) (1.0/(1.0-factor));
		
		if(r == 0 && g == 0 && b == 0) {
			return new Color(i, i, i, getAlpha());
		}

		if(r > 0 && r < i) r = i;
		if(g > 0 && g < i) g = i;
		if(b > 0 && b < i) b = i;

		return new Color(Math.min((int)(r/factor), 255),
						 Math.min((int)(g/factor), 255), 
						 Math.min((int)(b/factor), 255),
						 getAlpha());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Color darker() {
		double factor = 0.7;

		return new Color(Math.max((int)(getRed()   * factor), 0),
						 Math.max((int)(getGreen() * factor), 0),
						 Math.max((int)(getBlue()  * factor), 0),
						 getAlpha());
	}

}

