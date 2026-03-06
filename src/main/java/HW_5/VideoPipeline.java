package HW_5;

public class VideoPipeline extends PlaybackPipeline{
    Metrics metrics = new ConsoleMetrics();
    @Override
    protected void validate(MediaSource source) {
        if (!"video".equals(source.type())) {
            metrics.recordError("Invalid media type. Expected audio for source: " + source.id());
            throw new IllegalArgumentException("Validation failed!");
        }
        metrics.record("Video validation successful.");
    }

    @Override
    protected void decode(MediaSource source) {
        System.out.println("Decoding video stream for: " + source.id());
    }
}

