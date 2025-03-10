# Generate code with Ollama
In this project it is required to generate an implementation for a given Device interface, using different LLMs and
different strategies.

In order to do this, we will use the following tools:
- qwen
- smollm:360m
- smollm:135m

Questions will vary based on the techniques used to generate the code.

## Zero shot
Q: Provide an implementation for this java interface of a Device:
```java
interface Device {
    void on() throws IllegalStateException;
    void off();
    boolean isOn();
    void reset();
}
```

### smollm:135m
A:
```java
interface Device {
    int on(int state); // on() method
    void off(void state); // off() method

    void reset(); // reset() method
};
```

The generated code is incorrect, since it is not implementing the interface, but creating a new one.

### smollm:360m
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Device {
    private static final String TYPE_ON = "on";
    private static final String TYPE_OFF = "off";
    private static final String TYPE_RESET = "reset";
    
    public Device() {
        // Initialize the device instance
        try (BufferedReader reader = new BufferedReader(new InputStream.create(this.getInputStream()))
                .readLineAsBytes());
        System.out.println("Device initialized successfully.");
    }
}

public class DeviceImpl implements Device {
    private static final String TYPE_ON = "on";
    private static final String TYPE_OFF = "off";
    private static final String TYPE_RESET = "reset";
    
    public Device() {
        // Initialize the device instance
        try (BufferedReader reader = new BufferedReader(new InputStream.create(this.getInputStream()))
                .readLineAsBytes());
        System.out.println("Device initialized successfully.");
    }
    
