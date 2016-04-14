package com.smapley.db.modes;

import com.smapley.bean.Message;
import com.smapley.db.entity.MessageEntity;
import com.smapley.db.entity.UserEntity;

public class MessageMode {

	private MessageEntity messageEntity;
	private UserEntity userEntity;

	public MessageMode(Message message, long time) {
		if (message.getRefresh().getTime() > time)
			setMessageEntity(new MessageEntity(message));
		if (message.getUserBySrcUseId().getRefresh().getTime() > time) {
			setUserEntity(new UserEntity(message.getUserBySrcUseId()));
		}

	}

	public MessageEntity getMessageEntity() {
		return messageEntity;
	}

	public void setMessageEntity(MessageEntity messageEntity) {
		this.messageEntity = messageEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

}
