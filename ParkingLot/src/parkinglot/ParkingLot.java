package parkinglot;
import java.util.*;

public class ParkingLot {
	private final Level[] levels;
	// initialize the parking lot
	ParkingLot(int numOfLevels, int spotsPerLevel) {
		levels = new Level[numOfLevels];
		for (int i = 0; i < numOfLevels; i++) {
			levels[i] = new Level(spotsPerLevel);
		}
	}
	// check whether the parking lot has any available spot 
	public boolean hasSpot(Vehicle v) {
		for (Level l : levels) {
			if (l.hasSpot(v)) {
				return true;
			}
		}
		return false;
	}
	
	// park the vehicle v
    public boolean park(Vehicle v) {
		for (Level l : levels) {
			if (l.park(v)) {
				return true;
			}
		}
		return false;
	}
    
    // let vehicle v leave the parking lot
	public boolean leave(Vehicle v) {
		for (Level l : levels) {
			if (l.leave(v)) {
				return true;
			}
		}
		return false;
	}
}

class Level {
	private final List<ParkingSpot> spots;
	
	Level(int numOfSpots) {
		List<ParkingSpot> list = new ArrayList<>(numOfSpots);
		int i = 0;
		for (; i < numOfSpots / 2; i++) {
			list.add(new ParkingSpot(VehicleSize.Compact));
		}
		for (; i < numOfSpots; i++) {
			list.add(new ParkingSpot(VehicleSize.Large));
		}
		spots = Collections.unmodifiableList(list);
	}
	
	// check whether there is empty spot for v
    boolean hasSpot(Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.fit(v)) {
				return true;
			}
		}
		return false;
	}
    
    // park v
    boolean park(Vehicle v) {
    	for (ParkingSpot s : spots) {
    		if (s.fit(v)) {
    			s.park(v);
    			return true;
    		}
    	}
    	return false;
    }
    
    // v leaves
    boolean leave(Vehicle v) {
    	for (ParkingSpot s : spots) {
    		if (s.getVehicle() == v) {
    			s.leave();
    			return true;
    		}
    	}
    	return false;
    }
    
}

class ParkingSpot {
	private final VehicleSize size;
	private Vehicle currentVehicle;
	
	ParkingSpot (VehicleSize size) {
		this.size = size;
	}
	
	// check whether vehicle v can fit the parking spot
	boolean fit(Vehicle v) { // check size and availability
		return currentVehicle == null && size.getSize() >= v.getSize().getSize();
	}
	
	// update current vehicle to record whether this parking spot is occupied or not
	void park(Vehicle v) {
		currentVehicle = v;
	}
	
	void leave() {
		currentVehicle = null;
	}
	
	Vehicle getVehicle() {
		return currentVehicle;
	}
}













