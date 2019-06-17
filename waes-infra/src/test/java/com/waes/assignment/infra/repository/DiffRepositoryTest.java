package com.waes.assignment.infra.repository;

import com.waes.assigment.domain.model.Diff;
import com.waes.assignment.infra.repository.support.CoreTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;


public class DiffRepositoryTest extends CoreTestSupport {

    @Autowired
    private DiffRepository repository;


    @Test
    public void test_save_shouldSuccess() {
        Diff diff = repository.save(this.buildDiff());
        Assert.notNull(diff.getId());
    }

    private Diff buildDiff(){
        Diff diff = new Diff();
        diff.setSide("c2F2ZS1sZWZ0");
        return diff;
    }


}
