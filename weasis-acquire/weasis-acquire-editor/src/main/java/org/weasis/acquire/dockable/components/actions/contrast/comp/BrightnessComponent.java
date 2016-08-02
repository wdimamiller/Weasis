package org.weasis.acquire.dockable.components.actions.contrast.comp;

import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.JLabel;

import org.weasis.acquire.dockable.components.actions.contrast.ContrastPanel;
import org.weasis.acquire.dockable.components.util.AbstractSliderComponent;

public class BrightnessComponent extends AbstractSliderComponent {
    private static final long serialVersionUID = -4387734543272450700L;
    
    public static final int BRIGHTNESS_VALUE = 0;
    public static final int BRIGHTNESS_MIN = -127;
    public static final int BRIGHTNESS_MAX = 127;
    
    private static final Hashtable<Integer, JLabel> labels = new Hashtable<>();
    
    static {
        labels.put(BRIGHTNESS_MIN, new JLabel("Low " + BRIGHTNESS_MIN));
        labels.put(BRIGHTNESS_VALUE, new JLabel(String.valueOf(BRIGHTNESS_VALUE)));
        labels.put(BRIGHTNESS_MAX, new JLabel("High " + BRIGHTNESS_MAX));
    }
    
    public BrightnessComponent(ContrastPanel panel) {
        super(panel, "Brightness");
    }

    @Override
    public int getDefaultValue() {
        return BRIGHTNESS_VALUE;
    }

    @Override
    public int getMin() {
        return BRIGHTNESS_MIN;
    }

    @Override
    public int getMax() {
        return BRIGHTNESS_MAX;
    }

    @Override
    public Dictionary<Integer, JLabel> getLabels() {
        return labels;
    }


}
