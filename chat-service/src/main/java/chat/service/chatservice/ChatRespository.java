package chat.service.chatservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chat.service.chatservice.model.ChatEntity;


@Repository
public interface ChatRespository extends JpaRepository<ChatEntity, Long>{
    List<ChatEntity> findBySenderNameAndReceiverNameOrderByTimestampAsc(
        String senderName, String receiverName);

    List<ChatEntity> findByReceiverNameOrderByTimestampAsc(String receiverName);
}
