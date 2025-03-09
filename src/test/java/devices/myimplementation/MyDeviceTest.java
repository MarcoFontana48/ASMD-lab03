package devices.myimplementation;

import devices.Device;
import devices.FailingPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyDeviceTest {
    private FailingPolicy mockFailingPolicy;
    private Device myDevice;
    
    @BeforeEach
    public void setUp() {
        this.mockFailingPolicy = Mockito.mock(FailingPolicy.class);
        this.myDevice = new MyDevice(this.mockFailingPolicy);
    }
    
    @Test
    public void testConstructorWithNullFailingPolicy() {
        assertThrows(IllegalArgumentException.class, () -> new MyDevice(null));
    }
    
    @Test
    public void testDefaultConstructor() {
        MyDevice device = new MyDevice();
        assertAll(
            () -> assertNotNull(device),
            () -> assertFalse(device.isOn())
        );
    }
    
    @Test
    public void testOnSuccess() throws IllegalStateException {
        when(this.mockFailingPolicy.attemptOn()).thenReturn(true);
        this.myDevice.on();
        
        assertAll(
            () -> assertTrue(this.myDevice.isOn()),
            () -> verify(this.mockFailingPolicy, times(1)).attemptOn()
        );
    }
    
    @Test
    public void testOnFailure() {
        when(this.mockFailingPolicy.attemptOn()).thenThrow(new RuntimeException("Failed to turn on"));
        
        assertAll(
            () -> assertThrows(IllegalStateException.class, () -> this.myDevice.on()),
            () -> assertFalse(this.myDevice.isOn()),
            () -> verify(this.mockFailingPolicy, times(1)).attemptOn()
        );
    }
    
    @Test
    public void testOnWhenAlreadyOn() {
        when(this.mockFailingPolicy.attemptOn()).thenReturn(true);
        this.myDevice.on();
        
        assertAll(
            () -> assertThrows(IllegalStateException.class, () -> this.myDevice.on()),
            () -> verify(this.mockFailingPolicy, times(1)).attemptOn()
        );
    }
    
    @Test
    public void testOff() {
        when(this.mockFailingPolicy.attemptOn()).thenReturn(true);
        this.myDevice.on();
        this.myDevice.off();
        
        assertFalse(this.myDevice.isOn());
    }
    
    @Test
    public void testOffWhenAlreadyOff() {
        assertThrows(IllegalStateException.class, () -> this.myDevice.off());
    }
    
    @Test
    public void testReset() {
        when(this.mockFailingPolicy.attemptOn()).thenReturn(true);
        this.myDevice.on();
        this.myDevice.reset();
        
        assertAll(
            () -> assertFalse(this.myDevice.isOn()),
            () -> verify(this.mockFailingPolicy, times(1)).reset()
        );
    }
    
    @Test
    public void testResetWhenOff() {
        assertAll(
            () -> assertThrows(IllegalStateException.class, () -> this.myDevice.reset()),
            () -> verify(this.mockFailingPolicy, never()).reset()
        );
    }
    
    @Test
    public void testToString() {
        String actual = this.myDevice.toString();
        when(this.mockFailingPolicy.attemptOn()).thenReturn(true);
        this.myDevice.on();
        
        assertAll(
            () -> assertEquals("ReliableDevice{on=false}", actual),
            () -> assertEquals("ReliableDevice{on=true}", this.myDevice.toString())
        );
    }
}