import java.util.*;

public class PrimeDivisorListImpl implements PrimeDivisorList {
	
	private List<Integer> list;
	
	public PrimeDivisorListImpl() {
		this.list = new ArrayList<Integer>();
	}

	public void add(Integer integer) {
		try {
			if(integer == null) {
				throw new NullPointerException("Cannot add null value");
			}
			if(!isPrime(integer)) {
				throw new IllegalArgumentException("Cannot add non prime number");
			}
			this.list.add(integer);
		} catch(NullPointerException ex) {
			System.out.println("Null integer values not accepted!");
			ex.printStackTrace();
		} catch(IllegalArgumentException ex) {
			System.out.println("Non prime numbers not accepted");
			ex.printStackTrace();
		}
	}
	
	public void remove(int index) {
		try {
			if(index < 0 || index >= this.list.size()) {
				throw new IndexOutOfBoundsException();
			}
			this.list.remove(index);
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Unable to access index specified");
			ex.printStackTrace();
		}
	}
	
	public String toString() {
		String output = "[ ";
		if(this.list != null && !this.list.isEmpty()) {
			this.list = mergesort(this.list);
			if(this.list.size() == 1) {
				output += this.list.get(0);
			} else {
				for(int index1 = 0; index1 < (this.list.size()); index1++) {
					int power = 1;
					int index2 = index1 + 1;
					while(index2 < this.list.size() && this.list.get(index1) == this.list.get(index2)) {
						power++;
						index2++;
					}
					if(power == 1) {
						output += this.list.get(index1);
					} else {
						output += this.list.get(index1) + "^" + power;
						index1 = index1 + (power - 1);
					}
					if(index1 < this.list.size() - 1) {
						output += " * ";
					}
				}
				int result = 1;
				for(int index = 0; index < this.list.size(); index++) {
					result = result * this.list.get(index);
				}
				output += " = " + result;
			}
		}
		output += " ]";
		return output;
	}
	
	public List<Integer> getList() {
		return this.list;
	}
	
	public boolean isPrime(Integer integer) {
		boolean output = true;
		if(integer <= 1) {
			output = false;
		} else {
			for(int divisor = 2; divisor <= (integer / 2); divisor++) {
				if ((integer % divisor) == 0) {
					output = false;
				}
			}
		}
		return output;
	}
	
	private List<Integer> mergesort(List<Integer> list) {
		if(list.size() == 0 || list.size() == 1) {
			return list;
		} else {
			int size = list.size();
			List<Integer> leftList = list.subList(0, (size / 2));
			List<Integer> rightList = list.subList((size / 2), size);
			
			List<Integer> sortedLeftList = mergesort(leftList);
			List<Integer> sortedRightList = mergesort(rightList);
				
			List<Integer> output = new ArrayList<Integer>();
			while(sortedLeftList.size() != 0 && sortedRightList.size() != 0) {
				if(sortedLeftList.get(0) <= sortedRightList.get(0)) {
					output.add(sortedLeftList.get(0));
					sortedLeftList = sortedLeftList.subList(1, sortedLeftList.size());
				} else {
					output.add(sortedRightList.get(0));
					sortedRightList = sortedRightList.subList(1, sortedRightList.size());
				}
			}
			if(sortedRightList.size() != 0) {
				output.addAll(sortedRightList);
			}
			if(sortedLeftList.size() != 0) {
				output.addAll(sortedLeftList);
			}
			return output;
		}
	}
}