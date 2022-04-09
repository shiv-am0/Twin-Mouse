import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import utils.API;
import utils.CONSTANTS;

import java.util.Optional;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        DiscordBuilder discordBuilder = new DiscordBuilder();
        discordBuilder.getChannels();

        Optional<TextChannel> generaChannel = API.INSTANCE.getApi().getTextChannelById(CONSTANTS.GENERAL_CHANNEL);
        generaChannel.ifPresent(new Consumer<TextChannel>() {
            @Override
            public void accept(TextChannel textChannel) {
                textChannel.addMessageCreateListener(new MessageCreateListener() {
                    @Override
                    public void onMessageCreate(MessageCreateEvent event) {
                        String data = event.getMessageContent();
                        discordBuilder.fetchCoordinates(data);
                    }
                });
            }
        });
    }
}