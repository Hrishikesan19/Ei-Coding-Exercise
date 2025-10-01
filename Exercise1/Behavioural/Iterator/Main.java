public class Main {
    public static void main(String[] args) {
        ChannelCollection collection = new ChannelCollection();
        collection.addChannel(new Channel("HBO"));
        collection.addChannel(new Channel("Netflix"));
        collection.addChannel(new Channel("Disney+"));

        ChannelIterator iterator = collection.getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}
