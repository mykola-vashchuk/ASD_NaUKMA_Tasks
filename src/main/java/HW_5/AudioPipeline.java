package HW_5;

public class AudioPipeline extends PlaybackPipeline {
    private final Metrics metrics = new ConsoleMetrics();

    @Override
    protected void validate(MediaSource source) {
        if (!"audio".equals(source.type())) {
            metrics.recordError("Invalid media type. Expected audio for source: " + source.id());
            throw new IllegalArgumentException("Validation failed!");
        }
        metrics.record("Audio validation successful.");
    }

    @Override
    protected void decode(MediaSource source) {
        System.out.println("Decoding audio stream for: " + source.id());
    }
}
