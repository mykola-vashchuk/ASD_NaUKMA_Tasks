package HW_5;

public abstract class PlaybackPipeline {
    public final void play(MediaSource source){
        validate(source);
        decode(source);
        render(source);
        finish(source);
    }

    protected abstract void validate(MediaSource source);
    protected abstract void decode(MediaSource source);

    protected void render(MediaSource source){
        System.out.println("Rendering from: "+ source);
    }
    protected void finish(MediaSource source){
        System.out.println("Finishing for: "+ source);
    }
}

