package devices.myimplementation;

import devices.FailingPolicy;

/**
 * A failing policy that fails on every even attempt.
 */
public class EvenFailingPolicy implements FailingPolicy {
    private int attemptCount = 0;
    
    @Override
    public boolean attemptOn() {
        this.attemptCount++;
        return this.attemptCount % 2 != 0;
    }
    
    @Override
    public void reset() {
        this.attemptCount = 0;
    }
    
    @Override
    public String policyName() {
        return "even";
    }
}
