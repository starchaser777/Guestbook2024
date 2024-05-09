package kr.ac.kopo.guestbook2024.service;

import kr.ac.kopo.guestbook2024.dto.GuestbookDTO;
import kr.ac.kopo.guestbook2024.entity.Guestbook;
import kr.ac.kopo.guestbook2024.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class GuestbookServiceImpl implements GuestbookService {

    private final GuestbookRepository repository; // final이 꼭 들어가야 함.
    @Override
    public Long register(GuestbookDTO dto) {

        Guestbook entity = dtoToEntity(dto);
        repository.save(entity);

        return entity.getGno();
    }
}
