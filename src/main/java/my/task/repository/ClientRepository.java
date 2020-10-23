package my.task.repository;

import my.task.entity.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

    @Query("SELECT client.telephone FROM Client client, Card card WHERE client.id=card.id AND card.type=:typeCard AND card.currency=:currency")
    List<String> getTelephone(@Param("typeCard") String typeCard, @Param("currency") String currency, Pageable pageable);
}
