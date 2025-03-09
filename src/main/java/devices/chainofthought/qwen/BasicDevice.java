package devices.chainofthought.qwen;

import devices.Device;

public class BasicDevice implements Device {
    
    private boolean on = false;
    
    @Override
    public void on() throws IllegalStateException {
        if (on) {
            throw new IllegalStateException("Device is already on.");
        }
        this.on = true;
    }
    
    @Override
    public void off() {
        if (!on) {
            throw new IllegalStateException("Device is already off.");
        }
        this.on = false;
    }
    
    @Override
    public boolean isOn() {
        return on;
    }
    
    @Override
    public void reset() {
        this.off();
    }
}
