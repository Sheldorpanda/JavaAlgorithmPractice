package otherPractice;

public class TripleDouble {
	
	private double par1;
	private double par2;
	private double par3;
	
	public TripleDouble(double par1, double par2, double par3) {
		super();
		this.par1 = par1;
		this.par2 = par2;
		this.par3 = par3;
	}

	public double getPar1() {
		return par1;
	}

	public void setPar1(double par1) {
		this.par1 = par1;
	}

	public double getPar2() {
		return par2;
	}

	public void setPar2(double par2) {
		this.par2 = par2;
	}

	public double getPar3() {
		return par3;
	}

	public void setPar3(double par3) {
		this.par3 = par3;
	}
	
	@Override
	public String toString() {
		return "( " + this.par1 + ", " + this.par2 + ", " + this.par3 + " )";
	}
	
	@Override
	public boolean equals(Object o) {
		boolean retVal = false;
		if (o instanceof TripleInt) {
			TripleInt t2 = (TripleInt) o;
			retVal = (t2.getPar1() == this.par1) && (t2.getPar2() == this.par2) && (t2.getPar3() == this.par3);
		}
		return retVal;
	}
	

}
