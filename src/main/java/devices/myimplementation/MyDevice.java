package devices.myimplementation;

import devices.Device;
import devices.FailingPolicy;

import java.util.Objects;

/**
 * My implementation of the Device interface starting from qwen's ReliableDevice implementation.
 */
public class MyDevice implements Device {
    private final FailingPolicy failingPolicy;
    private volatile boolean on;
    
    /**
     * Creates a new StandardDevice with a default FailingPolicy instance.
     */
    public MyDevice() {
        this(new EvenFailingPolicy());
    }
    
    /**
     * @param failingPolicy The policy to use when attempting to turn the device on.
     */
    public MyDevice(FailingPolicy failingPolicy) {
        if (failingPolicy == null) {
            throw new IllegalArgumentException("The FailingPolicy cannot be null.");
        }
        this.on = false;
        this.failingPolicy = Objects.requireNonNull(failingPolicy);
    }
    
    @Override
    public void on() throws IllegalStateException {
        if (this.on) {
            throw new IllegalStateException("Device is already on.");
        }
        this.on = true;
        
        try {
            this.failingPolicy.attemptOn();
        } catch (Exception e) {
            this.on = false;
            throw new IllegalStateException(e);
        }
    }
    
    @Override
    public void off() {
        if (!this.on) {
            throw new IllegalStateException("Device is already off.");
        }
        this.on = false;
    }
    
    @Override
    public boolean isOn() {
        return this.on;
    }
    
    @Override
    public void reset() {
        this.off();
        this.failingPolicy.reset();
    }
    
    @Override
    public String toString() {
        return "ReliableDevice{" +
                "on=" + this.on +
                '}';
    }
}
