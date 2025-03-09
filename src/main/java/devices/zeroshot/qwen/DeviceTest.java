package devices.zeroshot.qwen;

// (qwen also provided this main class, separated from the other class, to test the implementation):
// this test class stops its execution at line 17 because it throws an exception that is not caught
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
