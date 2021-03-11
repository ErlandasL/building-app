package com.erlandaslisauskas.buildingback.owner;

import com.erlandaslisauskas.buildingback.model.Owner;
import com.erlandaslisauskas.buildingback.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OwnerRepositoryTests {

    @MockBean
    private OwnerRepository ownerRepository;

    	@Test
	public void getOwnersTest() throws Exception {
		when(ownerRepository.findAll()).thenReturn(
				Stream.of(new Owner("ID1","testUsername1$", "testPassword1$"),
                        new Owner("ID2","testUsername2$", "testPassword2$"))
						.collect(Collectors.toList()));
		assertEquals(2, ownerRepository.findAll().size());
	}

//    @Test
//    public void getOwnerByPersonalNumber() {
//        String pNum = "ID1";
//        when(ownerRepository.findAll()).thenReturn(Stream.of(new Owner("ID1","testUsername1$", "testPassword1$"),
//                new Owner("ID2","testUsername2", "testPassword2")).collect(Collectors.toList()));
//        assertEquals("testUsername1$", ownerRepository.findByPersonalNumber(pNum).getFirstName());
//    }

	@Test
	public void saveOwnerTest() {
		Owner owner = new Owner("ID1","testUsername1$", "testPassword1$");
		when(ownerRepository.save(owner)).thenReturn(owner);
		assertEquals(owner, ownerRepository.save(owner));
	}

	@Test
	public void deleteOwnerTest() {
		Owner owner = new Owner("ID1","testUsername1$", "testPassword1$");
		ownerRepository.delete(owner);
		verify(ownerRepository, times(1)).delete(owner);
	}
}
