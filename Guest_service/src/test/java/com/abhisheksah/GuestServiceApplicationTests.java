package com.abhisheksah;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.abhisheksah.model.Guest;
import com.abhisheksah.repository.Repository;
import com.abhisheksah.services.GuestServiceImplement;

@SpringBootTest
@RunWith(SpringRunner.class)
class GuestServiceApplicationTests {

	@MockBean
	private Repository repository;
	
	@Autowired
	private GuestServiceImplement guestServiceImplement;

	// this is the test case for getallguest method that its working correctly or not
	@Test
	public void getAllGuest(){
		when(repository.findAll()).thenReturn(
				Stream.of(new Guest(1, 9876543210L,"tcs","abhi" , "abhi@com", "male","Indian"),
						new Guest(2, 8976543210L,"mahindra","Bhim" , "bhim@com", "male","Indian"))
				.collect(Collectors.toList()));
		assertEquals(2, guestServiceImplement.getAllGuest().size());
	}

	//this is the test case for getById method

	@Test
	public void GetByIdTest() {
		long guestId=1;
		Optional<Guest> guest=Optional.of(new Guest(1, 9876543210L,"tcs","abhi" , "abhi@com", "male","Indian"));
		when(repository.findById(guestId)).thenReturn(guest);
		assertEquals(guest, guestServiceImplement.getByGuestId(guestId));
	
	
	}
	

	
	//this is the method to check the add guest test
@Test	
public void addGuest() {
	Guest guest=new Guest(1, 9876543210L,"tcs","abhi" , "abhi@com", "male","Indian" );
	when(repository.save(guest)).thenReturn(guest);
	assertEquals(guest, guestServiceImplement.addGuest(guest));
}

//this is use to test the delete method 
@Test
public void deleteByIdTest() {
		long guestId=101;
		Guest guest=new Guest(guestId, 9876543210L,"tcs","abhi" , "abhi@com", "male","Indian" );
		guestServiceImplement.deleteById(guestId);
		verify(repository, times(1)).deleteById(guestId);
}



 
}