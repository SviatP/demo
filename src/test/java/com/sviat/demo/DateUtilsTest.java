package com.sviat.demo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import org.junit.Test;

import com.sviat.demo.utils.DateUtils;

public class DateUtilsTest {

	@Test
	public void fromStingWithoutTime() throws Exception {
		LocalDateTime testDate = DateUtils.fromStingWithoutTime("2020-06-03");
		assertThat(testDate.getYear(), is(2020));
		assertThat(testDate.getMonth().getValue(), is(6));
		assertThat(testDate.getDayOfMonth(), is(3));
	}

	@Test
	public void fromStingWithoutTime_incorrectDate() throws Exception {
		try {
			DateUtils.fromStingWithoutTime("2020-06-03 20:20:20");
			fail();
		} catch (DateTimeParseException exception) {
			assertTrue(exception.getMessage().contains("2020-06-03 20:20:20"));
		}
	}
}