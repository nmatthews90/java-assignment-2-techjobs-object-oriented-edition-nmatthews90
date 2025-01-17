package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.Location;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job first_test_job;
    Job second_test_job;
    Job full_test_job;
    Job second_full_test_job;
    Job empty_field_test_job;

    @Before
    public void createJobObject() {
        first_test_job = new Job();
        second_test_job = new Job();

        full_test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        second_full_test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        empty_field_test_job = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        Assert.assertEquals(first_test_job.getId(), second_test_job.getId(), 1);
        Assert.assertNotEquals(first_test_job.getId(), second_test_job.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Assert.assertTrue(full_test_job.getName() instanceof String);
        Assert.assertTrue(full_test_job.getEmployer() instanceof Employer);
        Assert.assertTrue(full_test_job.getLocation() instanceof Location);
        Assert.assertTrue(full_test_job.getPositionType() instanceof PositionType);
        Assert.assertTrue(full_test_job.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Assert.assertFalse(first_test_job.equals(second_full_test_job));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Assert.assertEquals('\n',full_test_job.toString().charAt(0));
        Assert.assertEquals('\n', full_test_job.toString().charAt(full_test_job.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Assert.assertEquals("\nID: " + full_test_job.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n" , full_test_job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Assert.assertEquals("\nID: " + empty_field_test_job.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Data not available\nPosition Type: Quality control\nCore Competency: Persistence\n" , empty_field_test_job.toString());
    }



}
//        ID:  _______
//        Name: _______
//        Employer: _______
//        Location: _______
//        Position Type: _______
//        Core Competency: _______