class ParkingSystem {
    int[] ans = new int[]{0,0,0};
    public ParkingSystem(int big, int medium, int small) {
        ans[0] = big;
        ans[1] = medium;
        ans[2] = small;
    }
    
    public boolean addCar(int carType) {
        if(ans[carType-1] == 0)
            return false;
        ans[carType-1]--;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */