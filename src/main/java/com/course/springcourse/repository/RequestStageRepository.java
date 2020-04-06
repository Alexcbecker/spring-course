package com.course.springcourse.repository;

import com.course.springcourse.domain.Request;
import com.course.springcourse.domain.RequestStage;
import com.course.springcourse.domain.enums.RequestState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {

    List<RequestStage> findAllByRequestId(Long id);

    @Query("UPDATE Request SET state = ?2 WHERE id = ?1")
    Request updateStatus(Long requestId, RequestState state);
}
