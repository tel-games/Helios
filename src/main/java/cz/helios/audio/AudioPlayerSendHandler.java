package cz.helios.audio;

import net.dv8tion.jda.api.audio.AudioSendHandler;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;

public class AudioPlayerSendHandler implements AudioSendHandler {
    @Override
    public boolean canProvide() {
        return false;
    }

    @Nullable
    @Override
    public ByteBuffer provide20MsAudio() {
        return null;
    }

    @Override
    public boolean isOpus() {
        return true;
    }
}
