package otherPractice;

public class TripleInt {
	
	private int par1;
	private int par2;
	private int par3;
	
	public TripleInt(int par1, int par2, int par3) {
		super();
		this.par1 = par1;
		this.par2 = par2;
		this.par3 = par3;
	}

	public int getPar1() {
		return par1;
	}

	public void setPar1(int par1) {
		this.par1 = par1;
	}

	public int getPar2() {
		return par2;
	}

	public void setPar2(int par2) {
		this.par2 = par2;
	}

	public int getPar3() {
		return par3;
	}

	public void setPar3(int par3) {
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
			retVal = (t2.par1 == this.par1) && (t2.par2 == this.par2) && (t2.par3 == this.par3);
		}
		return retVal;
	}

}
