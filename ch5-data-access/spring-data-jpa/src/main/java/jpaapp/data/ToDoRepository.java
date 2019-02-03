package jpaapp.data;

import org.springframework.data.repository.CrudRepository;

/*
 * ---------------------------------------------------------------------------------
 * Repositories
 * ---------------------------------------------------------------------------------
 * Repository - parent
 * CrudRepository - basic methods
 * JpaRepository - also implements PagingAndSortingRepository
 *
 * - ID needs to implement Serializable
 * - simple spring app requires @EnableJpaRepositories to trigger extra configuration
 *  -> spring boot takes care of that
 */
public interface ToDoRepository extends CrudRepository<ToDo, String> {
}
