package com.course.springcourse.repository;

import com.course.springcourse.domain.Request;
import com.course.springcourse.domain.RequestStage;
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
public class RequestStageRepositoryTests {
    @Autowired
    private RequestStageRepository requestStageRepository;

    @Test
    public void AsaveTest() {
        User owner = new User();
        owner.setId(1L);

        Request request = new Request();
        request.setId(1L);

        RequestStage stage = new RequestStage(null, "Foi comprado um novo laptop", new Date(),
               RequestState.CLOSED, request, owner);

        RequestStage createdStage = requestStageRepository.save(stage);

        assertThat(createdStage.getId()).isEqualTo(1L);
    }

    @Test
    public void getByIdTest() {
        Optional<RequestStage> result = requestStageRepository.findById(1L);

        RequestStage stage = result.get();

        assertThat(stage.getDescription()).isEqualTo("Foi comprado um novo laptop");
    }

    @Test
    public void listByRequestIdTest() {
        List<RequestStage> stages = requestStageRepository.findAll();
        assertThat(stages.size()).isEqualTo(1);
    }
}
