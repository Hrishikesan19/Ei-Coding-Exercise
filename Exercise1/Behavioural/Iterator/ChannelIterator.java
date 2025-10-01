import java.util.List;

public interface ChannelIterator {
    boolean hasNext();
    Channel next();
}

class ChannelIteratorImpl implements ChannelIterator {
    private List<Channel> channels;
    private int position = 0;

    public ChannelIteratorImpl(List<Channel> channels) {
        this.channels = channels;
    }

    public boolean hasNext() {
        return position < channels.size();
    }

    public Channel next() {
        return channels.get(position++);
    }
}