    @Override
    public void on() {
        // Handle the device's state changes
        if (reader.hasMoreData()) {
            try (BufferedReader reader = new BufferedReader(new InputStream.create(this.getInputStream()))
                    .readLineAsBytes());
            System.out.println("Device is resetting.");
        } else {
            // Handle device state changes
            if (reader.hasMoreData()) {
                try (BufferedReader reader = new BufferedReader(new InputStream.create(this.getInputStream()))
                        .readLineAsBytes());
                System.out.println("Device is on.");
            } else {
                // Handle device state changes
                if (reader.hasMoreData()) {
                    try (BufferedReader reader = new BufferedReader(new InputStream.create(this.getInputStream()))
                            .readLineAsBytes());
                    System.out.println("Device is off.");
                } else {
                    // Handle device state changes
                    if (reader.hasMoreData()) {
                        try (BufferedReader reader = new BufferedReader(new
                                InputStream.create(this.getInputStream()))
                                .readLineAsBytes());
                        System.out.println("Device is resetting.");
                    } else {
                        // Handle device state changes
                        if (reader.hasMoreData()) {
                            try (BufferedReader reader = new BufferedReader(new
                                    InputStream.create(this.getInputStream()))
                                    .readLineAsBytes());
                            System.out.println("Device is off.");
                        } else {
                            // Handle device state changes
                            if (reader.hasMoreData()) {
                                try (BufferedReader reader = new BufferedReader(new
                                        InputStream.create(this.getInputStream()))
                                        .readLineAsBytes());
                                System.out.println("Device is on.");
                            } else {
                                // Handle device state changes
                                if (reader.hasMoreData()) {
                                    try (BufferedReader reader = new BufferedReader(new
                                            InputStream.create(this.getInputStream()))
                                            .readLineAsBytes());
                                    
                                    System.out.println("Device is off.");
                                } else {
                                    // Handle device state changes
                                    if (reader.hasMoreData()) {
                                        try (BufferedReader reader = new BufferedReader(new
                                                InputStream.create(this.getInputStream()))
                                                .readLineAsBytes());
                                        
                                        System.out.println("Device is resetting.");
                                    } else {
                                        // Handle device state changes
                                        if (reader.hasMoreData()) {
                                            try (BufferedReader reader = new BufferedReader(new
                                                    InputStream.create(this.getInputStream()))
                                                    .readLineAsBytes());
                                            
                                            System.out.println("Device is off.");
                                        } else {
                                            // Handle device state changes
                                            if (reader.hasMoreData()) {
                                                try (BufferedReader reader = new BufferedReader(new
                                                        InputStream.create(this.getInputStream()))
                                                        .readLineAsBytes());
                                                
                                                System.out.println("Device is on.");
                                            } else {
                                                // Handle device state changes
                                                if (reader.hasMoreData()) {
                                                    try (BufferedReader reader = new BufferedReader(new
                                                            InputStream.create(this.getInputStream()))
                                                            .readLineAsBytes());
                                                    
                                                    System.out.println("Device is off.");
                                                } else {
                                                    // Handle device state changes
                                                    if (reader.hasMoreData()) {
                                                        try (BufferedReader reader = new BufferedReader(new
                                                                InputStream.create(this.getInputStream()))
                                                                .readLineAsBytes());
                                                        
                                                        System.out.println("Device is resetting.");
                                                    } else {
                                                        // Handle device state changes
                                                        if (reader.hasMoreData()) {
                                                            try (BufferedReader reader = new BufferedReader(new
                                                                    InputStream.create(this.getInputStream()))
                                                                    .readLineAsBytes());
                                                            
                                                            System.out.println("Device is off.");
                                                        } else {
                                                            // Handle device state changes
                                                            if (reader.hasMoreData()) {
                                                                try (BufferedReader reader = new BufferedReader(new
                                                                        InputStream.create(this.getInputStream()))
                                                                        .readLineAsBytes());
                                                                
                                                                System.out.println("Device is on.");
                                                            } else {
                                                                // Handle device state changes
                                                                if (reader.hasMoreData()) {
                                                                    try (BufferedReader reader = new BufferedReader(new
                                                                            InputStream.create(this.getInputStream()))
                                                                            .readLineAsBytes());
                                                                    
                                                                    System.out.println("Device is off.");
                                                                } else {
                                                                    // Handle device state changes
                                                                    if (reader.hasMoreData()) {
                                                                        try (BufferedReader reader = new BufferedReader(new
                                                                                InputStream.create(this.getInputStream()))
                                                                                .readLineAsBytes());
                                                                        
                                                                        System.out.println("Device is resetting.");
                                                                    } else {
                                                                        // Handle device state changes
                                                                        if (reader.hasMoreData()) {
                                                                            try (BufferedReader reader = new BufferedReader(new
                                                                                    InputStream.create(this.getInputStream()))
                                                                                    .readLineAs
```

The generated code is incorrect, i eventually had to manually stop the generation, since it was going on forever.

### qwen
A:
```java
public class LightSwitch implements Device {
    private boolean isOn;

    public LightSwitch() {
        this.isOn = false;
    }

    @Override
    public void on() throws IllegalStateException {
        if (isOn) {
            throw new IllegalStateException("Device is already on.");
        }
        isOn = true;
    }

    @Override
    public void off() {
        isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void reset() {
        isOn = false;
    }
}
```
```java
public class DeviceTest {
    public static void main(String[] args) {
        LightSwitch lightSwitch = new LightSwitch();

        System.out.println("Initial State: " + lightSwitch.isOn()); // Should print false

        try {
            lightSwitch.on(); // Attempt to turn on device when already on
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // Expected message: Device is already on.
        }

        lightSwitch.on();
        System.out.println("Device is On: " + lightSwitch.isOn()); // Should print true

        try {
            lightSwitch.off(); // Attempt to turn off device when already off
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // Expected message: Device is already off.
        }

        lightSwitch.off();
        System.out.println("Device is Off: " + !lightSwitch.isOn()); // Should print true

        lightSwitch.reset(); // Reset the device to its initial state
        System.out.println("After reset, Device is On: " + lightSwitch.isOn()); // Should print false
    }
}
```

The generated code compiles, it also produced a test class that tests the implementation.
The test class however throws an uncaught exception and cannot reach the end of the test.
Also, it is not a good test class since it's only printing the results, it should use assertions to check the results.

## Few shot
Q: Provide a single implementation for this java interface of a Device: "public interface Device {
    void on() throws IllegalStateException;
    void off();
    boolean isOn();
    void reset();
    }
"
Those are two example implementations already available that you can use as reference: "public class StandardDevice implements Device {
private FailingPolicy failingPolicy;
private boolean on = false;

    public StandardDevice(FailingPolicy failingPolicy) {
        this.failingPolicy = Objects.requireNonNull(failingPolicy);
    }
    //...

    @Override
    public void on() throws IllegalStateException {
        if (!this.failingPolicy.attemptOn()){
            throw new IllegalStateException();
        }
        this.on = true;
    }

    @Override
    public void off() {
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
        return "StandardDevice{" +
                "policy=" + failingPolicy.policyName() +
                ", on=" + on +
                '}';
    }
}
"

"public class LightSwitch implements Device {
private boolean isOn;

    public LightSwitch() {
        this.isOn = false;
    }
    
    @Override
    public void on() throws IllegalStateException {
        if (isOn) {
            throw new IllegalStateException("Device is already on.");
        }
        isOn = true;
    }
    
    @Override
    public void off() {
        isOn = false;
    }
    
    @Override
    public boolean isOn() {
        return isOn;
    }
    
    @Override
    public void reset() {
        isOn = false;
    }
}
"

### smollm:135m
A:
```java
interface LightSwitch {
    boolean on();
    void off();
    boolean isOn();
    void reset();
};
```

The generated code is incorrect, since it is not implementing the interface, but creating a new one.

### smollm:360m
A:
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class DeviceImpl implements Device {
    private static final String FailingPolicy = "FailingPolicy";

    public Device() {
        this.failingPolicy = new FailingPolicy();
    }

    @Override
    public void on() throws IllegalStateException {
        if (!this.isOn()) {
            throw new IllegalStateException("Device is already off.");
        }

        // Handle device state changes
        if (this.isOn) {
            this.on = true;
            this.failingPolicy.reset();
        } else {
            this.on = false;
            this.failingPolicy.reset();
        }
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }
}
```

The generated code is incorrect, since it is not implementing all the methods of the interface and the methods 'on' is 
not implemented correctly.

### qwen
A:
```java
public class ReliableDevice implements Device {

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
        if (on) {
            throw new IllegalStateException("Device is already on.");
        }
        on = true;

        try {
            failingPolicy.attemptOn();
        } catch (Exception e) {
            on = false;
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void off() {
        if (!on) {
            throw new IllegalStateException("Device is already off.");
        }
        on = false;
    }

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void reset() {
        off();
        failingPolicy.reset();
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
                "on=" + on +
                '}';
    }
}
```

the generated code is much better than the previous zero-shot attempt, but it is still not correct, it does not 
have a field for the FailingPolicy so it will not compile.

## Chain of thought
Q: Provide a single implementation for this java interface of a Device, solve this step-by-step, implementing a method at the time: "public interface Device {
    void on() throws IllegalStateException;
    void off();
    boolean isOn();
    void reset();
    }
"

### smollm:135m
A: 
```java
interface LightSwitch {
    boolean on();
    void off();
    boolean isOn();
    void reset();
};
```

The generated code is incorrect, since it is not implementing the interface, but creating a new one.

### smollm:360m
A:
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class DeviceImpl implements Device {
    private static final String FailingPolicy = "FailingPolicy";

    public Device() {
        this.failingPolicy = new FailingPolicy();
    }

    @Override
    public void on() throws IllegalStateException {
        if (this.isOn()) {
            throw new IllegalStateException("Device is already off.");
        }

        // Handle device state changes
        if (this.isOn()) {
            this.on = true;
            this.failingPolicy.reset();
        } else {
            this.on = false;
            this.failingPolicy.reset();
        }
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }
}
```

### qwen
```java
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
```

The generated code is basically the same as the one generated in the zero-shot attempt.

## Conclusion
The best result was obtained using the few-shot approach with qwen, but it still needs some improvements and human
intervention to fix errors.

## Test generation
A custom implementation of the Device interface named 'MyDevice' was produced starting from the qwen implementation.
The test classes were generated to test both MyDevice class and EvenFailingPolicy class using qwen:

Q: considering java, junit and mockito i need you to provide unit and integration tests for those two classes 
" * java code of both classes * "

```java
package devices.myimplementation;

import devices.FailingPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyDeviceUnitTest {
    
    private FailingPolicy mockFailingPolicy;
    private MyDevice myDevice;
    
    @BeforeEach
    public void setUp() {
        // Create a mock for the FailingPolicy
        mockFailingPolicy = Mockito.mock(FailingPolicy.class);
        // Create a device with the mock policy
        myDevice = new MyDevice(mockFailingPolicy);
    }
    
    @Test
    public void testConstructorWithNullFailingPolicy() {
        // Test that passing null to constructor throws IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new MyDevice(null);
        });
        
        assertEquals("The FailingPolicy cannot be null.", exception.getMessage());
    }
    
    @Test
    public void testDefaultConstructor() {
        // Test that default constructor creates a device with EvenFailingPolicy
        MyDevice device = new MyDevice();
        assertNotNull(device);
        assertFalse(device.isOn());
    }
    
    @Test
    public void testOnSuccess() throws IllegalStateException {
        // Configure mock to return true (success) when attemptOn is called
        when(mockFailingPolicy.attemptOn()).thenReturn(true);
        
        // Turn the device on
        myDevice.on();
        
        // Verify the device is on
        assertTrue(myDevice.isOn());
        // Verify attemptOn was called exactly once
        verify(mockFailingPolicy, times(1)).attemptOn();
    }
    
    @Test
    public void testOnFailure() {
        // Configure mock to throw an exception when attemptOn is called
        when(mockFailingPolicy.attemptOn()).thenThrow(new RuntimeException("Failed to turn on"));
        
        // Attempt to turn the device on, should throw IllegalStateException
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            myDevice.on();
        });
        
        // Verify the device remains off
        assertFalse(myDevice.isOn());
        // Verify attemptOn was called exactly once
        verify(mockFailingPolicy, times(1)).attemptOn();
        // Verify the exception has the correct cause
        assertEquals("Failed to turn on", exception.getCause().getMessage());
    }
    
    @Test
    public void testOnWhenAlreadyOn() {
        // Configure mock to return true (success) when attemptOn is called
        when(mockFailingPolicy.attemptOn()).thenReturn(true);
        
        // Turn the device on
        myDevice.on();
        
        // Try to turn it on again, should throw IllegalStateException
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            myDevice.on();
        });
        
        // Verify the exception has the correct message
        assertEquals("Device is already on.", exception.getMessage());
        // Verify attemptOn was called exactly once (from the first call)
        verify(mockFailingPolicy, times(1)).attemptOn();
    }
    
    @Test
    public void testOff() {
        // Configure mock to return true (success) when attemptOn is called
        when(mockFailingPolicy.attemptOn()).thenReturn(true);
        
        // Turn the device on first
        myDevice.on();
        
        // Then turn it off
        myDevice.off();
        
        // Verify the device is off
        assertFalse(myDevice.isOn());
    }
    
    @Test
    public void testOffWhenAlreadyOff() {
        // Device is already off after initialization
        
        // Try to turn it off, should throw IllegalStateException
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            myDevice.off();
        });
        
        // Verify the exception has the correct message
        assertEquals("Device is already off.", exception.getMessage());
    }
    
    @Test
    public void testReset() {
        // Configure mock to return true (success) when attemptOn is called
        when(mockFailingPolicy.attemptOn()).thenReturn(true);
        
        // Turn the device on
        myDevice.on();
        
        // Reset the device
        myDevice.reset();
        
        // Verify the device is off
        assertFalse(myDevice.isOn());
        // Verify reset was called on the failing policy
        verify(mockFailingPolicy, times(1)).reset();
    }
    
    @Test
    public void testResetWhenOff() {
        // Device is already off after initialization
        
        // Attempt to reset the device, should throw IllegalStateException because off() is called internally
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            myDevice.reset();
        });
        
        // Verify the exception has the correct message
        assertEquals("Device is already off.", exception.getMessage());
        // Verify reset was not called on the failing policy
        verify(mockFailingPolicy, never()).reset();
    }
    
    @Test
    public void testToString() {
        // Test the toString method
        assertEquals("ReliableDevice{on=false}", myDevice.toString());
        
        // Configure mock to return true (success) when attemptOn is called
        when(mockFailingPolicy.attemptOn()).thenReturn(true);
        
        // Turn the device on
        myDevice.on();
        
        // Test toString again
        assertEquals("ReliableDevice{on=true}", myDevice.toString());
    }
}

public class EvenFailingPolicyUnitTest {
    
    private EvenFailingPolicy failingPolicy;
    
    @BeforeEach
    public void setUp() {
        failingPolicy = new EvenFailingPolicy();
    }
    
    @Test
    public void testAttemptOnFirstCall() {
        // First call should succeed (odd attempt)
        assertTrue(failingPolicy.attemptOn());
    }
    
    @Test
    public void testAttemptOnSecondCall() {
        // First call
        failingPolicy.attemptOn();
        
        // Second call should fail (even attempt)
        assertFalse(failingPolicy.attemptOn());
    }
    
    @Test
    public void testAttemptOnSequence() {
        // Test a sequence of calls
        assertTrue(failingPolicy.attemptOn()); // 1st - succeeds
        assertFalse(failingPolicy.attemptOn()); // 2nd - fails
        assertTrue(failingPolicy.attemptOn()); // 3rd - succeeds
        assertFalse(failingPolicy.attemptOn()); // 4th - fails
        assertTrue(failingPolicy.attemptOn()); // 5th - succeeds
    }
    
    @Test
    public void testReset() {
        // Call attemptOn a few times
        failingPolicy.attemptOn(); // 1st - succeeds
        failingPolicy.attemptOn(); // 2nd - fails
        
        // Reset the policy
        failingPolicy.reset();
        
        // Next call should succeed (as if it's the first call)
        assertTrue(failingPolicy.attemptOn());
    }
    
    @Test
    public void testPolicyName() {
        // Test the policy name
        assertEquals("even", failingPolicy.policyName());
    }
}
```

The generated tests are good, covering all the methods implemented but they're not using assertions like 'assertAll' to 
group the assertions together, so a small human intervention is needed to improve the tests.

## Conclusions
The implementations for the Device interface provided vary based on the approach and model used:
- smaller models do not perform well independently of the approach used
- bigger models perform different based on the approach, where in this case the 'few shot' approach seemed to be the one that produces the best implementations.

A custom implementation 'MyDevice' was produced starting from the result obtained with the 'few shot' approach using qwen's response.

# Task \#2 was developed on a different repository, check this link: https://github.com/MarcoFontana48/ASMD-lab03-task02
