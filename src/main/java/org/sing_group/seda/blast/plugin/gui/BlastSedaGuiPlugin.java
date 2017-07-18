package org.sing_group.seda.blast.plugin.gui;

import java.awt.Component;

import org.sing_group.seda.blast.gui.BlastTransformationConfigurationPanel;
import org.sing_group.seda.core.SedaContext;
import org.sing_group.seda.plugin.core.gui.AbstractSedaGuiPlugin;
import org.sing_group.seda.plugin.spi.TransformationProvider;

public class BlastSedaGuiPlugin extends AbstractSedaGuiPlugin {
  private BlastTransformationConfigurationPanel blastConfigurationPanel = new BlastTransformationConfigurationPanel();

  @Override
  public String getName() {
    return "Blast";
  }

  @Override
  public Component getEditor() {
    return this.blastConfigurationPanel;
  }

  @Override
  public TransformationProvider getTransformation() {
    return this.blastConfigurationPanel.getModel();
  }

  @Override
  public void setSedaContext(SedaContext context) {
    super.setSedaContext(context);
    this.blastConfigurationPanel.setSedaContext(context);
  }
}
