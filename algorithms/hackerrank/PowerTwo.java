package hackerrank;

public class PowerTwo {
	public boolean isPowerOfTwo(int n) {
        if(n<0) return false;
        if(n==1)
            return true;
        if(n%2 == 0){
            return isPowerOfTwo(n/2);
        }
        
       // if(Integer.bitCount(n) == 1)
       //     return true;
        return false;
    }
	public static void main(String[] args) {
		PowerTwo p = new PowerTwo();
		System.out.println(p.isPowerOfTwo(2048));

	}

}
