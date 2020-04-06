package com.course.springcourse.repository;

import com.course.springcourse.domain.Request;
import com.course.springcourse.domain.User;
import com.course.springcourse.domain.enums.RequestState;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestRepositoryTests {
    @Autowired
    private RequestRepository requestRepository;

    public void AsaveTest() {
        User owner = new User();
        owner.setId(1L);

        Request request = new Request(null, "Novo laptop HP", "Pretendo obter um laptop",
                new Date(), RequestState.OPEN, owner, null);

        Request createdRequest = requestRepository.save(request);

        assertThat(createdRequest.getId()).isEqualTo(1L);
    }

    public void updateTest() {
        User owner = new User();
        owner.setId(1L);

        Request request = new Request(1L, "Novo laptop HP", "Pretendo obter um laptop HP",
                null, RequestState.OPEN, owner, null);

        Request updatedRequest = requestRepository.save(request);

        assertThat(updatedRequest.getDescription()).isEqualTo("Pretendo obter um laptop HP");
    }

    public void getByIdTest() {
        Optional<Request> result = requestRepository.findById(1L);
        Request request = result.get();

        assertThat(request.getSubject()).isEqualTo("Novo laptop HP");
    }

    public void listTest() {
        List<Request> requests = requestRepository.findAll();
        assertThat(requests.size()).isEqualTo(1);
    }

    public void listByOwnerIdTest() {
        List<Request> requests = requestRepository.findAllByOwnerId(1L);
        assertThat(requests.size()).isEqualTo(1);
    }

    public void updateStatusTest() {
        int affectedRows = requestRepository.updateStatus(1L, RequestState.IN_PROGRESS);
        assertThat(affectedRows).isEqualTo(1);
    }
}
