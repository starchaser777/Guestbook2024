package kr.ac.kopo.guestbook2024.service;

import kr.ac.kopo.guestbook2024.dto.GuestbookDTO;
import kr.ac.kopo.guestbook2024.dto.PageRequestDTO;
import kr.ac.kopo.guestbook2024.dto.PageResultDTO;
import kr.ac.kopo.guestbook2024.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(25)
                .size(10)
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);
        List<GuestbookDTO> list = resultDTO.getDtoList(); // 참조변수 선언 - 여러 번 사용할 경우

        System.out.println("* start: " + resultDTO.getStart());
        System.out.println("* end: " + resultDTO.getEnd());
        System.out.println("* previous: " + resultDTO.isPrev());
        System.out.println("* next: " + resultDTO.isNext());

        for(GuestbookDTO guestbookDTO : list) {
            System.out.println(guestbookDTO);
        }

        for(Integer pageNum : resultDTO.getPageList()) {
            System.out.println(pageNum.intValue());
        }
    }

    @Test
    public void testSearchList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(25)
                .size(10)
                .type("tc") // 검색 조건
                .keyword("7") // 검색 키워드
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);
        List<GuestbookDTO> list = resultDTO.getDtoList(); // 참조변수 선언 - 여러 번 사용할 경우

        System.out.println("* start: " + resultDTO.getStart());
        System.out.println("* end: " + resultDTO.getEnd());
        System.out.println("* previous: " + resultDTO.isPrev());
        System.out.println("* next: " + resultDTO.isNext());

        for(GuestbookDTO guestbookDTO : list) {
            System.out.println(guestbookDTO);
        }

        for(Integer pageNum : resultDTO.getPageList()) {
            System.out.println(pageNum.intValue());
        }
    }
}
