package com.hilti.nitin_framework.configs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Messaging configuration class.
 * Keeps : default topic, MessagingTech used currently
 */
@Getter
@Setter
@AllArgsConstructor
public class MessagingConfig {
    private String defaultTopicName;
    private MessagingTech messagingTech;
}
