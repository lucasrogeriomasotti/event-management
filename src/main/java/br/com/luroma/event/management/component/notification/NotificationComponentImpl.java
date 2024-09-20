package br.com.luroma.event.management.component.notification;

import br.com.luroma.event.management.component.user.UserComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class NotificationComponentImpl implements NotificationComponent {
    private static Logger logger = LoggerFactory.getLogger(NotificationComponentImpl.class);
    private final UserComponent userComponent;

    NotificationComponentImpl(UserComponent userComponent) {
        this.userComponent = userComponent;
    }

    @Override
    public void notifyCertificateCreated(String userId, String eventId) {
        userComponent.getUser(userId).ifPresent(user -> {
            // TODO here we should send a notification to the user, for example an e-mail user.getEmail();
            logger.info("Notifying user {} that certificate was created", user.getEmail());
        });
    }
}
