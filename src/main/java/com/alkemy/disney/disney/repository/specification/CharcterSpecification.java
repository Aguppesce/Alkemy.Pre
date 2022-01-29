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
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Component
public class CharcterSpecification {
    public Specification<Charcter> getByFilters(CharcterFiltersDTO filtersDTO){

        return(root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            //Name specification
            if(StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filtersDTO.getName() + "%"
                        )
                );
            }

            //Age specification
            if(filtersDTO.getAge() != null){
                predicates.add(
                        criteriaBuilder.equal((root.get("age")),
                                filtersDTO.getAge())
                );
            }

            //Movies specification
            if(!CollectionUtils.isEmpty(filtersDTO.getMovies())){
                Join<Movie, Charcter> join = root.join("movies", JoinType.INNER);
                Expression<String> moviesId = join.get("id");
                predicates.add(moviesId.in(filtersDTO.getMovies()));
            }

            //Remove duplicates
            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
