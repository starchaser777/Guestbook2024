package kr.ac.kopo.guestbook2024.service;

import kr.ac.kopo.guestbook2024.dto.GuestbookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GuestServiceTests {

    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister() {
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("등록 연습 title 1")
                .content("등록 연습 content 1")
                .writer("등록 연습 writer 1")
                .build();

        service.register(guestbookDTO);
    }

}
