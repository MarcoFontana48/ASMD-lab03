package devices.fewshot.qwen;

import devices.Device;

import java.util.Objects;

public class ReliableDevice implements Device {
    private final FailingPolicy failingPolicy;
    private volatile boolean on;
    
    /**
     * Creates a new StandardDevice with a default FailingPolicy instance.
     */
    public ReliableDevice() {
        this(new DefaultFailingPolicy());
    }
    
    /**
     * @param failingPolicy The policy to use when attempting to turn the device on.
     */
    public ReliableDevice(FailingPolicy failingPolicy) {
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
    
    private static class DefaultFailingPolicy implements FailingPolicy {
        
        @Override
        public boolean attemptOn() throws Exception {
            Thread.sleep(100);
            // Simulate a real policy which may throw an exception.
            return true;
        }
        
        @Override
        public void reset() {
            // No-op for simplicity.
        }
    }
    
    
    private interface FailingPolicy {
        
        /**
         * Indicates whether the device can be turned on.
         *
         * @return true if the device can be turned on, false otherwise.
         * @throws Exception may throw an exception to simulate failure conditions.
         */
        boolean attemptOn() throws Exception;
        
        /**
         * Resets any resources used by this policy.
         */
        void reset();
    }
    
    @Override
    public String toString() {
        return "ReliableDevice{" +
                "on=" + this.on +
                '}';
    }
}