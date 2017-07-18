package org.sing_group.seda.blast.plugin;

import java.util.stream.Stream;

import org.sing_group.seda.blast.plugin.gui.BlastSedaGuiPlugin;
import org.sing_group.seda.plugin.spi.SedaCliPlugin;
import org.sing_group.seda.plugin.spi.SedaGuiPlugin;
import org.sing_group.seda.plugin.spi.SedaPluginFactory;

public class BlastSedaPluginFactory implements SedaPluginFactory {

  @Override
  public Stream<SedaGuiPlugin> getGuiPlugins() {
    return Stream.of((new BlastSedaGuiPlugin()));
  }

  @Override
  public Stream<SedaCliPlugin> getCliPlugins() {
    return null;
  }
}
