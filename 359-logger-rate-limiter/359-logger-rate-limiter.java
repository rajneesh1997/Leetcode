class Logger {
    HashMap<String,Integer> map;
    public Logger() {
        map = new HashMap();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int time = map.get(message);
            if(timestamp < time)
                return false;
            else{
                map.put(message,timestamp + 10);
            }
        } else {
            map.put(message,timestamp + 10);
        }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */