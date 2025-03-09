package devices.myimplementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvenFailingPolicyTest {
    private EvenFailingPolicy failingPolicy;
    
    @BeforeEach
    public void setUp() {
        this.failingPolicy = new EvenFailingPolicy();
    }
    
    @Test
    public void testAttemptOnFirstCall() {
        // First call should succeed (odd attempt)
        assertTrue(this.failingPolicy.attemptOn());
    }
    
    @Test
    public void testAttemptOnSecondCall() {
        // First call
        this.failingPolicy.attemptOn();
        
        // Second call should fail (even attempt)
        assertFalse(this.failingPolicy.attemptOn());
    }
    
    @Test
    public void testAttemptOnSequence() {
        // Test a sequence of calls
        assertAll(
            () -> assertTrue(this.failingPolicy.attemptOn()), // 1st - succeeds
            () -> assertFalse(this.failingPolicy.attemptOn()), // 2nd - fails
            () -> assertTrue(this.failingPolicy.attemptOn()), // 3rd - succeeds
            () -> assertFalse(this.failingPolicy.attemptOn()), // 4th - fails
            () -> assertTrue(this.failingPolicy.attemptOn()) // 5th - succeeds
        );
    }
    
    @Test
    public void testReset() {
        // Call attemptOn a few times
        this.failingPolicy.attemptOn(); // 1st - succeeds
        this.failingPolicy.attemptOn(); // 2nd - fails
        
        // Reset the policy
        this.failingPolicy.reset();
        
        // Next call should succeed (as if it's the first call)
        assertTrue(this.failingPolicy.attemptOn());
    }
    
    @Test
    public void testPolicyName() {
        // Test the policy name
        assertEquals("even", this.failingPolicy.policyName());
    }
}