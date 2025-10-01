import java.util.ArrayList;
import java.util.List;

public class ChannelCollection {
    private List<Channel> channels = new ArrayList<>();

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    public ChannelIterator getIterator() {
        return new ChannelIteratorImpl(channels);
    }
}
