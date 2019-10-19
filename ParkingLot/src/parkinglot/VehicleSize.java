package parkinglot;

public enum VehicleSize {
	Compact(1), Large(2);
	
	private final int size;
	private VehicleSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
}
