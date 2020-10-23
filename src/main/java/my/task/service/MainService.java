package my.task.service;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import my.task.dto.CardDto;
import my.task.dto.ClientDto;
import my.task.dto.ResponseCard;
import my.task.dto.ResponseClient;
import my.task.dto.ResponseTelephone;
import my.task.entity.Card;
import my.task.entity.Client;
import my.task.repository.CardRepositpry;
import my.task.repository.ClientRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@AllArgsConstructor
public class MainService {
    private final ClientRepository clientRepository;
    private final CardRepositpry cardRepository;

    private static final Map<String, Integer> statusMap = ImmutableMap.of(
            "Classic", 0,
            "Gold", 1,
            "Platinum", 2);

    public ResponseEntity createClient(ClientDto clientDto) {
        Client client = new Client();
        client.setFullName(clientDto.getFullName());
        client.setTelephone(clientDto.getTelephone());
        client.setEmail(clientDto.getEmail());
        return ResponseEntity.ok(new ResponseClient(clientRepository.save(client).getId()));
    }

    public ResponseEntity createCard(CardDto cardDto) {
        Client client = clientRepository.findById(cardDto.getClientId()).orElse(new Client());
        updateClientStatus(client, cardDto.getType());
        Card card = new Card();
        card.setNumber(cardDto.getNumber());
        card.setClient(client);
        card.setCurrency(cardDto.getCurrency());
        card.setType(cardDto.getType());
        return ResponseEntity.ok(new ResponseCard(cardRepository.save(card).getId()));
    }

    public ResponseEntity getTelephones(int pageNo, int pageRowCount, String typeCard, String currency) {
        return ResponseEntity.ok(
                new ResponseTelephone(
                        clientRepository.getTelephone(typeCard, currency, PageRequest.of(pageNo-1, pageRowCount))));
    }

    private void updateClientStatus(Client client, String type) {
        int statusNew = statusMap.get(type);
        if (statusNew > client.getStatus()) {
            client.setStatus(statusNew);
        }
        clientRepository.save(client);
    }
}
