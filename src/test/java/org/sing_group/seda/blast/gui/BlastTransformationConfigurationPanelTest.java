package org.sing_group.seda.blast.gui;

import java.awt.Component;

import org.sing_group.gc4s.visualization.VisualizationUtils;
import org.sing_group.seda.plugin.spi.TransformationChangeEvent;
import org.sing_group.seda.plugin.spi.TransformationChangeListener;

public class BlastTransformationConfigurationPanelTest {
  
  public static void main(String[] args) {
    VisualizationUtils.showComponent(getBlastTransformationConfigurationPanel());
  }

  private static Component getBlastTransformationConfigurationPanel() {
    BlastTransformationConfigurationPanel panel = new BlastTransformationConfigurationPanel();
    panel.getModel().addTransformationChangeListener(new TransformationChangeListener() {
      
      @Override
      public void onTransformationChange(TransformationChangeEvent event) {
        System.err.println("Transformation changed: " + event.getType() + ". Is valid configuration? " + panel.getModel().isValidTransformation());
      }
    });
    return panel;
  }
}
