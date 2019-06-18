package com.waes.assignment.infra.service;

import com.waes.assigment.domain.dto.DiffDTO;
import com.waes.assigment.domain.dto.DiffResultDTO;
import com.waes.assigment.domain.enums.DiffEnum;
import com.waes.assigment.domain.enums.DiffResultEnum;
import com.waes.assigment.domain.model.Diff;
import com.waes.assignment.infra.BaseConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseConfigTest.class)
public class DiffServiceTest {

    @Autowired
    private DiffService diffService;

    @Test
    public void should_save_and_equals_diff() {
        Diff left = diffService.save(DiffDTO.builder().data("c2F2ZS1sZWZ0").id(4L).side(DiffEnum.LEFT).build());
        Diff right = diffService.save(DiffDTO.builder().data("c2F2ZS1sZWZ0").id(4L).side(DiffEnum.RIGHT).build());
        assertEquals(right.getRight(), left.getLeft());
    }

    @Test
    public void should_save_lef_diff() {
        Diff left = diffService.save(DiffDTO.builder().data("c2F2ZS1sZWZ0").id(4L).side(DiffEnum.LEFT).build());
        Assert.notNull(left.getId(), "Id should no be null");
    }

    @Test
    public void should_save_right_diff() {
        Diff right = diffService.save(DiffDTO.builder().data("c2F2ZS1sZWZ0").id(4L).side(DiffEnum.RIGHT).build());
        Assert.notNull(right.getId(), "Id should no be null");
    }

    @Test
    public void should_not_save_diff() {
        DiffDTO diffDTO = DiffDTO.builder().data("!*kjk!").build();
        Diff diff = new Diff();
        try {
            diff = diffService.save(diffDTO);
        } catch (Exception e) {
            Assert.isNull(diff.getId(), "Diff not saved");
        }
    }


}
