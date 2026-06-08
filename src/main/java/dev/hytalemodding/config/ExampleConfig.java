package dev.hytalemodding.config;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class ExampleConfig {

    public static final BuilderCodec<ExampleConfig> CODEC = BuilderCodec.builder(ExampleConfig.class, ExampleConfig::new)
            .append(
                new KeyedCodec<>("EnableWelcomeMessage", Codec.BOOLEAN),
                (exConfig, aBoolean, extraInfo) -> exConfig.enabledWelcomeMessage = aBoolean,
                (exConfig, extraInfo) -> exConfig.enabledWelcomeMessage
            )
            .add()
            .build();

    private boolean enabledWelcomeMessage;

    private ExampleConfig() {}

    public boolean isEnabledWelcomeMessage() {
        return enabledWelcomeMessage;
    }
}
