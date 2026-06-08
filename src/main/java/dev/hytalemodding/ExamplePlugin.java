package dev.hytalemodding;

import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;
import dev.hytalemodding.commands.ExampleCommand;
import dev.hytalemodding.config.ExampleConfig;
import dev.hytalemodding.events.ExampleEvent;

import javax.annotation.Nonnull;

public class ExamplePlugin extends JavaPlugin {

    private static Config<ExampleConfig> config = null;

    public ExamplePlugin(@Nonnull JavaPluginInit init) {
        super(init);
        config = this.withConfig("example_config", ExampleConfig.CODEC);
    }

    @Override
    protected void setup() {
        config.save();
        this.getCommandRegistry().registerCommand(new ExampleCommand("example", "An example command"));
        if (getConfig().get().isEnabledWelcomeMessage()) {
            this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, ExampleEvent::onPlayerReady);
        }
    }

    public static Config<ExampleConfig> getConfig() {
        return config;
    }
}