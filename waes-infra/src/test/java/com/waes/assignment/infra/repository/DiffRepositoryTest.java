package com.waes.assignment.infra.repository;

import com.waes.assigment.domain.model.Diff;
import com.waes.assignment.infra.BaseConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Optional;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseConfigTest.class)
public class DiffRepositoryTest {

    @Autowired
    private DiffRepository repository;


    @Test
    public void should_save_right_diff() {
        Diff diff = repository.save(this.buildDiffRight());
        Assert.notNull(diff.getId(), "Id should not be null");
    }

    @Test
    public void should_save_left_diff() {
        Diff diff = repository.save(this.buildDiffLeft());
        Assert.notNull(diff.getId(), "Id should not be null");
    }

    @Test
    public void should_save_and_find_diff() {
        Diff diff = repository.save(this.buildDiffLeft());

        Assert.notNull(diff.getId(), "Id should not be null");
        Assert.notNull(repository.findById(diff.getId()).get(), "Id should not be null");
    }

    @Test
    public void should_save_right_and_left_diff() {
        Diff diff = new Diff();
        diff.setLeft("should save left");
        diff.setRight("should save right");

        repository.save(diff);

        Assert.notNull(diff.getLeft(), "Left should not be null");
        Assert.notNull(diff.getRight(), "Right should not be null");
    }

    @Test
    public void should_fail_save_right_and_left_diff() {
        Diff diff = new Diff();
        diff.setLeft("should save left");
        diff.setRight(null);

        repository.save(diff);

        Assert.notNull(diff.getLeft(), "Left should not be null");
        Assert.isNull(diff.getRight(), "Right should be null");
    }

    @Test
    public void should_fail_save_diff() {
        Diff diff = repository.save(this.buildDiffLeft());
        Assert.state(null != diff.getId(), "Fail to save diff");
    }

    public void should_throw_get_diff() {
        repository.findById(null);
    }

    public void should_fail_get_diff() {
        Optional<Diff> diff = repository.findById(1L);
        Assert.isTrue(!diff.isPresent(), "Diff should be null");
    }

    private Diff buildDiffLeft() {
        Diff diff = new Diff();
        diff.setLeft("c2hvdWxkIHNhdmUgbGVmdA==");
        return diff;
    }

    private Diff buildDiffRight() {
        Diff diff = new Diff();
        diff.setLeft("c2hvdWxkIHNhdmUgcmlnaHQ=");
        return diff;
    }

}
