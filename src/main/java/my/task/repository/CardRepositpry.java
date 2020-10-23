package my.task.repository;

import my.task.entity.Card;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CardRepositpry extends PagingAndSortingRepository<Card, Long> {
}
