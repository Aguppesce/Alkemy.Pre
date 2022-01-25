package com.alkemy.disney.disney.repository.specification;

import com.alkemy.disney.disney.dto.CharcterFiltersDTO;
import com.alkemy.disney.disney.entity.Charcter;
import com.alkemy.disney.disney.entity.Movie;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class CharcterSpecification {
    public Specification<Charcter> getByFilters(CharcterFiltersDTO filtersDTO){
        return(root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filtersDTO.getName() + "%"
                        )
                );
            }

            if(!CollectionUtils.isEmpty(filtersDTO.getMovies())){
                Join<Movie, Charcter> join = root.join("movies", JoinType.INNER);
                Expression<String> moviesId = join.get("id");
                predicates.add(moviesId.in(filtersDTO.getMovies()));
            }

            query.distinct(true);
        }
        //name, age, weight, movies, order
    }
}
